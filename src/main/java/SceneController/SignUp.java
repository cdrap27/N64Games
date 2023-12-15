package SceneController;

import Main.Main;
import Model.Game;
import Model.Users;
import Read.dlGamesCSV;
import Read.lGamesCSV;
import Read.userCSV;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static Read.userCSV.userList;

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
        if(createUserCheck() == true) {
            List<Game> g = new ArrayList<Game>();
            Users u = new Users(userList.size(), userField.getText(), passField.getText(),emailField.getText(), fNameField.getText(),
                    lNameField.getText(), g, g);

            userList.add(u);
            userCSV.addUser(u);
            lGamesCSV.writeLGames(u);
            dlGamesCSV.writeDLGames(u);
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
    public Boolean createUserCheck(){
        Alert a = new Alert(Alert.AlertType.ERROR);
        if(userField.getText().length() < 1 || passField.getText().length() < 1 || rePassField.getText().length() < 1 ||
                emailField.getText().length() < 1 || fNameField.getText().length() < 1 ||
                lNameField.getText().length() < 1){
            a.setTitle("Error");
            a.setContentText("One or more necessary fields are empty");
            a.show();
            return false;
        }
        else if (!passField.getText().equals(rePassField.getText())){
            a.setTitle("Password Mismatch");
            a.setContentText("Passwords do not match");
            a.show();
            return false;
        }
        else{
            for(int i =0; i < userList.size(); i++){
                System.out.println(userList.get(i).getlGames().toString());
                if(userField.getText().equals(userList.get(i).getuName())){
                    a.setTitle("User Found");
                    a.setContentText("Username already taken");
                    a.show();
                    return false;
                }
                else if(emailField.getText().equals(userList.get(i).getEmail())){
                    a.setTitle("Email Found");
                    a.setContentText("Email is already in use");
                    a.show();
                    return false;
                }
            }
        }
        return true;
    }

}
