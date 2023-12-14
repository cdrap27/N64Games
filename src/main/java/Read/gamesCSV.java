package Read;

import Model.Game;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class gamesCSV {
    private static ArrayList<String> lines;
    public static ObservableList<Game> gameList = FXCollections.observableArrayList();

    public static void setLines() throws IOException {
        String line;
        lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Games.CSV"));
            while ((line = br.readLine()) != null)
                {

                lines.add(line);
                }
            }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void setGames(){
        String year, title;
        for(int i = 0; i < lines.size(); i++)
        {
            List<String> values = Arrays.asList(lines.get(i).split(","));
            title = values.get(0);
            title = title.substring(1, title.length()-1);
            try
            {
                year = (values.get(3) + values.get(4));
            }
            catch(Exception e)
            {
                year = values.get(3);
            }
            Game g = new Game(i, title, values.get(1), values.get(2), year);
            gameList.add(g);
        }

    }



    }
