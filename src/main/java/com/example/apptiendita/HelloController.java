package com.example.apptiendita;

import com.example.interfaces.Operable;
import com.example.model.Producto;
import com.example.vista.PanelCapturaProductos;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;

public class HelloController {
    @FXML
    private MenuBar menuBar;
    public MenuBar getMenuBar(){return menuBar;}

    @FXML
    private MenuItem opcionRegistrarProductos;

    private Operable<Producto> catalogo;

    @FXML
    private MenuItem opcionListarProductos;

    @FXML
    public void initialize(){
//        opcionRegistrarProductos.setOnAction(this::handleCapturaProductos);
        opcionRegistrarProductos.setOnAction(new OyenteRegistrarProductos());
        opcionListarProductos.setOnAction(new OyenteListarProductos());
    }
//    private void handleCapturaProductos(ActionEvent event){
//        JOptionPane.showMessageDialog(null, "Me hiciste click");
//    }


    private class OyenteRegistrarProductos implements EventHandler{
        @Override
        public void handle (Event event){
            lanzarPanelCapturaProductos();
        }
    }

    private class OyenteListarProductos implements EventHandler{
        @Override
        public void handle (Event event){
            try {
                VistaProductosController vistaController = new VistaProductosController(catalogo);
                // Cargar la interfaz de la tabla de productos
                FXMLLoader loader = new FXMLLoader(getClass().getResource("vistaProductos.fxml"));

                //establecer el controldor manuelmente
                loader.setController(vistaController);

                // Crear una nueva escena
                Scene scene = new Scene(loader.load(), 1200, 600);

                // Crear una nueva ventana
                Stage stage = new Stage();
                stage.setTitle("Tabla de Productos");
                stage.setScene(scene);

                // Mostrar la ventana
                stage.show();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void lanzarPanelCapturaProductos(){
        Stage stageCaptura= new Stage();
        PanelCapturaProductos panelCaptura=  new PanelCapturaProductos(catalogo);
        panelCaptura.start(stageCaptura);
    }

    public void setModel(Operable<Producto> catalogo){
        this.catalogo = catalogo;
    }
}
