package SceneController;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

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
    }

    public void onDislike(ActionEvent actionEvent) {
    }
}
