package sk.spse.uloha2.procedural;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Application extends javafx.application.Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Nastavenie GridPane (hlavný kontajner)
        GridPane grid = new GridPane();
        grid.setPrefSize(371, 286);
        grid.setPadding(new Insets(10));

        // Nastavenie stĺpcov (ColumnConstraints)
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(178);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(173);
        grid.getColumnConstraints().addAll(col1, col2);

        // 2. Vytvorenie grafických prvkov (UI Controls)
        Label userLabel = new Label("Užívateľské meno:");
        userLabel.setFont(new Font(18));
        userLabel.setAlignment(Pos.CENTER_RIGHT);
        userLabel.setPrefWidth(189);

        TextField userNameField = new TextField();
        userNameField.setPromptText("zadajte meno");
        userNameField.setFont(new Font(14));
        GridPane.setMargin(userNameField, new Insets(10));

        Label hesloLabel = new Label("Heslo:");
        hesloLabel.setFont(new Font(18));
        hesloLabel.setAlignment(Pos.CENTER_RIGHT);
        hesloLabel.setPrefWidth(189);

        PasswordField hesloField = new PasswordField();
        hesloField.setPromptText("zadajte heslo");
        hesloField.setFont(new Font(14));
        GridPane.setMargin(hesloField, new Insets(10));

        Label pohlavieLabel = new Label("Pohlavie:");
        pohlavieLabel.setFont(new Font(18));
        pohlavieLabel.setAlignment(Pos.CENTER_RIGHT);
        pohlavieLabel.setPrefWidth(189);

        // Radio buttony a ToggleGroup
        ToggleGroup pohlavieGroup = new ToggleGroup();
        RadioButton rbMuz = new RadioButton("Muž");
        rbMuz.setToggleGroup(pohlavieGroup);
        rbMuz.setSelected(true);
        rbMuz.setFont(new Font(14));

        RadioButton rbZena = new RadioButton("Žena");
        rbZena.setToggleGroup(pohlavieGroup);
        rbZena.setFont(new Font(14));

        HBox pohlavieBox = new HBox(10, rbMuz, rbZena);
        pohlavieBox.setAlignment(Pos.CENTER);

        // Čiara (Separator)
        Separator separator = new Separator();

        // Tlačidlá
        Button btnRegistruj = new Button("Registrovať");
        btnRegistruj.setFont(new Font(14));

        Button btnZatvor = new Button("Zavrieť");
        btnZatvor.setFont(new Font(14));

        HBox buttonBox = new HBox(10, btnRegistruj, btnZatvor);
        buttonBox.setAlignment(Pos.CENTER);

        // 3. Rozmiestnenie do mriežky (Grid)
        grid.add(userLabel, 0, 0);
        grid.add(userNameField, 1, 0);

        grid.add(hesloLabel, 0, 1);
        grid.add(hesloField, 1, 1);

        grid.add(pohlavieLabel, 0, 2);
        grid.add(pohlavieBox, 1, 2);

        grid.add(separator, 0, 5, 2, 1); // columnSpan = 2
        grid.add(buttonBox, 1, 6);

        // 4. Logika (Event Handlery z pôvodného Controllera)
        btnRegistruj.setOnAction(e -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Registrácia užívateľa");
            alert.setHeaderText("Registrácia prebehla úspešne");

            RadioButton selected = (RadioButton) pohlavieGroup.getSelectedToggle();
            String pohlavie = (selected != null) ? selected.getText() : "neznáme";

            String message = String.format("Užívateľ %s (%s) s heslom %s bol pridaný do systému",
                    userNameField.getText(), pohlavie, hesloField.getText());

            alert.setContentText(message);
            alert.showAndWait();
        });

        btnZatvor.setOnAction(e -> Platform.exit());

        // 5. Zobrazenie scény
        Scene scene = new Scene(grid);
        primaryStage.setTitle("Registračný formulár");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}