package Main;
//test

import Read.dlGamesCSV;
import Read.gamesCSV;
import Read.lGamesCSV;
import Read.userCSV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        lGamesCSV.setLines();
        lGamesCSV.setLGames();
        dlGamesCSV.setLines();
        dlGamesCSV.setDLGames();

    }



    public static void main(String[] args) {
        launch();
    }
}