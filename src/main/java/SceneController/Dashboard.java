package SceneController;

import Main.Main;
import Model.Game;
import Model.Users;
import Read.dlGamesCSV;
import Read.gamesCSV;
import Read.lGamesCSV;
import Read.topSellingCSV;
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
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import static Read.gamesCSV.*;
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
    public Button like;
    public Button dislike;
    public Button rGames;
    public TextField search;
    public Button searchButton;
    public Button topSellers;


    public void initialize(){
        System.out.println("id is " + currUser.getID());
        lGamesCSV.setLGames(currUser.getID());
        dlGamesCSV.setDLGames(currUser.getID());

        gameChoice.setItems(choices);
        gameChoice.setValue("All");
        n64Table.setItems(getGameList());
        //n64Table.setItems(topSellingCSV.top40);
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

    public void onLike(ActionEvent actionEvent) {
        Game g = (Game) n64Table.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(g == null){
            System.out.println("null");
            a.setTitle("No selection");
            a.setContentText("No game is selected.");
            a.show();
        }
        else if(lGamesCSV.lGames.contains(g)){
            a.setTitle("Game already liked");
            a.setContentText("Game is already liked");
            a.show();
        }
        else if(dlGamesCSV.dlGames.contains(g)){
            dlGamesCSV.dlGames.remove(g);
            lGamesCSV.lGames.add(g);
        }
        else{
            lGamesCSV.lGames.add(g);
        }

        Comparator<Game> gameComparator = Comparator.comparing(Game::getID);
        Collections.sort(lGamesCSV.lGames, gameComparator);
    }

    public void onDislike(ActionEvent actionEvent) {
        Game g = (Game) n64Table.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.WARNING);
        if(g == null){
            System.out.println("null");
            a.setTitle("No selection");
            a.setContentText("No game is selected.");
            a.show();
        }
        else if(dlGamesCSV.dlGames.contains(g)){
            a.setTitle("Game already disliked");
            a.setContentText("Game is already disliked");
            a.show();
        }
        else if(lGamesCSV.lGames.contains(g)){
            lGamesCSV.lGames.remove(g);
            dlGamesCSV.dlGames.add(g);
        }
        else{
            dlGamesCSV.dlGames.add(g);
        }

        Comparator<Game> gameComparator = Comparator.comparing(Game::getID);
        Collections.sort(dlGamesCSV.dlGames, gameComparator);
    }

    public void onRGames(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Recommended Games.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1052, 420);
        stage.setTitle("Recommended Games");
        stage.setScene(scene);
        stage.show();

    }

    public void onSearch(ActionEvent actionEvent) {
        String title = search.getText();

        if(gameChoice.getValue().equals("Liked")){
            n64Table.setItems(lGamesCSV.searchGames(title));
        }
        else if (gameChoice.getValue().equals("Disliked")){
            n64Table.setItems(dlGamesCSV.searchGames(title));
        }
        else if(gameChoice.getValue().equals("All")){
            n64Table.setItems(gamesCSV.searchGames(title));
        }

    }

    public void onSearchButton(ActionEvent actionEvent) {
        String title = search.getText();

        if(gameChoice.getValue().equals("Liked")){
            n64Table.setItems(lGamesCSV.searchGames(title));
        }
        else if (gameChoice.getValue().equals("Disliked")){
            n64Table.setItems(dlGamesCSV.searchGames(title));
        }
        else if(gameChoice.getValue().equals("All")){
            n64Table.setItems(gamesCSV.searchGames(title));
        }
    }

    public void onTop(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("salesGraph.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1271, 878);
        stage.setTitle("Top Sellers");
        stage.setScene(scene);
        stage.show();

    }
}