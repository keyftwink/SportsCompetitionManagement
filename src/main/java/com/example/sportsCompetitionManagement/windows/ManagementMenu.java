package com.example.sportsCompetitionManagement.windows;

import com.example.sportsCompetitionManagement.SportEvent;
import com.example.sportsCompetitionManagement.utils.DataBaseConnection;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.sportsCompetitionManagement.utils.Utils.*;
import static com.example.sportsCompetitionManagement.utils.DataBaseUtils.*;



public class ManagementMenu implements Initializable {

    @FXML
    private TableView<SportEvent> tableView;

    @FXML
    private TableColumn<Object, String> eventDate;

    @FXML
    private TableColumn<Object, String> eventLocation;

    @FXML
    private TableColumn<Object, String> eventName;


    static SportEvent sportEvent1 = new SportEvent();

    ObservableList<SportEvent> events = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        downloadData();
    }
    @FXML
    void addButton(ActionEvent event) throws IOException {

        launchAddEventMenu();
    }
    //перезагрузка данных меню
    @FXML
    void refreshButton(ActionEvent event) throws SQLException {

        downloadData();

    }

    //удаление соревнования
    @FXML
    void deleteButton(ActionEvent event) {

        ObservableList<SportEvent> selectedRows, allEvents;

        allEvents = tableView.getItems();
        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (SportEvent sportEvent : selectedRows) {

            String dbevent = "DELETE FROM events WHERE idevents = " + sportEvent.getEventId();
            dataBaseEdit(dbevent);

            allEvents.remove(sportEvent);

        }
    }

    @FXML
    void membersButton(ActionEvent event) throws SQLException, IOException {

        ObservableList<SportEvent> selectedRows, allEvents;

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (SportEvent sportEvent : selectedRows) {
            sportEvent1.setEventId(sportEvent.getEventId());
            sportEvent1.setName(sportEvent.getName());

            createDataBaseTable(sportEvent.getEventId());
            launchAddMembersMenu();

        }
    }


    //метод для загрузки данных из базы данных
    public void downloadData(){
        tableView.getItems().clear();

        DataBaseConnection connectNow = new DataBaseConnection();
        Connection connectDB = connectNow.getDBConnection();

        String eventViewQuery = "SELECT idevents, name, location, date FROM events";

        try{

            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(eventViewQuery);

            while (queryOutput.next()){

                Integer queryID = queryOutput.getInt("idevents");
                String queryName = queryOutput.getString("name");
                String queryLocation = queryOutput.getString("location");
                String queryData= queryOutput.getString("date");

                events.add(new SportEvent(queryID, queryName, queryLocation, queryData));

            }
        } catch (SQLException e) {
            Logger.getLogger(ManagementMenu.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }

        eventName.setCellValueFactory(new PropertyValueFactory<>("name"));
        eventLocation.setCellValueFactory(new PropertyValueFactory<>("location"));
        eventDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.setItems(events);
        eventName.setCellFactory(TextFieldTableCell.forTableColumn());
        eventLocation.setCellFactory(TextFieldTableCell.forTableColumn());
        eventDate.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {

        closeCurrentWindow(event);
        launchAuthorizationMenu();
    }

    public static SportEvent getSportEvent1(){
        return sportEvent1;
    }

}
