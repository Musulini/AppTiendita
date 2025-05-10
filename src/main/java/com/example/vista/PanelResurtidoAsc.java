package com.example.vista;

import com.example.interfaces.Operable;
import com.example.model.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import static com.example.utility.UserMessage.message;

public class PanelResurtidoAsc {
	@FXML
	private TableView<Producto> refilledList;

	@FXML
	private TableColumn<Producto, String> columnaCodigo;

	@FXML
	private TableColumn<Producto, String> columnaNombre;
	@FXML
	private TableColumn<Producto, String> columnaFecha;
	@FXML
	private TableColumn<Producto, String> columnaCantidad;

	private ObservableList<Producto> productos = FXCollections.observableArrayList();

	public PanelResurtidoAsc() {
	}

	public PanelResurtidoAsc(Operable<Producto> refilledCatalogue) {
		this.refilledCatalogue = refilledCatalogue;
	}

	//private ObservableList<Producto> productos = FXCollections.observableArrayList();
	private Operable<Producto> refilledCatalogue;

	@FXML
	public void initialize() {
		// Configurar las columnas de la tabla
		columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("Codigo de Barras"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre del Producto"));
		columnaFecha.setCellValueFactory(new PropertyValueFactory<>("Fecha de Ingreso"));
		columnaCantidad.setCellValueFactory(new PropertyValueFactory<>("Cantidad"));

		// Verificar y cargar los datos
		if (refilledCatalogue != null && !refilledCatalogue.isEmpty()) {
			productos.addAll(refilledCatalogue.getAll());
			refilledList.setItems(productos);
		} else {
			message("Vista Productos", "No hay productos resurtidos", Alert.AlertType.INFORMATION);
		}
	}


}







