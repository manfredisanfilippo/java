package com.example.gokart.controller;

import com.example.gokart.bean.LoginBean;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminPageController extends NavController implements Initializable {

    private LoginBean loginBean;

    @FXML
    private TextArea admin_name;

    public AdminPageController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @FXML
    public void createTournament() throws Exception {
        goToPageInit(CREATETOURNAMENTPAGE, loginBean);
        new CreateTournamentController(loginBean);
    }

    @FXML
    public void viewMyTournament() throws Exception {
        goToPageInit(VIEWMYTOURNAMENTS, loginBean);
        new ViewTournamentController(loginBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        admin_name.setText(loginBean.getUsername());
    }
}
