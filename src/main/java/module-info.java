module com.example.n64games {
    requires javafx.controls;
    requires javafx.fxml;


    opens Main to javafx.fxml;
    exports Main;
    exports Scenes;
    opens Scenes to javafx.fxml;
}