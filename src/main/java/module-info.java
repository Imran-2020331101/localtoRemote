module com.example.gymworld {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.gymworld to javafx.fxml;
    exports com.example.gymworld;
}