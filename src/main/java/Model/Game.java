package Model;

public class Game {
    private int ID;
    private String title;
    private String developer;
    private String publisher;
    private String release;

    public Game(int ID, String title, String developer, String publisher, String release){
        this.ID = ID;
        this. title = title;
        this.developer = developer;
        this.publisher = publisher;
        this.release = release;
    }

    public int getID(){
        return ID;
    }
    public String getTitle(){
        return title;
    }
    public String getDeveloper(){
        return developer;
    }
    public String getPublisher(){
        return publisher;
    }
    public String getRelease(){
        return release;
    }


}
