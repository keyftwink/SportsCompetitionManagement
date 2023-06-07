package com.example.sportsCompetitionManagement.windows;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import tornadofx.control.DateTimePicker;

import static com.example.sportsCompetitionManagement.utils.Utils.*;
import static com.example.sportsCompetitionManagement.utils.DataBaseUtils.*;


public class AddEventMenu {

    @FXML
    private DateTimePicker dateTimePicker;
    @FXML
    private TextField locationTextField;
    @FXML
    private TextField nameTextField;

    @FXML
    void onAcceptButton(ActionEvent event) {

        if (nameTextField.getText().isEmpty() || locationTextField.getText().isEmpty() || dateTimePicker.toString().isEmpty()){
            return;
        }

        String dbevents = "INSERT events(name, location, date) VALUES ('" + nameTextField.getText() + "', '" +  locationTextField.getText() + "', '" + dateTimePicker.getDateTimeValue().toString() + "')";

        dataBaseEdit(dbevents);

        closeCurrentWindow(event);
    }
}
