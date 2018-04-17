package controller.view;

import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by 777 on 20.02.2018.
 */
public class AuthorController {

    private MainMenu mainMenu;
    private Stage primaryStage;
    private Stage stage;

    public void setMainMenu(MainMenu mainMenu) { this.mainMenu = mainMenu; }

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleClose() {

        primaryStage.show();
        stage.close();
    }
}
