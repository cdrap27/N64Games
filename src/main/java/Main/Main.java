package Main;
//test

import Read.gamesCSV;
import Read.userCSV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;



public class Main extends Application {
    public static Stage primaryStage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Sign In.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 423, 339);
        stage.setTitle("Sign In");
        stage.setScene(scene);
        stage.show();
        primaryStage = stage;
        gamesCSV.setLines();
        gamesCSV.setGames();
        userCSV.setLines();
        userCSV.setUsers();
    }



    public static void main(String[] args) {
        launch();
    }
}