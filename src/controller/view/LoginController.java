package controller.view;

import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by 777 on 13.03.2018.
 */
public class LoginController {

    @FXML
    private TextField textName;

    @FXML
    private TextField textMail;

    private Stage stage;
    private MainMenu menu;
    private static String greetPeople;

    public void setStage(Stage stage) { this.stage = stage; }

    public void setMenu(MainMenu menu) { this.menu = menu; }

    public static String getGreetPeople() { return greetPeople; }

    @FXML
    private void handleLogin() {

        if(!textName.getText().equals("") && !textMail.getText().equals("")) {
            if(isValidMail(textMail.getText())) {
                greetPeople = "Здравствуй, " + textName.getText();
                menu.showOverview();
                stage.close();
            } else {

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.initOwner(stage);
                alert.setTitle("Ошибка");
                alert.setHeaderText("Ошибка");
                alert.setContentText("Почта недействительна!");
                alert.showAndWait();
            }
        } else {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(stage);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Ошибка");
            alert.setContentText("Заполните пустые поля!");
            alert.showAndWait();
        }
    }

    public boolean isValidMail(String emailAddress) {

        return emailAddress.matches(".+@.+\\.[a-z]+") && emailAddress.contains(" ") == false;
    }
}
