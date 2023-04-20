package com.example.javafx_lib_connect;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    public String text = new TextField().getText();
    @FXML
    protected void onButton1Click() {
        SQLConnection.getBookList(text);
    }
}