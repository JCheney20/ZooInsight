package src;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPage extends BorderPane {
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

    public LoginPage(Stage stage, Scene home) {
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

        signUpbtn.setOnAction((evt -> {
            new RegistrationPage();
        }));

        logInbtn.setOnAction((evt -> {
            stage.setScene(home);
            stage.setTitle("ZooInsight - HomePage");
            stage.minWidthProperty().bind(home.heightProperty().multiply(2));
            stage.minHeightProperty().bind(home.widthProperty().divide(2));
        }));

        this.setTop(lTitle);
        this.setCenter(loginDetailsBox);
        this.setBottom(abtUsbtn);
        signupBox.setSpacing(5);
        abtUsbtn.setAlignment(Pos.BASELINE_RIGHT);
        loginDetailsBox.setAlignment(Pos.TOP_CENTER);
        lTitle.setAlignment(Pos.TOP_CENTER);
        Image img = new Image("resources\\loginPg.png");
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(bImage));
    }
}
