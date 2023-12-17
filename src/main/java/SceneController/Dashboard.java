package SceneController;

import Main.Main;
import Model.Users;
import Read.dlGamesCSV;
import Read.lGamesCSV;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.io.IOException;

import static Read.gamesCSV.gameList;
import static Read.gamesCSV.getGameList;
import static SceneController.SignIn.currUser;

public class Dashboard {

    public ObservableList<String> choices = FXCollections.observableArrayList("All", "Liked", "Disliked");
    public ChoiceBox gameChoice =new ChoiceBox(FXCollections.observableArrayList(choices));
    public TableView n64Table;
    public TableColumn title;
    public TableColumn developer;
    public TableColumn publisher;
    public TableColumn release;
    public Button exit;
    public Button save;


    public void initialize(){
        System.out.println("id is " + currUser.getID());
        lGamesCSV.setLGames(currUser.getID());
        dlGamesCSV.setDLGames(currUser.getID());
        gameChoice.setItems(choices);
        gameChoice.setValue("All");
        n64Table.setItems(getGameList());
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        developer.setCellValueFactory(new PropertyValueFactory<>("developer"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        release.setCellValueFactory(new PropertyValueFactory<>("release"));

    }


    public void changeChoice(ActionEvent actionEvent) {

       if(gameChoice.getValue().equals("Liked")){
           n64Table.setItems(lGamesCSV.lGames);

       }
       else if (gameChoice.getValue().equals("Disliked")){
           n64Table.setItems(dlGamesCSV.dlGames);
       }
       else if(gameChoice.getValue().equals("All")){
           n64Table.setItems(getGameList());
       }

    }

    public void onExit(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) exit.getScene().getWindow();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Save Before Exit");
        a.setContentText("Would you like to save changes before exiting?");
        ButtonType yes = new ButtonType("YES");
        ButtonType no = new ButtonType("NO");
        a.getButtonTypes().set(0,yes);
        a.getButtonTypes().set(1,no);
        a.showAndWait().ifPresent(response -> {
            if (response == yes) {
                //save and then quit
                try {
                    lGamesCSV.writeLGames(currUser);
                    dlGamesCSV.writeDLGames(currUser);
                }
                catch(IOException e){
                    e.printStackTrace();
                }
                stage.close();
            } else if (response == no) {
            stage.close();
            }
        });
    }

    public void onSave(ActionEvent actionEvent) throws IOException {
        System.out.println("saving");
        lGamesCSV.writeLGames(currUser);
        dlGamesCSV.writeDLGames(currUser);
    }

}