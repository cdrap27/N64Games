package SceneController;

import Model.Game;
import Read.dlGamesCSV;
import Read.lGamesCSV;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.util.Collections;
import java.util.Comparator;

import static Read.gamesCSV.getGameList;
import static SceneController.SignIn.currUser;

public class recommendedGames {
    public TableView n64Table;
    public TableColumn title;
    public TableColumn developer;
    public TableColumn publisher;
    public TableColumn release;
    public Button like;
    public Button dislike;
    public static Text titleR;
    public static Text titleN64;

    public void initialize(){
        mlAlgorithm.mlAlgorithm.setrGames(currUser);
        mlAlgorithm.mlAlgorithm.optimizeList();
        n64Table.setItems(mlAlgorithm.mlAlgorithm.getrGames());
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        developer.setCellValueFactory(new PropertyValueFactory<>("developer"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        release.setCellValueFactory(new PropertyValueFactory<>("release"));

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
}
