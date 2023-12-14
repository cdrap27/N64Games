package SceneController;

import Main.Main;
import Model.Users;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static Read.userCSV.userList;

public class SignIn {
    public Hyperlink hyperllink;

    public static Stage signInStage;
    public Button signIn;
    public TextField userField;
    public TextField passField;
    public Users currUser;



    public void onSignIn(ActionEvent actionEvent) throws IOException {
        if(userCheck() == true && passCheck() == true){
            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Dashboard.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 1099, 755);

            stage.setTitle("Dashboard");
            stage.setScene(scene);
            stage.show();

            Main.primaryStage.close();
        }

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

    public Boolean passCheck(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(passField.getText().length() < 1){
            a.setTitle("Password Error");
            a.setContentText("Password field is blank");
            a.show();
            return false;
        }
        else if (passField.getText().equals(currUser.getPassword())){
            return true;
        }
        else{
            a.setTitle("Password Error");
            a.setContentText("Incorrect Password");
            a.show();
            return false;
        }
    }
    public Boolean userCheck(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(userField.getText().length() < 1){
            a.setTitle("User Error");
            a.setContentText("User field is blank.");
            a.show();
            return false;
        }

        else if(userFound(userField.getText()) == true){
            return true;
        }
        return false;
    }

    public Boolean userFound(String user){
        for(int i = 0; i < userList.size(); i++){
            if(user.equals(userList.get(i).getuName())){
                currUser = userList.get(i);
                return true;
            }
        }
        Alert a = new Alert(Alert.AlertType.ERROR);
        a.setContentText("User not found");
        a.setTitle("User Error");
        a.show();
        return false;
    }
}
