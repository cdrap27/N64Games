package SceneController;

import Main.Main;
import Model.Users;
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

public class Dashboard {

    public ObservableList<String> choices = FXCollections.observableArrayList("All", "Liked", "Disliked");
    public ChoiceBox gameChoice =new ChoiceBox(FXCollections.observableArrayList(choices));
    public TableView n64Table;
    public TableColumn title;
    public TableColumn developer;
    public TableColumn publisher;
    public TableColumn release;

    public void initialize(){
        gameChoice.setItems(choices);
        gameChoice.setValue("All");
        n64Table.setItems(getGameList());
        title.setCellValueFactory(new PropertyValueFactory<>("title"));
        developer.setCellValueFactory(new PropertyValueFactory<>("developer"));
        publisher.setCellValueFactory(new PropertyValueFactory<>("publisher"));
        release.setCellValueFactory(new PropertyValueFactory<>("release"));

    }



    public void buttonClick(ActionEvent actionEvent) throws IOException {


    }
}