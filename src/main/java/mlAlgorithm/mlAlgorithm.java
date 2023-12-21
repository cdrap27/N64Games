package mlAlgorithm;

import Model.Game;
import Model.Users;
import Read.dlGamesCSV;
import Read.gamesCSV;
import Read.lGamesCSV;
import Read.topSellingCSV;
import SceneController.recommendedGames;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.util.Arrays;
import java.util.List;

public class mlAlgorithm {
    private static ObservableList<Game> rGames = FXCollections.observableArrayList();

    public static ObservableList<Game> getrGames() {
        return rGames;
    }

    public static void setrGames(Users u){
        ObservableList<Game> temp = FXCollections.observableArrayList();
        int reco = 0;
        int a = 0;
        int b = 0;
        double c = 0;
        for(int i = 1; i < lGamesCSV.getLines().size(); i++)
        {   if(i == u.getID())
            {
                System.out.println("skip");
            }
            else
            {
              temp = setTempList(lGamesCSV.getLines().get(i));
              for(int j = 0; j < lGamesCSV.lGames.size(); j++)
              {
                if(temp.contains(lGamesCSV.lGames.get(j))){
                    a++;
                }
                    b++;
              }
              if(((double)a / (double)b) > c){
                  rGames.clear();
                  c = (double)a / (double)b;
                  rGames = temp;
              }
              //temp.clear();
            }
        }
        if(rGames.size() <= 1){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Recommended Games");
            alert.setContentText("Uh Oh! Looks like we weren't able to find a recommendation based on" +
                    " your liked games.  Try liking some of the top selling games for the N64.");
            alert.showAndWait();

            rGames.clear();
            rGames = topSellingCSV.top40;
        }


    }
    public static void optimizeList(){
        for (int i =0; i < lGamesCSV.lGames.size(); i++){
            if(rGames.contains(lGamesCSV.lGames.get(i))){
                rGames.remove(lGamesCSV.lGames.get(i));
            }
        }
        for (int i =0; i < dlGamesCSV.dlGames.size(); i++){
            if(rGames.contains(dlGamesCSV.dlGames.get(i))){
                rGames.remove(dlGamesCSV.dlGames.get(i));
            }
        }
    }
    public static ObservableList<Game>setTempList(String games){
        ObservableList<Game> tempList = FXCollections.observableArrayList();
        List<String> value = Arrays.asList(games.split(","));
        for(int i = 0; i < value.size(); i++){
            Integer x = Integer.parseInt(value.get(i));
            tempList.add(gamesCSV.gameList.get(x));
        }
        return tempList;
    }
}
