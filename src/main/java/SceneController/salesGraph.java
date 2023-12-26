package SceneController;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class salesGraph {


    public ImageView graphImage;
    public Image image = new Image("C:\\Users\\gabby\\Desktop\\N64Games\\N64Games\\Top Selling N64 Games.png");


    public void initialize(){
        graphImage.setImage( image);

    }
}
