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

    public static Stage signInStage;



    public void onSignIn(ActionEvent actionEvent) {
    }

    public void onSignUp(MouseEvent mouseEvent) throws IOException {

        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign Up.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 439, 464);

        stage.setTitle("Sign Up");
        stage.setScene(scene);
        stage.show();

        Main.primaryStage.close();

        signInStage = stage;
        if (SignUp.signUpStage !=null)
        {
            SignUp.signUpStage.close();
        }

    }
}
