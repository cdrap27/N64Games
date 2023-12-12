package SceneController;

import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class SignUp {
    public TextField userField;
    public TextField passField;
    public TextField rePassField;
    public TextField emailField;
    public TextField fNameField;
    public TextField lNameField;
    public Button create;
    public static Stage signUpStage;

    public void onCreate(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign In.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 423, 339);

        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
        SignIn.signInStage.close();
        signUpStage = stage;

    }
}
