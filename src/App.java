package src;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application { // ! Please ensure program is configured for access to javafx lib

    public void start(Stage stage) {
        Homepage home = new Homepage(stage);
        Scene homePage = new Scene(home, 500, 500);
        Registration registrationPg = new Registration(stage, homePage);
        Scene registrationPage = new Scene(registrationPg, 500.0, 400.0);
        stage.setScene(registrationPage);
        stage.setTitle("ZooInsight - Registration");
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
