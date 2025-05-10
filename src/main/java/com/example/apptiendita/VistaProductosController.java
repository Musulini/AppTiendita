package com.example.apptiendita;


import com.example.interfaces.Operable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.model.Producto;

import static com.example.utility.UserMessage.message;

public class VistaProductosController {

	@FXML
	private TableView<Producto> tablaProductos;

	@FXML
	private TableColumn<Producto, String> columnaCodigo;

	@FXML
	private TableColumn<Producto, String> columnaNombre;

	@FXML
	private TableColumn<Producto, String> columnaMarca;

	@FXML
	private TableColumn<Producto, String> columnaDescripcion;

	@FXML
	private TableColumn<Producto, String> columnaCategoria;

	@FXML
	private TableColumn<Producto, String> columnaUnidadMedida;

	@FXML
	private TableColumn<Producto, String> columnaContenido;

	@FXML
	private TableColumn<Producto, String> columnaPresentacion;

	@FXML
	private TableColumn<Producto, Boolean> columnaActivo;

	@FXML
	private TableColumn<Producto, String> columnaImagenUrl;

	private ObservableList<Producto> productos = FXCollections.observableArrayList();

	public VistaProductosController() {
	}

	public VistaProductosController(Operable<Producto> catalogo) {
		this.catalogo = catalogo;
	}

	//private ObservableList<Producto> productos = FXCollections.observableArrayList();
	private Operable<Producto> catalogo;

	@FXML
	public void initialize() {
		// Configurar las columnas de la tabla
		columnaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigoBarras"));
		columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		columnaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
		columnaDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
		columnaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
		columnaUnidadMedida.setCellValueFactory(new PropertyValueFactory<>("unidadMedida"));
		columnaContenido.setCellValueFactory(new PropertyValueFactory<>("contenido"));
		columnaPresentacion.setCellValueFactory(new PropertyValueFactory<>("presentacion"));
		columnaActivo.setCellValueFactory(new PropertyValueFactory<>("activo"));
		columnaImagenUrl.setCellValueFactory(new PropertyValueFactory<>("imagenUrl"));

		// Verificar y cargar los datos
		if (catalogo != null && !catalogo.isEmpty()) {
			productos.addAll(catalogo.getAll());
			tablaProductos.setItems(productos);
		} else {
			message("Vista Productos", "No hay productos en el catalogo", Alert.AlertType.INFORMATION);
		}
	}



}
