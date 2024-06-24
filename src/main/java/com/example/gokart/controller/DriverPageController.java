package com.example.gokart.controller;

import javafx.fxml.FXML;
import com.example.gokart.bean.LoginBean;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class DriverPageController extends NavController implements Initializable {

    @FXML
    private TextArea driver_name;

    private LoginBean loginBean;

    public DriverPageController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    public void joinTournament(ActionEvent event) throws Exception {
        goToPageInit(VIEWALLTOURNAMENTS, loginBean);
        new ViewAllTournamentsController(loginBean);
    }

    public void viewLeadBoard() throws Exception {
        goToPageInit(VIEWlEADBOARD, loginBean);
        new LeadboardController(loginBean);
        
    }

    public void viewMyTournament() throws Exception {
        goToPageInit(VIEWMYSUBSCRIPTION, loginBean);
        new SubscriptionsController(loginBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        driver_name.setText(loginBean.getUsername());
    }
}
