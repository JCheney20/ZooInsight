package src;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.BorderPane;

public class App extends Application { // ! Please ensure program is configured for access to javafx lib

    public void start(Stage stage) {
        BorderPane page2 = new BorderPane();
        Scene homepage = new Scene(page2, 500, 500);
        Registration registrationPg = new Registration(stage, homepage);
        Scene scene = new Scene(registrationPg, 500.0, 400.0);
        stage.setScene(scene);
        stage.setTitle("ZooInsight - Registration");
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
