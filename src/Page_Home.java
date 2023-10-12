package src;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
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

public class Page_Home extends BorderPane {
    utils_newTabel newtable = new utils_newTabel();
    TableView<obj_User> table;
    TableView<obj_Animal> table2;

    public Page_Home(Stage stage, String User, String Account) {
        utils_newLabel lbl = new utils_newLabel();
        Label lTitle = lbl.createNewLabel("HomePage");
        Label lusername = lbl.createNewLabel("Welcome. " + User + "!");
        lTitle.setId("Title");
        lusername.setId("User");
        HBox welcom = new HBox(30.0, lusername);
        HBox pageTitle = new HBox(50.0, lTitle);
        VBox Header = new VBox(40.0, pageTitle, welcom);
        switch (Account) {
            case "Admin":
                table = newtable.createUserTable();
                this.setCenter(table);
                break;
            default:
                table2 = newtable.createAnimalTable();
                this.setCenter(table2);
                break;
        }

        this.setTop(Header);
        pageTitle.setAlignment(Pos.TOP_CENTER);
        welcom.setAlignment(Pos.TOP_CENTER);
        Image img = new Image("resources\\background.png");
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(bImage));
    }

}
