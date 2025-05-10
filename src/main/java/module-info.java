module com.example.apptiendita {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;



    opens com.example.apptiendita to javafx.fxml, javafx.base;
    opens com.example.vista to javafx.fxml;


    exports com.example.model;
    exports com.example.apptiendita;

}