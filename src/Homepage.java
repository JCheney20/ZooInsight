package src;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Homepage extends BorderPane {
    private Label newLabel(String text, double FontSize) {
        Label label = new Label(text);
        label.setFont(new Font(FontSize));
        return label;
    }

    private Label newLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font(12.0));
        return label;
    }

    public Homepage(Stage stage) {
        Label lTitle = newLabel("Welcome to ZooInsight", 40.0);
        Label lUsername = newLabel("Username:");
        Label lPassword = newLabel("Password:");
        Label lsignUp = newLabel("Not Signed Up Yet? Click Here");
        TextField usernameTextField = new TextField("");
        TextField passwordextField = new TextField("");
        Button logInbtn = new Button("Login");
        Button signUpbtn = new Button("Sign Up");
        Button abtUsbtn = new Button("About Us");

        HBox usernameBox = new HBox(10.0, lUsername, usernameTextField);
        HBox passwordBox = new HBox(10.0, lPassword, passwordextField);
        HBox signupBox = new HBox(10.0, lsignUp, signUpbtn);
        VBox loginDetailsBox = new VBox(15.0, usernameBox, passwordBox, logInbtn, signupBox);

        signupBox.setSpacing(5);
        abtUsbtn.setAlignment(Pos.BASELINE_RIGHT);
        lTitle.setAlignment(Pos.TOP_CENTER);

        this.setTop(lTitle);
        this.setCenter(loginDetailsBox);
        this.setBottom(abtUsbtn);
        this.setBackground(new Background(new BackgroundFill[] {
                new BackgroundFill(Color.rgb(115, 147, 179), CornerRadii.EMPTY, Insets.EMPTY) }));
    }
}
