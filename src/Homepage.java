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

public class HomePage extends BorderPane {

    private void getdata(TableView<User> table) {
        ArrayList<User> records = new ArrayList<User>();
        String[] attributes = new String[10];
        Scanner in;
        try {
            // 1.1
            in = new Scanner(new File("src\\Userdb.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new User(attributes));
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return;
        }
        for (User user : records) {
            table.getItems().add(user);
        }
        in.close();
    }

    private TableColumn<User, String> creatTableColumn(String ColumName, String propertyName) {
        TableColumn<User, String> Column = new TableColumn<User, String>(ColumName);
        Column.setCellValueFactory(new PropertyValueFactory<User, String>(propertyName));
        return Column;
    }

    // firstname, surname, email, usertype, gender, cellnumber, dob, username,
    // password, IDnumber
    private TableView<User> createTable() {
        TableView<User> table = new TableView<User>();
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

    public HomePage(Stage stage, String User, String Account) {
        newLabel lbl = new newLabel();
        Label lTitle = lbl.createNewLabel("Welcome, " + User + "!", 40.0);
        TableView<User> table = createTable();

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
