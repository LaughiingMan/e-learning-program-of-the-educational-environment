package controller.view;

import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * Created by 777 on 02.02.2018.
 */
public class ButtonController {

    @FXML
    private Button buttonLore;

    @FXML
    private Button buttonSkill;

    @FXML
    private Label label;

    private MainMenu menu;
    private boolean visibleButton = true;
    private Stage primaryStage;

    public void setMenu(MainMenu menu) { this.menu = menu; }

    public void setLabel(String name) { label.setText(name); }

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    @FXML
    private void handleStartLore() {

        menu.showStartLore();
    }

    @FXML
    private void handleStartSkill() {

        menu.showStartSkill();
    }

    @FXML
    private void enteredStart() {

        if(visibleButton) {
            buttonLore.setVisible(true);
            buttonSkill.setVisible(true);
            visibleButton = false;
        } else {
            buttonLore.setVisible(false);
            buttonSkill.setVisible(false);
            visibleButton = true;
        }
    }

    @FXML
    private void handleChange() {

        menu.initRootLayout();
        primaryStage.close();
    }

    @FXML
    private void handleTheory() {

        menu.showTheory();
    }

    @FXML
    private void handleInstruction() {

    }

    @FXML
    private void handleCreate() {

        menu.showCreate();
    }

    @FXML
    private void handleAuthor() {

        menu.showAuthor();
    }

    @FXML
    private void handleExit() {

        System.exit(0);
    }
}
