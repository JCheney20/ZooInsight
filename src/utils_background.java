package src;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class utils_background {
    private Background bgrd;

    public utils_background() {
    }

    public void setBgrd(String imgLocation) {
        Image img = new Image(imgLocation);
        BackgroundImage bImage = new BackgroundImage(img,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1.0, 1.0, true, true, false, true));
        this.bgrd = new Background(bImage);
    }

    public Background getBgrd() {
        return bgrd;
    }
}