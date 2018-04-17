package controller.view;

import controller.model.HelpList;
import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 777 on 28.02.2018.
 */
public class TaskController {

    @FXML
    private TextArea text;

    @FXML
    private CheckBox checkBoxOne;

    @FXML
    private CheckBox checkBoxTwo;

    @FXML
    private CheckBox checkBoxThree;

    @FXML
    private CheckBox checkBoxFour;

    @FXML
    private CheckBox checkBoxFive;

    @FXML
    private Button button;

    private Stage primaryStage;
    private Stage stage;
    private MainMenu menu;
    private List<HelpList> list;
    private List<String> listResult;
    private StringBuilder countAnwer;
    private int index = 0;
    private int indexAnswer = 0;
    private int indexCheck = 0;
    private boolean checkLoad = false;
    private File fileName;

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public void setStage(Stage stage) { this.stage = stage; }

    public void setMenu(MainMenu menu) { this.menu = menu; }

    @FXML
    private void handleStart() {

        text.setVisible(true);
        checkBoxOne.setVisible(true);
        checkBoxTwo.setVisible(true);
        checkBoxThree.setVisible(true);
        checkBoxFour.setVisible(true);
        checkBoxFive.setVisible(true);
        button.setVisible(true);
        checkLoad = false;
        loadQuestTask();
    }

    @FXML
    private void handleStartLoad() {

        text.setVisible(true);
        checkBoxOne.setVisible(true);
        checkBoxTwo.setVisible(true);
        checkBoxThree.setVisible(true);
        checkBoxFour.setVisible(true);
        checkBoxFive.setVisible(true);
        button.setVisible(true);
        checkLoad = true;
        FileChooser file = new FileChooser();
        fileName = file.showOpenDialog(stage);
        loadQuestTask();
    }

    @FXML
    private void handleNext() {

        countAnwer = new StringBuilder();

        if(checkBoxOne.isSelected()) { countAnwer.append("1"); }
        if(checkBoxTwo.isSelected()) { countAnwer.append("2"); }
        if(checkBoxThree.isSelected()) { countAnwer.append("3"); }
        if(checkBoxFour.isSelected()) { countAnwer.append("4"); }
        if(checkBoxFive.isSelected()) { countAnwer.append("5"); }

        String[] result = listResult.get(indexAnswer).split("\\&");
        result[1] = result[1].replaceAll("\n","");
        if(countAnwer.toString().equals(result[1])) { indexCheck++; }

        if(index < listResult.size()) {

            ShowFileList();
        } else {

            if(indexCheck >= listResult.size()) { primaryStage.show(); }
        }
        indexAnswer++;
        checkBoxOne.setSelected(false);
        checkBoxTwo.setSelected(false);
        checkBoxThree.setSelected(false);
        checkBoxFour.setSelected(false);
        checkBoxFive.setSelected(false);
    }

    @FXML
    private void handleRefresh() {

        index = 0;
        indexAnswer = 0;
        indexCheck = 0;
        list.clear();
        listResult.clear();
        checkBoxOne.setSelected(false);
        checkBoxTwo.setSelected(false);
        checkBoxThree.setSelected(false);
        checkBoxFour.setSelected(false);
        checkBoxFive.setSelected(false);
        loadQuestTask();
    }

    @FXML
    private void handleClose() {

        primaryStage.show();
        stage.close();
    }

    @FXML
    private void handleHelp() {

        menu.showSkillHelp();
    }

    private void loadQuestTask() {

        list = new ArrayList<>();

        try {
            BufferedReader br = null;
            if(checkLoad) {
                br = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
            } else {
                InputStream inStream = RecourceLoader.getFile("QuestTask");
                InputStreamReader str = new InputStreamReader(inStream);
                br = new BufferedReader(str);
            }
            StringBuilder sb = new StringBuilder();
            String s = null;

            while((s = br.readLine()) != null) {

                sb.append(s + "\n");
            }

            String[] result = sb.toString().split("/");

            for(String temp : result) {
                addFileList(temp);
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Collections.shuffle(list);
        listResult = new ArrayList<>();
        for(HelpList temp : list) {
            String[] result = temp.getQuestion().split("\\*");
            for (String resultSize : result) { listResult.add(resultSize); }
        }
        ShowFileList();
    }

    private void addFileList(String s) {

        HelpList helpList = new HelpList(s);
        list.add(helpList);

    }

    private void ShowFileList() {

        String result = listResult.get(index).split("\\&")[0];
        if(!result.contains("г)")) {
            checkBoxFour.setVisible(false);
            checkBoxFive.setVisible(false);
        } else if(result.contains("г)") && result.contains("д)")) {
            checkBoxFour.setVisible(true);
            checkBoxFive.setVisible(true);
        } else if(result.contains("г)")) {
            checkBoxFour.setVisible(true);
            checkBoxFive.setVisible(false);
        }
        text.setText(result);
        index++;
    }
}
