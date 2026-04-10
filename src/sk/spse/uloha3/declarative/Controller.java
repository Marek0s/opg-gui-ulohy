package sk.spse.uloha3.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.Desktop;
import java.net.URI;

public class Controller {

    @FXML
    private ImageView obrazok;

    @FXML
    private Slider slider;

    @FXML
    private void Vypni() {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    private void pohyb(MouseEvent event) {
        obrazok.setRotate(slider.getValue());
    }

    @FXML
    private void link() {
        String url = "https://spse-po.sk/";
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}