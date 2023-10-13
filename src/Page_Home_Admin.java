package src;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Page_Home_Admin extends BorderPane {
    utils_newTabel newtable = new utils_newTabel();
    TableView<obj_User> table;
    TableView<obj_Animal> table2;

    public Page_Home_Admin(Stage stage, String User, Scene scene) {
        utils_newLabel lbl = new utils_newLabel();
        Label lusername = lbl.createNewLabel("Welcome. " + User + "!");
        lusername.setId("User");
        HBox welcom = new HBox(30.0, lusername);
        VBox Header = new VBox(40.0, lbl.createNewTitle("HomePage"), welcom);
        table = newtable.createUserTable();
        this.setCenter(table);

        this.setTop(Header);
        welcom.setAlignment(Pos.TOP_CENTER);
        utils_background bckgrnd = new utils_background();
        bckgrnd.setBgrd("resources\\background.png");
        this.setBackground(bckgrnd.getBgrd());
    }

}
