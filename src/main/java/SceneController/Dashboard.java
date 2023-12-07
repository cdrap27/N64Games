package SceneController;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Dashboard {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void buttonClick(ActionEvent actionEvent) throws IOException {
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1099, 755);
            stage.setTitle("Nintendo 64 Recommendation System");
            stage.setScene(scene);
            stage.show();

    }
}