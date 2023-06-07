package com.example.sportsCompetitionManagement.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

import static com.example.sportsCompetitionManagement.utils.Utils.*;


public class AuthorizationMenu {


    //кнопка для авторизации администратора
    @FXML
    void onAdminLoginButtonClick(ActionEvent event) throws IOException {

        launchAdminAuthorization();
        closeCurrentWindow(event);

    }

    //кнопка для авторизации гостя
    @FXML
    void onGuestLoginButtonClick(ActionEvent event) throws IOException {

        launchViewWindow();
        closeCurrentWindow(event);
    }

}