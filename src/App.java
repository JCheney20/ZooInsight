package src;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class App extends Application {
    Main fn = new Main();
    String name;

    public void start(Stage stage) {

        TextField tfieldFname = new TextField("");
        TextField tfieldSname = new TextField("");
        TextField tfieldEmail = new TextField("");
        TextField tfieldCelnum = new TextField("");

        // TODO: Add radio group for gender and acctype and date/time picker for dob

        BorderPane root = new BorderPane();
        root.setBackground(new Background(new BackgroundFill[] {
                new BackgroundFill(Color.rgb(115, 147, 179), CornerRadii.EMPTY, Insets.EMPTY) }));
        Scene scene = new Scene(root, 500.0, 300.0);
        stage.setScene(scene);
        stage.setTitle("COS101 Question 3");
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
