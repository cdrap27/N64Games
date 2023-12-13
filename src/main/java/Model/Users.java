package Model;

public class Users {

    private int ID;
    private String uName;
    private String password;
    private String email;
    private String fName;
    private String lName;
    private Game[] lGames;
    private Game[] dlGames;

    public Users(int ID, String uName, String password, String email, String fName, String lName, Game[] lGames, Game[] dlGames){
        this.ID = ID;
        this.uName = uName;
        this.password = password;
        this.email = email;
        this.fName = fName;
        this.lName = lName;
        this.lGames = lGames;
        this.dlGames = dlGames;
    }

    public void setID(int ID){
        this.ID = ID;
    }
    public void setuName(String uName){
        this.uName = uName;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setfName(String fName){
        this.fName = fName;
    }
    public void setlName(String lName){
        this.lName = lName;
    }
    public void setlGames(Game[] lGames){
        this.lGames = lGames;
    }
    public void setDlGames(Game[] dlGames){
        this.dlGames = dlGames;
    }

    public int getID(){
        return ID;
    }
    public String getuName(){
        return uName;
    }
    public String getPassword(){
        return password;
    }
    public String getEmail(){
        return email;
    }
    public String getfName(){
        return fName;
    }
    public String getlName(){
        return lName;
    }
    public Game[] getlGames(){
        return lGames;
    }
    public Game[] getDlGames(){
        return dlGames;
    }
}
