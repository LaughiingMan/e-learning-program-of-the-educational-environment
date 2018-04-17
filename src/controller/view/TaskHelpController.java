package controller.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by 777 on 02.03.2018.
 */
public class TaskHelpController {

    private Stage stage;

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleClose() {

        stage.close();
    }
}
