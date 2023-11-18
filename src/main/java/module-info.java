module com.example.n64games {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.n64games to javafx.fxml;
    exports com.example.n64games;
}