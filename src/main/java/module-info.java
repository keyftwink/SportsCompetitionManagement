module com.example.sports_competition_management {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires tornadofx.controls;
    requires mysql.connector.j;


    opens com.example.sportsCompetitionManagement to javafx.fxml;
    exports com.example.sportsCompetitionManagement;
    exports com.example.sportsCompetitionManagement.windows;
    opens com.example.sportsCompetitionManagement.windows to javafx.fxml;
}