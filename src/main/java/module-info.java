module database_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens database_project to javafx.fxml;
    exports database_project;
}