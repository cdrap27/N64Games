package Read;

import Model.Game;
import Model.Users;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
    public static ObservableList<Game> dlGames = FXCollections.observableArrayList();

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

    public static void setDLGames(int i){

        try {
            List<String> values = Arrays.asList(lines.get(i).split(","));
            for (int j = 0; j < values.size(); j++) {
                Integer x = Integer.parseInt(values.get(j));
                //x = x - 1;
                dlGames.add(gameList.get(x));
            }
        }
        catch(Exception e){
            System.out.println("0");
        }
        System.out.println("added " + dlGames.size() + " to " + userList.get(i).getuName());




    }
    public static void writeDLGames(Users u) throws IOException {
        String line;
        System.out.println("saving");

        if(u.getID() >= lines.size()){
            line = "";
            lines.add(line);
        }
        else if (dlGamesCSV.dlGames.size() == 0){
            line = "";
            lines.set(u.getID(), line);
                    }
        else {
            line = String.valueOf(dlGamesCSV.dlGames.get(0).getID());
            for (int i = 1; i < dlGamesCSV.dlGames.size(); i++) {
                //if (i == (dlGamesCSV.dlGames.size() - 1)) {
                  //  System.out.println("exiting");
                    //line = (line + "," + dlGamesCSV.dlGames.get(i).getID() + "\n");
                //} else {
                    line = (line + "," + dlGamesCSV.dlGames.get(i).getID());
                //}
            }
            lines.set(u.getID(), line);
        }

        FileWriter fw = new FileWriter("dlGames.CSV");
       for(int i = 0; i < lines.size(); i++)
       {
           if(i == lines.size() -1)
           {
               fw.append(lines.get(i));
           }
           else
           {
           fw.append(lines.get(i) + "\n");
           }
       }
       fw.close();

    }
}
