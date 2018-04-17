package controller.view;

import controller.MainMenu;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

/**
 * Created by 777 on 25.02.2018.
 */
public class TheoryController {

    @FXML
    private TextArea textOne;

    private Stage primaryStage;
    private Stage stage;
    private MainMenu menu;

    public void setPrimaryStage(Stage primaryStage) { this.primaryStage = primaryStage; }

    public void setStage(Stage stage) { this.stage = stage; }

    public void setMenu(MainMenu menu) { this.menu = menu; }

    @FXML
    private void handleSectionOne() {

        try {
            InputStream inputStream = RecourceLoader.getFile("SekOne");
            InputStreamReader reader = new InputStreamReader(inputStream);
            BufferedReader br = new BufferedReader(reader);
            StringBuilder sb = new StringBuilder();
            String s = null;

            while ((s = br.readLine()) != null) {

                sb.append(s + "\n");
            }

            textOne.setText(sb.toString());

        } catch(IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void handleSectionTwo() {

    }

    @FXML
    private void handleSectionThree() {

    }

    @FXML
    private void handleSectionFour() {

    }

    @FXML
    private void handleClose() {

        primaryStage.show();
        stage.close();
    }
}
