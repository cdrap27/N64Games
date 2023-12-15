package Read;

import Model.Game;
import Model.Users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            try {
                List<String> values = Arrays.asList(lines.get(i).split(","));
                for (int j = 0; j < values.size(); j++) {
                    Integer x = Integer.parseInt(values.get(j));
                    x = x - 1;
                    lGames.add(gameList.get(x));
                }
            }
            catch(Exception e){

            }
            System.out.println("added " + lGames.size() + " to " + userList.get(i).getuName());
            userList.get(i).setDlGames(lGames);
            lGames.clear();
        }

    }

    public static void writeDLGames(Users u) throws IOException {
        List<String> games = new ArrayList<String>();
        for(int i =0; i < u.getDlGames().size(); i++){
            games.add(String.valueOf(u.getDlGames().get(i).getID()));
        }
        String line;
        if(games.size() == 0){
            line = "";
        }
        else if(games.size() == 1){
            line = (games.get(0));
        }
        else {
            line = games.get(0);
            for (int i = 1; i < games.size(); i++) {
                if (i == (games.size() - 1)) {
                    System.out.println("exiting");
                    line = (line + "," + games.get(i) + "\n");
                } else {
                    line = (line + "," + games.get(i));
                }
            }
        }
        FileWriter fw = new FileWriter("dlGames.CSV", true);
        fw.append("\n" + line);
        fw.close();
        lines.add(line);

    }
}
