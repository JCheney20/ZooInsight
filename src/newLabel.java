package src;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class newLabel extends Label {

    public Label createNewLabel(String text, double FontSize) {
        Label label = new Label(text);
        label.setFont(new Font(FontSize));
        return label;
    }

    public Label createNewLabel(String text) {
        Label label = new Label(text);
        label.setFont(new Font(12.0));
        return label;
    }
}
