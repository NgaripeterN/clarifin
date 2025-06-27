package org.example;

import javafx.application.Application;
import javafx.stage.Stage;
import org.example.utils.ViewNavigator;
import org.example.views.DashboardView;
import org.example.views.LoginView;
import org.example.views.SignUpView;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("ClariFin");
        stage.setWidth(950);  // Set custom width
        stage.setHeight(850);
        ViewNavigator.setMainStage(stage);
        new LoginView().show();
    }
}