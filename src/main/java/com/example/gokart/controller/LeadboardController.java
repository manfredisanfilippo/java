package com.example.gokart.controller;

import com.example.gokart.bean.LeadboardBean;
import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.SubscriptionControllerApp;
import com.example.gokart.controller_app.TournamentControllerApp;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class LeadboardController extends NavController implements Initializable {

    private LoginBean loginBean;

    public LeadboardController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }
    @FXML
    private TextArea driver_name;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> Driver;

    @FXML
    private TableColumn<?, ?> NumberRace;

    @FXML
    private TableColumn<?, ?> TotalPoint;

    @FXML
    void backToHome() throws Exception {
        goToPageInit(DRIVERPAGE, loginBean);
        new DriverPageController(loginBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        driver_name.setText(loginBean.getUsername());
        try {
            var list = SubscriptionControllerApp.GetLeadboard();
            for (LeadboardBean leadboardBean : list) {
                Driver.setCellValueFactory(new PropertyValueFactory<>(leadboardBean.getDriver()));
                NumberRace.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(leadboardBean.getNumberRace())));
                TotalPoint.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(leadboardBean.getTotalPoint())));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
