package controller;

import controller.view.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sun.applet.Main;

import java.io.IOException;

/**
 * Created by 777 on 02.02.2018.
 */
public class MainMenu extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Образовательная среда");

        initRootLayout();
    }

    public void initRootLayout() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/LoginLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Вход");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            LoginController login = loader.getController();
            login.setStage(stage);
            login.setMenu(this);

            stage.show();
            stage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showOverview() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/RootMenu.fxml"));
            AnchorPane overPane = (AnchorPane) loader.load();

            Scene scene = new Scene(overPane);
            primaryStage.setScene(scene);

            ButtonController controller = loader.getController();
            controller.setMenu(this);
            controller.setPrimaryStage(primaryStage);
            controller.setLabel(LoginController.getGreetPeople());

            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showAuthor() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/AuthorLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Автор");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            AuthorController author = loader.getController();
            author.setMainMenu(this);
            author.setPrimaryStage(primaryStage);
            author.setStage(stage);

            stage.show();
            primaryStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStartLore() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/TestLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Тестирование");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            TestController test = loader.getController();
            test.setMenu(this);
            test.setPrimaryStage(primaryStage);
            test.setStage(stage);

            stage.show();
            primaryStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStartSkill() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/TaskLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Задание");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            TaskController task = loader.getController();
            task.setPrimaryStage(primaryStage);
            task.setStage(stage);
            task.setMenu(this);

            stage.show();
            primaryStage.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showTheory() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/TheoryLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Теория");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            TheoryController theory = loader.getController();
            theory.setMenu(this);
            theory.setPrimaryStage(primaryStage);
            theory.setStage(stage);

            stage.show();
            primaryStage.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showLoreHelp() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/TestHelpLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Помощь");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            TestHelpController testHelp = loader.getController();
            testHelp.setStage(stage);

            stage.setResizable(false);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSkillHelp() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/TaskHelpLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Помощь");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            TaskHelpController taskHelp = loader.getController();
            taskHelp.setStage(stage);

            stage.show();
            stage.setResizable(false);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreate() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/CreateLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Редактирование");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            CreateController create = loader.getController();
            create.setMenu(this);
            create.setPrimaryStage(primaryStage);
            create.setStage(stage);

            stage.show();
            primaryStage.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateHelp() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/CreateHelpLayout.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Помощь");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            CreateHelpController createHelp = loader.getController();
            createHelp.setStage(stage);

            stage.show();
            stage.setResizable(false);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void showCreateHelpTwo() {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainMenu.class.getResource("view/CreateHelpLayoutTwo.fxml"));
            AnchorPane anchorPane = (AnchorPane) loader.load();

            Stage stage = new Stage();
            stage.setTitle("Помощь");

            Scene scene = new Scene(anchorPane);
            stage.setScene(scene);

            CreateHelpTwoController createHelp = loader.getController();
            createHelp.setStage(stage);

            stage.show();
            stage.setResizable(false);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Stage getPrimaryStage() { return primaryStage; }

    public static void main(String[] args) {

        launch(args);
    }
}
