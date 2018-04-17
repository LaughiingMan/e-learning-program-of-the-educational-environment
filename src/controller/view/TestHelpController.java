package controller.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by 777 on 28.02.2018.
 */
public class TestHelpController {

    private Stage stage;

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleClose() {

        stage.close();
    }
}
