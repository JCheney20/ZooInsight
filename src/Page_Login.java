package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
import javafx.stage.Stage;

public class Page_Login extends BorderPane {
    utils_newLabel lbl = new utils_newLabel();
    private String currentUser, currentacctype;

    public String getCurrentUser() {
        return currentUser;
    }

    public String getCurrentacctype() {
        return currentacctype;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public void setCurrentacctype(String currentacctype) {
        this.currentacctype = currentacctype;
    }

    private boolean checkfile(String username, String password, String filename) {
        ArrayList<obj_User> records = new ArrayList<obj_User>();
        String[] attributes = new String[10];
        Scanner in;
        boolean found = false;
        int count = 0;
        try {
            in = new Scanner(new File("src\\db_" + filename + ".txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_User(attributes, 1));
                obj_User user = records.get(count);
                if (user.getUsername().equals(username)
                        && user.getPassword().equals(password)) {
                    found = true;
                    setCurrentUser(user.getFirstname());
                    setCurrentacctype(user.getUsertype());
                    break;
                }
                count++;
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return found;
        }
        in.close();
        return found;
    }

    private boolean login(String username, String password) {
        boolean checkAdmin = checkfile(username, password, "Admin");
        boolean checkOwner = checkfile(username, password, "Owner");
        boolean checkCaretaker = checkfile(username, password, "Caretaker");
        if (checkAdmin == true || checkOwner == true || checkCaretaker == true) {
            return true;
        } else {
            return false;
        }

    }

    public Page_Login(Stage stage) {
        Label lTitle = lbl.createNewLabel("Welcome\t to\tZooInsight");
        lTitle.setId("Title");
        HBox pageTitle = new HBox(10.0, lTitle);
        Label lUsername = lbl.createNewLabel("Username:");
        Label lPassword = lbl.createNewLabel("Password:");
        Label lsignUp = lbl.createNewLabel("Not Signed Up Yet? Click Here");
        TextField usernameTextField = new TextField("");
        TextField passwordextField = new TextField("");
        Button logInbtn = new Button("Login");
        Button signUpbtn = new Button("Sign Up");
        Button abtUsbtn = new Button("About Us");

        HBox usernameBox = new HBox(10.0, lUsername, usernameTextField);
        HBox passwordBox = new HBox(10.0, lPassword, passwordextField);
        HBox signupBox = new HBox(10.0, lsignUp, signUpbtn);
        VBox loginDetailsBox = new VBox(15.0, usernameBox, passwordBox, logInbtn, signupBox);
        HBox AboutUs = new HBox(abtUsbtn);
        signUpbtn.setOnAction((evt -> {
            new Page_Registration();
        }));

        logInbtn.setOnAction((evt -> {
            String username = usernameTextField.getText();
            String password = passwordextField.getText();
            if (login(username, password)) {
                Page_Home home = new Page_Home(stage, getCurrentUser(), getCurrentacctype());
                Scene homePage = new Scene(home, 600, 600);
                homePage.getStylesheets().add(getClass().getResource("Stylesheets.css").toExternalForm());
                stage.setScene(homePage);
                stage.setTitle("ZooInsight - HomePage");
                stage.minWidthProperty().bind(home.heightProperty().multiply(2));
                stage.minHeightProperty().bind(home.widthProperty().divide(2));
            } else {
                JOptionPane.showMessageDialog(null, "Sorry incorrect username or password");
                usernameTextField.clear();
                passwordextField.clear();
            }

        }));

        this.setTop(pageTitle);
        this.setCenter(loginDetailsBox);
        this.setBottom(AboutUs);
        signupBox.setSpacing(5);
        AboutUs.setAlignment(Pos.BASELINE_RIGHT);
        usernameBox.setAlignment(Pos.CENTER);
        passwordBox.setAlignment(Pos.CENTER);
        loginDetailsBox.setAlignment(Pos.CENTER);
        signupBox.setAlignment(Pos.CENTER);
        pageTitle.setAlignment(Pos.TOP_CENTER);
        Image img = new Image("resources\\loginPg.png");
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(bImage));
    }
}
