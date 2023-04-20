module com.example.javafx_lib_connect {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafx_lib_connect to javafx.fxml;
    exports com.example.javafx_lib_connect;
}