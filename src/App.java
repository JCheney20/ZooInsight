package src;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application { // ! Please ensure program is configured for access to javafx lib

    public void start(Stage stage) {
        HomePage home = new HomePage(stage);
        Scene homePage = new Scene(home, 600, 600);
        LoginPage login = new LoginPage(stage, homePage);
        Scene loginPage = new Scene(login, 500, 300);
        stage.setScene(loginPage);
        stage.setTitle("ZooInsight - Login");
        stage.minWidthProperty().bind(loginPage.heightProperty().multiply(2));
        stage.minHeightProperty().bind(loginPage.widthProperty().divide(2));
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
