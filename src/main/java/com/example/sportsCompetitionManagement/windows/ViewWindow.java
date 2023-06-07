package com.example.sportsCompetitionManagement.windows;

import com.example.sportsCompetitionManagement.SportEvent;
import com.example.sportsCompetitionManagement.utils.DataBaseConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import static com.example.sportsCompetitionManagement.utils.DataBaseUtils.createDataBaseTable;
import static com.example.sportsCompetitionManagement.utils.DataBaseUtils.dataBaseEdit;
import static com.example.sportsCompetitionManagement.utils.Utils.*;

public class ViewWindow implements Initializable {

    @FXML
    private TableColumn<Object, String> eventDate;

    @FXML
    private TableColumn<Object, String> eventLocation;

    @FXML
    private TableColumn<Object, String> eventName;

    @FXML
    private TableView<SportEvent> tableView;

    static SportEvent sportEvent1 = new SportEvent();

    ObservableList<SportEvent> events = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        downloadData();
    }

    @FXML
    void membersButton(ActionEvent event) throws SQLException, IOException {

        ObservableList<SportEvent> selectedRows, allEvents;

        selectedRows = tableView.getSelectionModel().getSelectedItems();

        for (SportEvent sportEvent : selectedRows) {
            sportEvent1.setEventId(sportEvent.getEventId());
            sportEvent1.setName(sportEvent.getName());

            createDataBaseTable(sportEvent.getEventId());
            launchViewMembersWindow();

        }
    }
    @FXML
    void backButton(ActionEvent event) throws IOException {

        closeCurrentWindow(event);
        launchAuthorizationMenu();
    }


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

    public static SportEvent getSportEvent1(){
        return sportEvent1;
    }


}
