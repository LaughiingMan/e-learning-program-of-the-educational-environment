package controller.view;

import controller.model.HelpList;
import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 777 on 24.02.2018.
 */
public class TestController {

    @FXML
    private Text text;

    @FXML
    private CheckBox checkBoxOne;

    @FXML
    private CheckBox checkBoxTwo;

    @FXML
    private CheckBox checkBoxThree;

    @FXML
    private CheckBox checkBoxFour;

    @FXML
    private Button button;

    @FXML
    private MenuItem menuStart;

    @FXML
    private Label label;

    private MainMenu menu;
    private Stage primaryStage;
    private Stage stage;
    private List<HelpList> list;
    private StringBuilder countAnwer;
    private int index = 0;
    private int indexAnswer = 0;
    private int indexCheck = 0;
    private boolean checkLoad = false;
    private File fileName;

    public void setMenu(MainMenu menu) { this.menu = menu; }

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleStart() {

        checkBoxOne.setVisible(true);
        checkBoxTwo.setVisible(true);
        checkBoxThree.setVisible(true);
        checkBoxFour.setVisible(true);
        button.setVisible(true);
        checkLoad = false;
        menuStart.setDisable(true);
        //shouldAttempt();
        loadQuestTest();
    }

    @FXML
    private void handleStartLoad() {

        checkBoxOne.setVisible(true);
        checkBoxTwo.setVisible(true);
        checkBoxThree.setVisible(true);
        checkBoxFour.setVisible(true);
        button.setVisible(true);
        checkLoad = true;
        FileChooser file = new FileChooser();
        fileName = file.showOpenDialog(stage);
        menuStart.setDisable(false);
        clearAttempt();
        //shouldAttempt();
        loadQuestTest();
    }

    @FXML
    private void handleHelp() {

        menu.showLoreHelp();
    }

    @FXML
    private void handleRefresh() {

        index = 0;
        indexAnswer = 0;
        indexCheck = 0;
        list.clear();
        checkBoxOne.setSelected(false);
        checkBoxTwo.setSelected(false);
        checkBoxThree.setSelected(false);
        checkBoxFour.setSelected(false);
        //shouldAttempt();
        loadQuestTest();
    }

    @FXML
    private void handleNext() {

        countAnwer = new StringBuilder();

        if(checkBoxOne.isSelected()) { countAnwer.append("1"); }
        if(checkBoxTwo.isSelected()) { countAnwer.append("2"); }
        if(checkBoxThree.isSelected()) { countAnwer.append("3"); }
        if(checkBoxFour.isSelected()) { countAnwer.append("4"); }

        String[] result = list.get(indexAnswer).getQuestion().split("\\&");
        result[1] = result[1].replaceAll("\n","");
        if(countAnwer.toString().equals(result[1])) { indexCheck++; }

        if(index < list.size()) {

            ShowFileList();
        } else {

            if(indexCheck >= list.size()) {

                primaryStage.show();
                clearAttempt();
            }
        }
        indexAnswer++;
        checkBoxOne.setSelected(false);
        checkBoxTwo.setSelected(false);
        checkBoxThree.setSelected(false);
        checkBoxFour.setSelected(false);
    }

    @FXML
    private void handleClose() {

        primaryStage.show();
        stage.close();
    }

    private void loadQuestTest() {

        list = new ArrayList<>();

        try {
            BufferedReader br = null;
            if(checkLoad) {

                br = new BufferedReader(new FileReader(fileName.getAbsolutePath()));
            } else {
                InputStream inStream = RecourceLoader.getFile("QuestTest");
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
        ShowFileList();
    }

    private void addFileList(String s) {

        HelpList helpList = new HelpList(s);
        list.add(helpList);

    }

    private void ShowFileList() {

        int count = 0;
        String[] result = list.get(index).getQuestion().split("\\*");
        result[result.length - 1] = result[result.length - 1].split("\\&")[0];
        text.setText(result[count]);
        checkBoxOne.setText(result[++count]);
        checkBoxTwo.setText(result[++count]);
        checkBoxThree.setText(result[++count]);
        checkBoxFour.setText(result[++count]);
        index++;
    }

    /*
    private void shouldAttempt() {

        try {
            Enumeration<URL> rir = URLClassLoader.getSystemResources("newFile/attemptLore");
            InputStream inStream = new FileInputStream(String.valueOf(rir));
            InputStreamReader str = new InputStreamReader(inStream);
            BufferedReader br = new BufferedReader(str);
            String result = null;
            String s = null;

            while((s = br.readLine()) != null) {

                result = s;
            }

            br.close();
            result = result.replaceAll("\\D", "");
            label.setText(result);
            int count = Integer.parseInt(result);

            String dir = TestController.class.getClassLoader().getResource("attemptLore").getFile();
            //String dir = WriteResource.class.getResource("/dir").getFile();
            OutputStream os = new FileOutputStream(dir);
            final PrintStream printStream = new PrintStream(os);
            printStream.println(++count);
            printStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    */

    private void clearAttempt() {

        try {
            PrintWriter pw = new PrintWriter(new File(this.getClass().getResource("res/files/attemptLore").getPath()));
            pw.write(0);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
