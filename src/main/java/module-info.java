module com.example.gokart {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.compiler;
    requires java.desktop;


    opens com.example.gokart to javafx.fxml;
    exports com.example.gokart;
    exports com.example.gokart.controller;
    opens com.example.gokart.controller to javafx.fxml;
}