package src;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class App extends Application { // ! Please ensure program is configured for access to javafx lib
    /**
     * TODO: Final GUI touch-ups
     * TODO: AboutUs Page
     * TODO: Record videos
     */
    public void start(Stage stage) {
        Page_Login login = new Page_Login(stage);
        Scene loginPage = new Scene(login, 800, 300);
        loginPage.getStylesheets().add(getClass().getResource("Stylesheets.css").toExternalForm());
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
