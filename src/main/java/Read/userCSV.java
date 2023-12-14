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

public class userCSV {
    private static ArrayList<String> lines;
    public static ObservableList<Users> userList = FXCollections.observableArrayList();

    public static void setLines() throws IOException {
        String line;
        lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("Users.CSV"));
            while ((line = br.readLine()) != null)
            {
                lines.add(line);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }


    public static void setUsers()
    {
        List<Game> lGames = new ArrayList<Game>();
        List<Game> dlGames = new ArrayList<Game>();

        for(int i = 0; i < lines.size(); i++)
        {
            List<String> values = Arrays.asList(lines.get(i).split(","));
            Users u = new Users(i, values.get(0), values.get(1), values.get(2),values.get(3),values.get(4),lGames,dlGames);
            userList.add(u);
        }
    }

    public static void addUser(Users u) throws IOException {
        //FileWriter fw = new FileWriter("Users.CSV");
    }
}
