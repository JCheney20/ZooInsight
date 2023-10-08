package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class App extends Application {
    Main fn = new Main();
    String name;

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
        RadioButton otherbtn = new RadioButton("Female");
        otherbtn.setToggleGroup(gendergrp);

        ToggleGroup accgrp = new ToggleGroup();
        RadioButton caretkrbtn = new RadioButton("Caretaker");
        caretkrbtn.setToggleGroup(accgrp);
        caretkrbtn.setSelected(true);
        RadioButton ownerbtn = new RadioButton("Owner");
        ownerbtn.setToggleGroup(accgrp);
        RadioButton adminbtn = new RadioButton("Admin");
        adminbtn.setToggleGroup(accgrp);
        RadioButton selecteRadioButton = (RadioButton) gendergrp.getSelectedToggle();
        RadioButton selecteRadioButton2 = (RadioButton) accgrp.getSelectedToggle();

        DatePicker dpick = new DatePicker(LocalDate.now());

        Button clearbtn = new Button("Clear");
        Button submitbtn = new Button("Submit");
        Button quitbtn = new Button("Exit");
        ButtonBar regBar = new ButtonBar();
        ButtonBar.setButtonData(clearbtn, ButtonData.CANCEL_CLOSE);
        ButtonBar.setButtonData(submitbtn, ButtonData.OK_DONE);
        ButtonBar.setButtonData(quitbtn, ButtonData.FINISH);
        regBar.getButtons().addAll(clearbtn, submitbtn, quitbtn);
        regBar.setButtonOrder("+CO+I");

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
            LocalDate dateoBirth = dpick.getValue();
            String date = dateoBirth.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
            String gendertoogleval = selecteRadioButton.getText();
            String acctoogleval = selecteRadioButton2.getText();
            String firname = tfieldFname.getText();
            String surname = tfieldSname.getText();
            String email = tfieldEmail.getText();
            String celnum = tfieldCelnum.getText();
            fn.registernewuser(firname, surname, email, acctoogleval, gendertoogleval, celnum, date);
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
