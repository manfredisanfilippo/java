package com.example.gokart.controller;

import com.example.gokart.bean.TournamentBean;
import com.example.gokart.controller_app.SubscriptionControllerApp;
import com.example.gokart.controller_app.TournamentControllerApp;
import com.example.gokart.service.FileGenerator;
import javafx.fxml.FXML;
import com.example.gokart.bean.LoginBean;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewTournamentController extends NavController implements Initializable {

    private LoginBean loginBean;

    @FXML
    private TextArea admin_name;

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

    private TableColumn<LoginBean, Void> btnColumn;


    public ViewTournamentController(LoginBean loginBean) {
        this.loginBean = loginBean;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        admin_name.setText(loginBean.getUsername());
        try {
            var list = TournamentControllerApp.GetAllMyTournament(loginBean.getId());
            for (TournamentBean tournamentBean : list) {
                TournamentId.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(tournamentBean.getId())));
                Name.setCellValueFactory(new PropertyValueFactory<>(tournamentBean.getName()));
                Where.setCellValueFactory(new PropertyValueFactory<>(tournamentBean.getWhere()));
                Date.setCellValueFactory(new PropertyValueFactory<>(String.valueOf(tournamentBean.getDate())));
                Callback<TableColumn<LoginBean, Void>, TableCell<LoginBean, Void>> cellFactory = new Callback<>() {
                    public TableCell<LoginBean, Void> call(final TableColumn<LoginBean, Void> param) {
                        final TableCell<LoginBean, Void> cell = new TableCell<>() {

                            private final Button btn = new Button("Details");

                            {
                                btn.setOnAction(event -> {
                                    var item = getTableView().getItems().get(getIndex());
                                    // Handle button action here
                                    goToDetails(tournamentBean);
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

    private void goToDetails(TournamentBean tournamentBean) {
        var driverList = SubscriptionControllerApp.GetTournamentSubscription(tournamentBean);
        FileGenerator.generateFile(tournamentBean.getName(), driverList.toString());
        System.out.println("File created successfully!");
    }

    public void backToHome() throws Exception {
        goToPageInit(ADMINPAGE, loginBean);
        new AdminPageController(loginBean);
    }
}
