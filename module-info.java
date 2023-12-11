module com.example.elms {
    requires javafx.controls;
    requires javafx.fxml;
    //requires javafx.sql;

    opens com.example.elms to javafx.fxml;
    exports com.example.elms;
}