package controller.view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by 777 on 12.03.2018.
 */
public class CreateHelpTwoController {

    private Stage stage;

    public void setStage(Stage stage) { this.stage = stage; }

    @FXML
    private void handleClose() {

        stage.close();
    }
}
