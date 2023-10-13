package src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class utils_newTabel {
    public void getAnimalData(TableView<obj_Animal> table) {
        ArrayList<obj_Animal> records = new ArrayList<obj_Animal>();
        String[] attributes = new String[10];
        Scanner in;
        try {
            // 1.1
            in = new Scanner(new File("src\\db_Animals.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_Animal(attributes));
            } while (in.hasNextLine());
            Arrays.fill(attributes, null);
        } catch (IOException e) {
            System.out.println("Error: " + String.valueOf(e));
            System.out.println("Unable to update");
            return;
        }
        for (obj_Animal user : records) {
            table.getItems().add(user);
        }
        in.close();
    }

    public void getUserData(TableView<obj_User> table) {
        ArrayList<obj_User> records = new ArrayList<obj_User>();
        String[] attributes = new String[10];
        Scanner in;
        try {
            // 1.1
            in = new Scanner(new File("src\\db_User.txt"));
            do {
                attributes = in.nextLine().split(",");
                records.add(new obj_User(attributes, 1));
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

    private <W, Q> TableColumn<W, Q> creatTableColumn(String ColumName, String propertyName) {
        TableColumn<W, Q> Column = new TableColumn<>(ColumName);
        Column.setCellValueFactory(new PropertyValueFactory<>(propertyName));
        return Column;
    }

    private TableColumn<obj_Animal, String> creatmoodColumn(String ColumName, String propertyName) {
        TableColumn<obj_Animal, String> Column = new TableColumn<>(ColumName);
        Column.setCellValueFactory(new PropertyValueFactory<obj_Animal, String>(propertyName));
        Column.setCellFactory(TextFieldTableCell.forTableColumn());
        Column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<obj_Animal, String>>() {
            @Override
            public void handle(CellEditEvent<obj_Animal, String> evt) {
                obj_Animal animal = evt.getRowValue();
                animal.setMood(evt.getNewValue());
            }
        });
        return Column;
    }

    public <T, Q> void deleteEntry(TableView<T> table) {
        T entity = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(entity);
    }

    public TableView<obj_User> createUserTable() {
        TableView<obj_User> table = new TableView<obj_User>();
        table.getColumns().add(creatTableColumn("Firstname", "firstname"));
        table.getColumns().add(creatTableColumn("Surname", "surname"));
        table.getColumns().add(creatTableColumn("Email Address", "email"));
        table.getColumns().add(creatTableColumn("Account Type", "usertype"));
        table.getColumns().add(creatTableColumn("Gender", "gender"));
        table.getColumns().add(creatTableColumn("Cell Number", "cellnumber"));
        table.getColumns().add(creatTableColumn("Date of Birth", "dob"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setMaxSize(800.0, 300.0);
        getUserData(table);
        return table;
    }

    public TableView<obj_Animal> createAnimalTable() {
        TableView<obj_Animal> table = new TableView<obj_Animal>();
        table.setEditable(true);
        table.getColumns().add(creatTableColumn("Name", "name"));
        table.getColumns().add(creatTableColumn("Age", "age"));
        table.getColumns().add(creatTableColumn("Gender", "gender"));
        table.getColumns().add(creatTableColumn("Class", "a_class"));
        table.getColumns().add(creatTableColumn("Family", "family"));
        table.getColumns().add(creatTableColumn("Species", "species"));
        table.getColumns().add(creatTableColumn("Favourite Food", "favFood"));
        table.getColumns().add(creatmoodColumn("Mood Today", "mood"));
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_LAST_COLUMN);
        table.setMaxSize(800.0, 300.0);
        getAnimalData(table);
        return table;
    }
}
