package src;

import javax.swing.JOptionPane;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Page_Home_Admin extends BorderPane {
    utils_newTabel newtable = new utils_newTabel();
    utils_FileManager fm = new utils_FileManager();
    TableView<obj_User> table;

    public Page_Home_Admin(Stage stage, String User, Scene scene) {
        this.setId("HomePage");
        utils_newLabel lbl = new utils_newLabel();
        Label lusername = lbl.createNewLabel("Welcome. " + User + "!");
        lusername.setId("User");
        HBox welcom = new HBox(10.0, lusername);
        VBox Header = new VBox(10.0, lbl.createNewTitle("HomePage"), welcom);
        table = newtable.createUserTable();
        this.setCenter(table);

        Button createBtn = new Button("Create");
        Button deleteBtn = new Button("Delete");
        Button saveBtn = new Button("Save to File");
        Button logoutBtn = new Button("Logout");
        HBox buttonBar = new HBox(10.0, createBtn, deleteBtn, saveBtn, logoutBtn);
        createBtn.setOnAction((evt -> {
            fm.registerNewUser();
            table.getItems().clear();
            newtable.getUserData(table);
        }));
        saveBtn.setOnAction((evt -> {
            fm.updateFile(table.getItems(), "User");
        }));
        logoutBtn.setOnAction((evt -> {
            int logout = JOptionPane.showConfirmDialog(null, "Do you want to log out?", "Loging Out",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null);
            if (logout == 0) {
                stage.setScene(scene);
                stage.setTitle("ZooInsight - Login");
            }
        }));
        deleteBtn.setOnAction((evt -> {
            int check = JOptionPane.showConfirmDialog(null, "Do you want to delete selected row?", "Delete",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null);
            if (check == 0) {
                newtable.deleteEntry(table);
                fm.updateFile(table.getItems(), "User");
                JOptionPane.showMessageDialog(null, "User account deleted.", "Saved", JOptionPane.INFORMATION_MESSAGE,
                        null);
            }
        }));

        this.setBottom(buttonBar);
        this.setTop(Header);
        buttonBar.setId("Btnbar");
        buttonBar.setAlignment(Pos.TOP_CENTER);
        welcom.setAlignment(Pos.TOP_CENTER);
        utils_background bckgrnd = new utils_background();
        bckgrnd.setBgrd("resources\\background.png");
        this.setBackground(bckgrnd.getBgrd());
    }

}
