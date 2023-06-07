package com.example.sportsCompetitionManagement.windows;

import com.example.sportsCompetitionManagement.Member;
import com.example.sportsCompetitionManagement.utils.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.sportsCompetitionManagement.utils.DataBaseUtils.dataBaseEdit;

public class ViewMembersWindow implements Initializable {

    @FXML
    private Label eventName;

    @FXML
    private TableView<Member> membersTableView;

    @FXML
    private TableColumn<Object, String> name;

    @FXML
    private TableColumn<Object, String> patronymic;

    @FXML
    private TableColumn<Object, String> surname;

    ObservableList<Member> members = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        downloadData();

        eventName.setText(ViewWindow.getSportEvent1().getName());
    }


    //загрузка данных из базы данных
    public void downloadData(){

        membersTableView.getItems().clear();

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getDBConnection();

        String eventViewQuery = "SELECT surname, name, patronymic FROM " + ViewWindow.getSportEvent1().getEventId() +  "members";


        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(eventViewQuery);

            while (queryOutput.next()){

                String querySurname = queryOutput.getString("surname");
                String queryName = queryOutput.getString("name");
                String queryPatronymic= queryOutput.getString("patronymic");

                members.add(new Member(querySurname, queryName, queryPatronymic));

            }
        } catch (SQLException e) {
            Logger.getLogger(ManagementMenu.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        patronymic.setCellValueFactory(new PropertyValueFactory<>("patronymic"));

        membersTableView.setItems(members);
        surname.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        patronymic.setCellFactory(TextFieldTableCell.forTableColumn());
    }
}
