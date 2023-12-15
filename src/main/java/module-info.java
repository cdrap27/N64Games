module com.example.n64games {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens Main to javafx.graphics, javafx.fxml, javafx.base;
    opens Model to javafx.graphics, javafx.fxml, javafx.base;
    exports Model;
    exports Main;
    exports SceneController;
    opens SceneController to javafx.fxml;
}