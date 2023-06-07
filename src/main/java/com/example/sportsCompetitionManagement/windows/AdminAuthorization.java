package com.example.sportsCompetitionManagement.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.sportsCompetitionManagement.utils.Utils.*;


public class AdminAuthorization {

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldPassword;

    private static final String LOGIN = "org123";
    private static final String PASSWORD = "1234";

    @FXML
    void onBackButtonClick(ActionEvent event) throws IOException {

        launchAuthorizationMenu();

        closeCurrentWindow(event);

    }

    //авторизация администратора
    @FXML
    void onLoginButtonClick(ActionEvent event) throws IOException {

        if(textFieldLogin.getText().equalsIgnoreCase(LOGIN) &&  textFieldPassword.getText().equals(PASSWORD)){
            launchManagementMenu();
            closeCurrentWindow(event);
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Неверный логин или пароль");

            alert.showAndWait().ifPresent(rs -> {
                if (rs == ButtonType.OK) {
                    System.out.println("Pressed OK.");
                }
            });
        }

    }
}
