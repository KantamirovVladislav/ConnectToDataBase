module com.example.connecttodatabase {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.connecttodatabase to javafx.fxml;
    exports com.example.connecttodatabase;
}