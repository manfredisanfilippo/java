package com.example.gokart.controller;

import com.example.gokart.bean.SubscriptionBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.SubscriptionControllerApp;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.gokart.bean.LoginBean;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ManageVoteReferee extends NavController implements Initializable {



    @FXML
    private TextArea referee_name;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> Driver;

    @FXML
    private TableColumn<?, ?> Tournament;

    private Spinner spinner;

    private LoginBean loginBean;

    private TournamentBean tournamentBean;

    private TableColumn<LoginBean, Void> spinnerColumn;

    public ManageVoteReferee(LoginBean loginBean, TournamentBean tournamentBean) {
        this.loginBean = loginBean;
        this.tournamentBean = tournamentBean;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        referee_name.setText(loginBean.getUsername());
        try {
            var list = SubscriptionControllerApp.GetTournamentSubscription(tournamentBean);
            for (SubscriptionBean subscriptionBean : list) {
                Driver.setCellValueFactory(new PropertyValueFactory<>(subscriptionBean.getDriver()));
                Tournament.setCellValueFactory(new PropertyValueFactory<>(subscriptionBean.getTournament()));
                Callback<TableColumn<LoginBean, Void>, TableCell<LoginBean, Void>> cellFactory = new Callback<>() {
                    public TableCell<LoginBean, Void> call(final TableColumn<LoginBean, Void> param) {
                        final TableCell<LoginBean, Void> cell = new TableCell<>() {

                            private final Spinner spinner = new Spinner();

                            @Override
                            public void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    spinner.setEditable(true);
                                    setGraphic(spinner);
                                }
                            }
                        };
                        return cell;
                    }
                };
                spinnerColumn.setCellFactory(cellFactory);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void vote() {
        System.out.println("we work to implement the function to vote for the referee");

    }

    public void backToHome() throws Exception {
        goToPageInit(REFEREEPAGE, loginBean);
        new RefereeController(loginBean);
    }
}
