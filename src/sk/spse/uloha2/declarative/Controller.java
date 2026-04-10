package sk.spse.uloha2.declarative;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.RadioButton;

/**
 * Controller pre FXML súbor – obsahuje logiku aplikácie
 */
public class Controller {

    @FXML
    private TextField menoField;

    @FXML
    private PasswordField hesloField;

    @FXML
    private ToggleGroup pohlavieGroup;

    @FXML
    private void onRegister() {
        String meno = menoField.getText();
        String heslo = hesloField.getText();
        String pohlavie = ((RadioButton) pohlavieGroup.getSelectedToggle()).getText();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Registrácia");
        alert.setHeaderText("Zadané údaje");
        alert.setContentText(
                "Meno: " + meno +
                        "\nHeslo: " + heslo +
                        "\nPohlavie: " + pohlavie
        );
        alert.showAndWait();
    }

    @FXML
    private void onClose() {
        Platform.exit();
    }
}