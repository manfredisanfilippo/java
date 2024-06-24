package com.example.gokart.controller;

import com.example.gokart.service.NavigatorBase;
import javafx.scene.control.Alert;

import java.util.logging.Level;
import java.util.logging.Logger;

public class NavController {
    public static final String ADMINPAGE = "AdminPage.fxml";
    public static final String CREATETOURNAMENTPAGE = "CreateTournament.fxml";
    public static final String VIEWMYTOURNAMENTS = "ViewTournament.fxml";
    public static final String DRIVERPAGE = "DriverPage.fxml";
    public static final String VIEWALLTOURNAMENTS = "ViewAllTournament.fxml";
    public static final String PAYVIEW = "PayAndSubscribe.fxml";
    public static final String VIEWMYSUBSCRIPTION = "Subscriptions.fxml";
    public static final String VIEWlEADBOARD = "Leadboard.fxml";
    public static final String REFEREEPAGE = "RefereePage.fxml";
    public static final String MANAGEVOTE = "ManageVoteReferee.fxml";

    private static final Logger logger = Logger.getLogger(NavController.class.getName());

    protected void goToPageInit(String page, Object obj) throws Exception {
        try {
            NavigatorBase.getInstance().goToPageInit(page, obj);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage());
            throw new Exception();
        }
    }


}
