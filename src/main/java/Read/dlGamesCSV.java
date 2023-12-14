package Read;

import Model.Game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Read.gamesCSV.gameList;
import static Read.userCSV.userList;

public class dlGamesCSV {
    private static ArrayList<String> lines;

    public static void setLines(){
        String line;
        lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("dlGames.CSV"));
            while ((line = br.readLine()) != null)
            {

                lines.add(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void setDLGames(){
        ArrayList<Game> lGames = new ArrayList<Game>();
        for(int i = 0; i < lines.size(); i++)
        {
            List<String> values = Arrays.asList(lines.get(i).split(","));
            for(int j = 0; j<values.size(); j++){
                Integer x = Integer.parseInt(values.get(j));
                x = x-1;
                lGames.add(gameList.get(x));
            }
            System.out.println("added " + lGames.size() + " to " + userList.get(i).getuName());
            userList.get(i).setDlGames(lGames);
            lGames.clear();
        }

    }
}
