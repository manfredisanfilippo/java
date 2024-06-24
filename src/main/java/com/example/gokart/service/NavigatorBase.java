package com.example.gokart.service;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class NavigatorBase {
    private final Stage stg;

    private static class SingletonHelper {
        private static final NavigatorBase INSTANCE = new NavigatorBase();
    }

    public static NavigatorBase getInstance(Stage stg) {
        SingletonHelper.INSTANCE.stg.setScene(stg.getScene());
        return SingletonHelper.INSTANCE;
    }

    public static NavigatorBase getInstance() {
        return SingletonHelper.INSTANCE;
    }

    private NavigatorBase() {
        this.stg = new Stage();
    }

    public Stage getStg() {
        return stg;
    }

    public void goToPageInit(String page, Object controllerData) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(page));
        Parent root = loader.load();

        if (controllerData != null && loader.getController() instanceof InitializableController) {
            InitializableController controller = loader.getController();
            controller.initializeData(controllerData);
        }
        stg.getScene().setRoot(root);
    }
}