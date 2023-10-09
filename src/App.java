package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class App extends Application { // ! Please ensure program is configured for access to javafx lib
    LocalDate dateoBirth;
    String firname, surname, email, celnum, date;
    String[] userdetails = new String[7];
    Main fn = new Main();

    public void start(Stage stage) {
        Label lTitle = new Label("Registration");
        Label lfname = new Label("Firstname:");
        Label lsname = new Label("Surname:");
        Label lemail = new Label("Email Address:");
        Label lcelnum = new Label("Cell Number:");
        Label lgender = new Label("Gender:");
        Label lacctype = new Label("Account Type:");
        Label ldob = new Label("Date of Birth:");
        lTitle.setFont(new Font(40.0));
        lfname.setFont(new Font(12.0));
        lsname.setFont(new Font(12.0));
        lemail.setFont(new Font(12.0));
        lcelnum.setFont(new Font(12.0));
        lgender.setFont(new Font(12.0));
        lacctype.setFont(new Font(12.0));
        ldob.setFont(new Font(12.0));
        TextField tfieldFname = new TextField("");
        TextField tfieldSname = new TextField("");
        TextField tfieldEmail = new TextField("");
        TextField tfieldCelnum = new TextField("");

        ToggleGroup gendergrp = new ToggleGroup();
        RadioButton malebtn = new RadioButton("Male");
        malebtn.setToggleGroup(gendergrp);
        malebtn.setSelected(true);
        RadioButton femalebtn = new RadioButton("Female");
        femalebtn.setToggleGroup(gendergrp);
        RadioButton otherbtn = new RadioButton("Other");
        otherbtn.setToggleGroup(gendergrp);

        ToggleGroup accgrp = new ToggleGroup();
        RadioButton caretkrbtn = new RadioButton("Caretaker");
        caretkrbtn.setToggleGroup(accgrp);
        caretkrbtn.setSelected(true);
        RadioButton ownerbtn = new RadioButton("Owner");
        ownerbtn.setToggleGroup(accgrp);
        RadioButton adminbtn = new RadioButton("Admin");
        adminbtn.setToggleGroup(accgrp);

        DatePicker dpick = new DatePicker(LocalDate.now());

        Button clearbtn = new Button("Clear");
        Button submitbtn = new Button("Submit");
        Button quitbtn = new Button("Exit");
        HBox regBar = new HBox(10.0, clearbtn, submitbtn, quitbtn);

        clearbtn.setOnAction((evt) -> {
            tfieldFname.clear();
            tfieldSname.clear();
            tfieldEmail.clear();
            tfieldCelnum.clear();
            malebtn.setSelected(true);
            caretkrbtn.setSelected(true);
            dpick.setValue(LocalDate.now());
        });

        quitbtn.setOnAction((evt) -> {
            Platform.exit();
        });

        submitbtn.setOnAction((evt) -> {
            dateoBirth = dpick.getValue();
            date = dateoBirth.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
            RadioButton selecteRadioButton = (RadioButton) gendergrp.getSelectedToggle();
            RadioButton selecteRadioButton2 = (RadioButton) accgrp.getSelectedToggle();
            String gendertoogleval = selecteRadioButton.getText();
            String acctoogleval = selecteRadioButton2.getText();
            firname = tfieldFname.getText();
            surname = tfieldSname.getText();
            email = tfieldEmail.getText();
            celnum = tfieldCelnum.getText();
            Arrays.fill(userdetails, null);

            userdetails = new String[] { firname, surname, email, acctoogleval, gendertoogleval, celnum, date };

            fn.registernewuser(userdetails);

        });

        VBox gendergrpBox = new VBox(10.0, malebtn, femalebtn, otherbtn);
        VBox genderBox = new VBox(15.0, lgender, gendergrpBox);
        VBox labelBox = new VBox(25.0, lfname, lsname, lemail, lcelnum);
        VBox txtfieldBox = new VBox(15.0, tfieldFname, tfieldSname, tfieldEmail, tfieldCelnum);
        HBox textinputBox = new HBox(10.0, labelBox, txtfieldBox);
        VBox leftBox = new VBox(15.0, textinputBox, genderBox);
        VBox dateBox = new VBox(10.0, ldob, dpick);
        VBox acctypegrpBox = new VBox(10.0, caretkrbtn, ownerbtn, adminbtn);
        VBox acctypeBox = new VBox(15.0, lacctype, acctypegrpBox);
        VBox rightBox = new VBox(15.0, dateBox, acctypeBox);
        HBox infoBox = new HBox(20.0, leftBox, rightBox);
        BorderPane root = new BorderPane();
        root.setTop(lTitle);
        root.setCenter(infoBox);
        root.setBottom(regBar);
        root.setBackground(new Background(new BackgroundFill[] {
                new BackgroundFill(Color.rgb(115, 147, 179), CornerRadii.EMPTY, Insets.EMPTY) }));
        Scene scene = new Scene(root, 500.0, 400.0);
        stage.setScene(scene);
        stage.setTitle("ZooInsight - Registration");
        stage.show();
    }

    public static void main(String[] args) {
        launch(new String[0]);
    }
}
