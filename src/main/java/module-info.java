module com.example.apptiendita {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.example.apptiendita to javafx.fxml, javafx.base;

    exports com.example.model;
    exports com.example.apptiendita;

}