package src;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Page_Home_Default extends BorderPane {
    utils_newTabel newtable = new utils_newTabel();
    utils_FileManager fm = new utils_FileManager();
    TableView<obj_Animal> table2;

    public Page_Home_Default(Stage stage, String User, Scene prescene) {
        utils_newLabel lbl = new utils_newLabel();
        Label lusername = lbl.createNewLabel("Welcome. " + User + "!");
        lusername.setId("User");
        HBox welcom = new HBox(30.0, lusername);
        VBox Header = new VBox(40.0, lbl.createNewTitle("HomePage"), welcom);
        table2 = newtable.createAnimalTable();
        Button createBtn = new Button("Create");
        Button deleteBtn = new Button("Delete");
        Button saveBtn = new Button("Save to File");
        Button logoutBtn = new Button("Logout");
        VBox buttonBar = new VBox(10.0, createBtn, deleteBtn, saveBtn, logoutBtn);
        createBtn.setOnAction((evt -> {
            fm.registerNewAnimal();
            table2.getItems().clear();
            newtable.getAnimalData(table2);
        }));
        saveBtn.setOnAction((evt -> {
            fm.updateFile(table2.getItems(), "Animals");
        }));
        logoutBtn.setOnAction((evt -> {
            stage.setScene(prescene);
            stage.setTitle("ZooInsight - Login");
        }));
        deleteBtn.setOnAction((evt -> {
            newtable.deleteEntry(table2);
            fm.updateFile(table2.getItems(), "Animals");
        }));
        this.setCenter(table2);
        this.setTop(Header);
        this.setRight(buttonBar);
        welcom.setAlignment(Pos.TOP_CENTER);
        utils_background bckgrnd = new utils_background();
        bckgrnd.setBgrd("resources\\background.png");
        this.setBackground(bckgrnd.getBgrd());
    }

}
