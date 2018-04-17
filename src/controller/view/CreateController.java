package controller.view;

import controller.model.HelpList;
import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 777 on 07.03.2018.
 */
public class CreateController {

    @FXML
    private TextArea text;

    private MainMenu menu;
    private Stage primaryStage;
    private Stage stage;
    private List<HelpList> resultCreate = new ArrayList<>();

    public void setMenu(MainMenu menu) { this.menu = menu; }

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleCreate() {

        resultCreate.clear();
        clear();
    }

    @FXML
    private void handleSave() {

        HelpList help = new HelpList(text.getText());
        resultCreate.add(help);
        clear();

        FileChooser file = new FileChooser();
        saveFile(file.showSaveDialog(stage));
    }

    @FXML
    private void handleNext() {

        HelpList help = new HelpList(text.getText());
        resultCreate.add(help);
        clear();

    }

    @FXML
    private void handleHelp() {

        menu.showCreateHelp();
    }

    @FXML
    private void handleHelpTwo() {

        menu.showCreateHelpTwo();
    }

    @FXML
    private void handleClose() {

        primaryStage.show();
        stage.close();
    }

    public void saveFile(File file) {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            boolean count = true;

            for(HelpList s : resultCreate) {

                if (count) {
                    writer.write(s.getQuestion());
                    count = false;
                } else {
                    writer.write("\n" + "/" + s.getQuestion());
                }
            }

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clear() {

        text.setText("");
        text.requestFocus();
    }
}
