package com.example.sportsCompetitionManagement.utils;

import com.example.sportsCompetitionManagement.Main;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Utils {

    //утилитные методы для открытия окон
    public static void launchAdminAuthorization() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("adminAuthorization.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 346, 422);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void launchAuthorizationMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("autorizationM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 346, 293);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void launchManagementMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("managementM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void launchViewWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("viewWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void launchViewMembersWindow() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("viewMembersWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }


    public static void launchAddEventMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addEventM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 277, 284);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public static void launchAddMembersMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("addMembersM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        Stage stage = new Stage();
        stage.setTitle("Управление соревнованиями");

        Image image = new Image(new File("src/main/resources/pictures/icon.png").toURI().toString());

        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);

    }

    //метод для закрытия предыдущего окна
    public static void closeCurrentWindow(Event event){
        ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
}
