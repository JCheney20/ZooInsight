package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.collections.ObservableList;
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
    private void getdata(TableView table) {
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

    public HomePage(Stage stage) {

        TableView<User> table = new TableView<User>();
        TableColumn fNamTableColumn = new TableColumn<User, String>("Firstname");
        fNamTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("firstname"));
        TableColumn surNamTableColumn = new TableColumn<User, String>("Surname");
        surNamTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("surname"));
        TableColumn accTypeTableColumn = new TableColumn<User, String>("Account Type");
        accTypeTableColumn.setCellValueFactory(new PropertyValueFactory<User, String>("usertype"));
        table.getColumns().add(fNamTableColumn);
        table.getColumns().add(surNamTableColumn);
        table.getColumns().add(accTypeTableColumn);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setMaxSize(400.0, 400.0);
        getdata(table);
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
