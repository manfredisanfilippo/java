package com.example.gokart.controller;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.SubscriptionControllerApp;
import com.example.gokart.controller_app.TournamentControllerApp;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;

public class PayPageController extends NavController implements Initializable {

    @FXML
    private TextArea driver_name;

    @FXML
    private TextField tournament_name;

    @FXML
    private TextField tournament_where;

    @FXML
    private DatePicker tournament_date;

    @FXML
    private Button btn_create;

    @FXML
    private Spinner<?> tournament_number;

    @FXML
    private Spinner<?> tournament_cost;

    private TournamentBean tournamentBean;

    private LoginBean loginBean;

    public PayPageController(LoginBean loginBean, TournamentBean tournamentBean) {
        this.loginBean = loginBean;
        this.tournamentBean = tournamentBean;
    }

    @FXML
    void backToHome() throws Exception {
        goToPageInit(DRIVERPAGE, loginBean);
        new DriverPageController(loginBean);
    }

    public void payAndSubscribe(ActionEvent event) throws Exception {
        try
        {
            SubscriptionControllerApp.subscription(loginBean, tournamentBean);
            goToPageInit(DRIVERPAGE, loginBean);
            new DriverPageController(loginBean);
        }
        catch(Exception e){
            throw e;
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        driver_name.setText(tournament_name.getText());
    }


}
