package sk.spse.uloha4.declarative;

import javafx.animation.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.util.Random;

public class Controller {
    @FXML private VBox vbox1;
    @FXML private VBox vbox2;
    @FXML private VBox vbox3;
    @FXML private VBox vbox4;

    @FXML private ImageView img1;
    @FXML private ImageView img2;
    @FXML private ImageView img3;
    @FXML private ImageView img4;

    private final Random random = new Random();






    @FXML
    private void randomize() {
        // Zmena farby, velkosti a opacity pre vsetky
        randomizeVBox(vbox1, img1);
        randomizeVBox(vbox2, img2);
        randomizeVBox(vbox3, img3);
        randomizeVBox(vbox4, img4);

        // img1 - otoci sa o nahodny uhol
        RotateTransition rot1 = new RotateTransition(Duration.seconds(0.001), img1);
        rot1.setToAngle(random.nextInt(360));
        rot1.play();

        // img2 - natahne alebo splasne na X osi
        ScaleTransition scale2 = new ScaleTransition(Duration.seconds(0.001), img2);
        scale2.setToX(0.5 + random.nextDouble() * 2.0);
        scale2.play();

        // img3 - roztiahne alebo stiahne na Y osi
        ScaleTransition scale3 = new ScaleTransition(Duration.seconds(0.001), img3);
        scale3.setToY(0.5 + random.nextDouble() * 2.0);
        scale3.play();

        // img4 - otoci sa o nahodny uhol
        RotateTransition rot4 = new RotateTransition(Duration.seconds(0.001), img4);
        rot4.setToAngle(random.nextInt(360));
        rot4.play();
    }

    private void randomizeVBox(VBox vbox, ImageView img) {
        vbox.setStyle("-fx-background-color: " + getRandomColor());

        double size = 100 + random.nextInt(150); // 100 - 250
        img.setFitWidth(size);
        img.setFitHeight(size);

        img.setOpacity(0.3 + random.nextDouble() * 0.7); // 0.3 - 1.0
    }

    private String getRandomColor() {
        return String.format("#%02X%02X%02X",
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }

    @FXML
    private void close() {
        Platform.exit();
    }
}