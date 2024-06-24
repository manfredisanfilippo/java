package com.example.gokart.controller;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.TournamentControllerApp;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateTournamentController extends NavController implements Initializable {

    @FXML
    private TextArea admin_name;

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

    private LoginBean loginBean;

    public CreateTournamentController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @FXML
    public void createTournament() throws Exception {
        TournamentBean tournamentBean = new TournamentBean();
        tournamentBean.setName(tournament_name.getText());
        tournamentBean.setWhere(tournament_where.getText());
        tournamentBean.setCost((Float) tournament_cost.getValue());
        tournamentBean.setNumber((Integer) tournament_number.getValue());
        tournamentBean.setDate(tournament_date.getValue());
        tournamentBean.checkField(tournamentBean.getName(), tournamentBean.getWhere(), tournamentBean.getDate(), tournamentBean.getCost(), tournamentBean.getNumber());

        TournamentControllerApp.createTournament(loginBean, tournamentBean);

        System.out.print("You have successfully created tournament " + tournament_name.getText());
    }


    @FXML
    public void backToHome() throws Exception {
        goToPageInit(ADMINPAGE, loginBean);
        new ViewTournamentController(loginBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        admin_name.setText(loginBean.getUsername());
    }
}
