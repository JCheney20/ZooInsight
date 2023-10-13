package src;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class utils_newLabel extends Label {

    public Label createNewLabel(String text, double FontSize) {
        Label label = new Label(text);
        label.setFont(new Font(FontSize));
        label.setId("lbl");
        return label;
    }

    public Label createNewLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font(12.0));
        label.setId("lbl");
        return label;
    }

    public HBox createNewTitle(String Title) {
        Label lTitle = createNewLabel(Title);
        lTitle.setId("Title");
        HBox pageTitle = new HBox(30.0, lTitle);
        pageTitle.setAlignment(Pos.TOP_CENTER);
        return pageTitle;
    }
}
