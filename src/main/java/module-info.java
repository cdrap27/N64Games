module com.example.n64games {
    requires javafx.controls;
    requires javafx.fxml;


    opens Main to javafx.fxml;
    exports Main;
    exports SceneController;
    opens SceneController to javafx.fxml;
}