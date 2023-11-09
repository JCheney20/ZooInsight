package src;

import javax.swing.JOptionPane;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

    /*
     * private boolean checkfile(String username, String password, String filename)
     * {
     * ArrayList<obj_User> records = new ArrayList<obj_User>();
     * String[] attributes = new String[10];
     * Scanner in;
     * boolean found = false;
     * int count = 0;
     * try {
     * in = new Scanner(new File("src\\db_" + filename + ".txt"));
     * do {
     * attributes = in.nextLine().split(",");
     * records.add(new obj_User(attributes));
     * obj_User user = records.get(count);
     * if (user.getUsername().equals(username)
     * && user.getPassword().equals(password)) {
     * found = true;
     * setCurrentUser(user.getFirstname());
     * setCurrentacctype(user.getUsertype());
     * break;
     * }
     * count++;
     * } while (in.hasNextLine());
     * Arrays.fill(attributes, null);
     * } catch (IOException e) {
     * System.out.println("Error: " + String.valueOf(e));
     * System.out.println("Unable to update");
     * return found;
     * }
     * in.close();
     * return found;
     * }
     */

    private boolean login(String username, String password) {
        utils_DBManager DBMan = new utils_DBManager();
        boolean accexists = DBMan.Login(username, password);
        if (accexists) {
            setCurrentUser(DBMan.getFname());
            setCurrentacctype(DBMan.getusertype());
            return true;
        }
        return false;
    }

    public Page_Login(Stage stage) {
        this.setId("Page_Login");
        Label lUsername = lbl.createNewLabel("Username:");
        Label lPassword = lbl.createNewLabel("Password:");
        Label lsignUp = lbl.createNewLabel("Not Signed Up Yet? Click Here");
        TextField usernameTextField = new TextField("");
        TextField passwordextField = new TextField("");
        Button logInbtn = new Button("Login");
        Button signUpbtn = new Button("Sign Up");

        HBox usernameBox = new HBox(10.0, lUsername, usernameTextField);
        HBox passwordBox = new HBox(10.0, lPassword, passwordextField);
        HBox signupBox = new HBox(10.0, lsignUp, signUpbtn);
        VBox loginDetailsBox = new VBox(15.0, usernameBox, passwordBox, logInbtn, signupBox);
        signUpbtn.setOnAction((evt -> {
            new Page_Registration();
        }));

        logInbtn.setOnAction((evt -> {
            String username = usernameTextField.getText();
            String password = passwordextField.getText();
            if (login(username, password)) {
                switch (getCurrentacctype()) {
                    case "Admin":
                        Page_Home_Admin home_Admin = new Page_Home_Admin(stage, getCurrentUser(), this.getScene());
                        Scene homePage_Admin = new Scene(home_Admin, 600, 600);
                        homePage_Admin.getStylesheets().add(getClass().getResource("Stylesheets.css").toExternalForm());
                        stage.setScene(homePage_Admin);
                        stage.setTitle("ZooInsight - HomePage");
                        stage.minWidthProperty().bind(home_Admin.heightProperty().multiply(2));
                        stage.minHeightProperty().bind(home_Admin.widthProperty().divide(2));
                        break;
                    default:
                        Page_Home_Default home_Default = new Page_Home_Default(stage, getCurrentUser(),
                                this.getScene());
                        Scene homePage_Default = new Scene(home_Default, 600, 600);
                        homePage_Default.getStylesheets()
                                .add(getClass().getResource("Stylesheets.css").toExternalForm());

                        stage.setScene(homePage_Default);
                        stage.setTitle("ZooInsight - HomePage");
                        stage.minWidthProperty().bind(home_Default.heightProperty().multiply(2));
                        stage.minHeightProperty().bind(home_Default.widthProperty().divide(2));
                        break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Sorry incorrect username or password");
                usernameTextField.clear();
                passwordextField.clear();
            }
            usernameTextField.clear();
            passwordextField.clear();
        }));

        this.setTop(lbl.createNewTitle("Welcome\t to\tZooInsight"));
        this.setCenter(loginDetailsBox);
        signupBox.setSpacing(5);
        usernameBox.setAlignment(Pos.CENTER);
        passwordBox.setAlignment(Pos.CENTER);
        loginDetailsBox.setAlignment(Pos.TOP_CENTER);
        signupBox.setAlignment(Pos.CENTER);
        utils_background bckgrnd = new utils_background();
        bckgrnd.setBgrd("resources\\loginPg.png");
        this.setBackground(bckgrnd.getBgrd());
    }
}
