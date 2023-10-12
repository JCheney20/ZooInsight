package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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

public class Page_Registration extends Stage {
    utils_newLabel lbl = new utils_newLabel();
    LocalDate dateoBirth;
    String firname, surname, email, celnum, date;
    String[] userdetails = new String[7];
    utils_FileManager fn = new utils_FileManager();

    public Page_Registration() {
        Label lTitle = lbl.createNewLabel("Registration", 40.0);
        Label lfname = lbl.createNewLabel("Firstname:");
        Label lsname = lbl.createNewLabel("Surname:");
        Label lemail = lbl.createNewLabel("Email Address:");
        Label lcelnum = lbl.createNewLabel("Cell Number:");
        Label lgender = lbl.createNewLabel("Gender:");
        Label lacctype = lbl.createNewLabel("Account Type:");
        Label ldob = lbl.createNewLabel("Date of Birth:");
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
        Button backbtn = new Button("Back");
        HBox regBar = new HBox(10.0, clearbtn, submitbtn, backbtn);

        clearbtn.setOnAction((evt) -> {
            tfieldFname.clear();
            tfieldSname.clear();
            tfieldEmail.clear();
            tfieldCelnum.clear();
            malebtn.setSelected(true);
            caretkrbtn.setSelected(true);
            dpick.setValue(LocalDate.now());
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

            fn.registerNewUser(userdetails);
        });

        backbtn.setOnAction((evt) -> {
            this.hide();
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

        BorderPane screen = new BorderPane();
        screen.setTop(lTitle);
        screen.setCenter(infoBox);
        screen.setBottom(regBar);
        Image img = new Image("resources\\background.png");
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, false));
        screen.setBackground(new Background(bImage));
        this.setScene(new Scene(screen));
        this.minWidthProperty().bind(screen.heightProperty().multiply(2));
        this.minHeightProperty().bind(screen.widthProperty().divide(2));
        this.show();
    }
}
