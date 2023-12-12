package SceneController;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SignIn {
    public Hyperlink hyperllink;



    public void onSignIn(ActionEvent actionEvent) {
    }

    public void onSignUp(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        System.out.print("hello, I'm working");
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign Up.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1099, 755);

        stage.setTitle("Nintendo 64 Recommendation System");
        stage.setScene(scene);
        stage.show();
            /*Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Sign Up.fxml")));
            Stage stage = (Stage)((Button)mouseEvent.getSource()).getScene().getWindow();
            Scene scene = new Scene(root, 528, 532);
            stage.setTitle("Add Customer");
            stage.setScene(scene);
            stage.getScene().getWindow().centerOnScreen();
            stage.show();

             */

    }
}
