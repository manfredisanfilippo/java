package com.example.gokart.controller;

import com.example.gokart.bean.LoginBean;
import com.example.gokart.controller_app.UserControllerApp;
import com.example.gokart.data.ListData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;


public class LoginDocumentController extends NavController implements Initializable {
    @FXML
    private AnchorPane login_form;

    @FXML
    private TextField login_username;

    @FXML
    private PasswordField login_password;

    @FXML
    private Button login_btn;

    @FXML
    private ComboBox<String> login_role;

    @FXML
    private AnchorPane admin_form;

    @FXML
    private TextField admin_username;

    @FXML
    private PasswordField admin_password;

    @FXML
    private Button admin_signupBtn;

    @FXML
    private Hyperlink admin_signin;

    @FXML
    private PasswordField admin_confirm_password;

    @FXML
    private AnchorPane driver_form;

    @FXML
    private TextField driver_username;

    @FXML
    private PasswordField driver_password;

    @FXML
    private Button driver_signupBtn;

    @FXML
    private Hyperlink driver_signin;

    @FXML
    private PasswordField driver_confirm_password;

    @FXML
    private AnchorPane refree_form;

    @FXML
    private TextField refree_username;

    @FXML
    private PasswordField refree_password;

    @FXML
    private Button refree_signupBtn;

    @FXML
    private Hyperlink refree_signin;

    @FXML
    private PasswordField refree_confirm_password;

    public void roleList() {
        List<String> ListRole = new ArrayList<>(Arrays.asList(ListData.role));

        ObservableList<String> listData = FXCollections.observableArrayList(ListRole);
        login_role.setItems(listData);
    }

    @FXML
    public void login() {
        try {
            LoginBean loginBean = new LoginBean();
            loginBean.setUsername(login_username.getText());
            loginBean.setPassword(login_password.getText());
            loginBean.checkField(loginBean.getUsername(), loginBean.getPassword());
            UserControllerApp.login(loginBean);

            if(loginBean.getRole().equals("Admin")) {
                goToPageInit(ADMINPAGE, loginBean);
                new AdminPageController(loginBean);
            }

            if(loginBean.getRole().equals("Driver")) {
                goToPageInit(DRIVERPAGE, loginBean);
                new DriverPageController(loginBean);
            }

            if(loginBean.getRole().equals("Refree")) {
                goToPageInit(REFEREEPAGE, loginBean);
                new RefereeController(loginBean);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void signup() {
        try {
            LoginBean loginBean = new LoginBean();
            if (admin_form.isVisible()) {
                loginBean.setUsername(admin_username.getText());
                loginBean.setPassword(admin_password.getText());
                loginBean.SetCheckPassword(admin_confirm_password.getText());
                loginBean.setRole(login_role.getValue());
                loginBean.checkIfPassIsEqual(loginBean.getPassword(), loginBean.getCheckPassword());
                Boolean check = UserControllerApp.signin(loginBean);
                if(check) {
                    admin_form.setVisible(false);
                    login_form.setVisible(true);
                }
            }
            else if (refree_form.isVisible()) {
                loginBean.setUsername(refree_username.getText());
                loginBean.setPassword(refree_password.getText());
                loginBean.SetCheckPassword(refree_confirm_password.getText());
                loginBean.setRole(login_role.getValue());
                loginBean.checkIfPassIsEqual(loginBean.getPassword(), loginBean.getCheckPassword());
                Boolean check = UserControllerApp.signin(loginBean);
                if(check) {
                    admin_form.setVisible(false);
                    login_form.setVisible(true);
                }
            }
            else if (driver_form.isVisible()) {
                loginBean.setUsername(driver_username.getText());
                loginBean.setPassword(driver_password.getText());
                loginBean.SetCheckPassword(driver_confirm_password.getText());
                loginBean.setRole(login_role.getValue());
                loginBean.checkIfPassIsEqual(loginBean.getPassword(), loginBean.getCheckPassword());
                Boolean check = UserControllerApp.signin(loginBean);
                if(check) {
                    admin_form.setVisible(false);
                    login_form.setVisible(true);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void signinForm() {
        login_form.setVisible(true);
        admin_form.setVisible(false);
        refree_form.setVisible(false);
        driver_form.setVisible(false);
    }

    public void switchForm(){
        switch (login_role.getSelectionModel().getSelectedItem()) {
            case "Admin" -> {
                admin_form.setVisible(true);
                refree_form.setVisible(false);
                driver_form.setVisible(false);
            }
            case "Driver" -> {
                admin_form.setVisible(false);
                refree_form.setVisible(false);
                driver_form.setVisible(true);
            }
            case "Referee" -> {
                refree_form.setVisible(true);
                driver_form.setVisible(false);
                refree_form.setVisible(true);
            }
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roleList();
    }
}