module controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens controller to javafx.fxml;

    exports controller;

    opens app to javafx.graphics;

    exports app;
}