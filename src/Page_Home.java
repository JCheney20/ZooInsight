package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Page_Home extends BorderPane {

    private void getdata(TableView<obj_User> table) {
        ArrayList<obj_User> records = new ArrayList<obj_User>();
        String[] attributes = new String[10];
        Scanner in;
        try {
            // 1.1
            in = new Scanner(new File("src\\db_User.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_User(attributes));
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return;
        }
        for (obj_User user : records) {
            table.getItems().add(user);
        }
        in.close();
    }

    private TableColumn<obj_User, String> creatTableColumn(String ColumName, String propertyName) {
        TableColumn<obj_User, String> Column = new TableColumn<>(ColumName);
        Column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return Column;
    }

    // firstname, surname, email, usertype, gender, cellnumber, dob, username,
    // password, IDnumber
    private TableView<obj_User> createTable() {
        TableView<obj_User> table = new TableView<obj_User>();
        table.getColumns().add(creatTableColumn("Firstname", "firstname"));
        table.getColumns().add(creatTableColumn("Surname", "surname"));
        table.getColumns().add(creatTableColumn("Email Address", "email"));
        table.getColumns().add(creatTableColumn("Account Type", "usertype"));
        table.getColumns().add(creatTableColumn("Gender", "gender"));
        table.getColumns().add(creatTableColumn("Cell Number", "cellnumber"));
        table.getColumns().add(creatTableColumn("Date of Birth", "dob"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setMaxSize(800.0, 500.0);
        getdata(table);
        return table;
    }

    public Page_Home(Stage stage, String User, String Account) {
        utils_newLabel lbl = new utils_newLabel();
        Label lTitle = lbl.createNewLabel("Welcome, " + User + "!", 40.0);
        TableView<obj_User> table = createTable();

        this.setTop(lTitle);
        this.setCenter(table);
        Image img = new Image("resources\\loginPg.png");
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        this.setBackground(new Background(bImage));
    }

}
