package Read;

import Model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class topSellingCSV {
    public static ArrayList<String> lines;
    public static ObservableList<Game> top40 = FXCollections.observableArrayList();
    public static void setLines(){
        String line;
        lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Top Selling.csv"));
            while ((line = br.readLine()) != null) {

                lines.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setGames(){
        String title;
        for(int i = 0; i < lines.size(); i++)
        {
            List<String> values = Arrays.asList(lines.get(i).split(","));
            title = values.get(0);
            title = title.substring(1, title.length()-1);
            for(int j = 0; j < gamesCSV.gameList.size(); j++)
            {
                if(gamesCSV.gameList.get(j).getTitle().contains(title))
                {
                    top40.add(gamesCSV.gameList.get(j));
                }
            }


        }

    }




}

