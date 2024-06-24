package com.example.gokart.controller;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.TournamentControllerApp;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewAllTournamentsController extends NavController implements Initializable {

    private LoginBean loginBean;

    @FXML
    private TextArea driver_name;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> TournamentId;

    @FXML
    private TableColumn<?, ?> Name;

    @FXML
    private TableColumn<?, ?> Where;

    @FXML
    private TableColumn<?, ?> Date;

    @FXML
    private TableColumn<?, ?> cost;

    private TableColumn<LoginBean, Void> btnColumn;

    public ViewAllTournamentsController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @FXML
    void backToHome() throws Exception {
        goToPageInit(DRIVERPAGE, loginBean);
        new DriverPageController(loginBean);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        driver_name.setText(loginBean.getUsername());
        try {
            var list = TournamentControllerApp.GetAllTournament();
            for (TournamentBean tournamentBean : list) {
                TournamentId.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(tournamentBean.getId())));
                Name.setCellValueFactory(new PropertyValueFactory<>(tournamentBean.getName()));
                Where.setCellValueFactory(new PropertyValueFactory<>(tournamentBean.getWhere()));
                Date.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(tournamentBean.getDate())));
                cost.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(tournamentBean.getCost())));
                Callback<TableColumn<LoginBean, Void>, TableCell<LoginBean, Void>> cellFactory = new Callback<>() {
                    public TableCell<LoginBean, Void> call(final TableColumn<LoginBean, Void> param) {
                        final TableCell<LoginBean, Void> cell = new TableCell<>() {

                            private final Button btn = new Button("Pay");

                            {
                                btn.setOnAction(event -> {
                                    var item = getTableView().getItems().get(getIndex());
                                    // Handle button action here
                                    try {
                                        payAndSubScribe(item, tournamentBean);
                                    } catch (Exception e) {
                                        throw new RuntimeException(e);
                                    }
                                });
                            }

                            @Override
                            public void updateItem(Void item, boolean empty) {
                                super.updateItem(item, empty);
                                if (empty) {
                                    setGraphic(null);
                                } else {
                                    setGraphic(btn);
                                }
                            }
                        };
                        return cell;
                    }
                };
                btnColumn.setCellFactory(cellFactory);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void payAndSubScribe(LoginBean loginBeans, TournamentBean tournamentBean) throws Exception {
        goToPageInit(PAYVIEW, loginBean);
        new PayPageController(loginBeans, tournamentBean);
    }
}
