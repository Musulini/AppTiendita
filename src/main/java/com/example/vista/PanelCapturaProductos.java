package com.example.vista;

import com.example.interfaces.Operable;
import com.example.model.Producto;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.lang.reflect.Field;

public class PanelCapturaProductos extends Application {
	private Operable<Producto> catalogo;
	private TextField titulo;
	private TextField codigoDeBarras;
	private TextField nombreField;
	private TextField marcaField;
	private TextArea descripcionArea;
	private ComboBox<String> categoriaCombo;
	private ComboBox<String> unidadDeMedida;
	private TextField contenidoField;
	private ComboBox<String> presentacionCombo;
	private CheckBox activoCheckBox;
	private TextField imageURLField;
	private Button guardarButton;
	private Button limpiarButton;

	public PanelCapturaProductos(Operable<Producto> catalogo) {
		this.catalogo = catalogo;
	}

	@Override
	public void start(Stage primaryStage) {
		// Título del formulario
		titulo = new TextField("Captura de productos");
		titulo.setFont(Font.font("Arial", FontWeight.BOLD, 20));

		// Crear campos del formulario
		codigoDeBarras = new TextField();
		codigoDeBarras.requestFocus();
		nombreField = new TextField();
		marcaField = new TextField();
		descripcionArea = new TextArea();
		categoriaCombo = new ComboBox<>();
		categoriaCombo.getItems().addAll("Bebidas", "Comestibles", "Electrónicos", "Otros");
		unidadDeMedida = new ComboBox<>();
		unidadDeMedida.getItems().addAll("Unidades", "Kilogramos", "Litros", "Gramos");
		contenidoField = new TextField();
		presentacionCombo = new ComboBox<>();
		presentacionCombo.getItems().addAll("Botella", "Caja", "Bolsa", "Lata");
		activoCheckBox = new CheckBox();
		imageURLField = new TextField();

		// Botones
		guardarButton = new Button("Guardar");
		limpiarButton = new Button("Limpiar");

		// Acciones de los botones
		guardarButton.setOnAction(e -> {
			// Lógica para guardar el producto
			if (cajasLlenas()) {
				if (catalogo.contains(new Producto(codigoDeBarras.getText()))) {
					JOptionPane.showMessageDialog(null, "El producto ya existe", "Error", JOptionPane.ERROR_MESSAGE);
				} else {

					Producto producto = new Producto(codigoDeBarras.getText());
					producto.setNombre(nombreField.getText());
					producto.setMarca(marcaField.getText());
					producto.setDescripcion(descripcionArea.getText());
					producto.setCategoria(categoriaCombo.getValue());
					producto.setUnidadMedida(unidadDeMedida.getValue());
					producto.setContenido(contenidoField.getText());
					producto.setPresentacion(presentacionCombo.getValue());
					producto.setActivo(activoCheckBox.isSelected());
					producto.setImagenUrl(imageURLField.getText());

					if (catalogo.add(producto)) {
						JOptionPane.showMessageDialog(null, "Producto agregadp", "Operación Exitosa", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Error al agregar producto", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
				codigoDeBarras.requestFocus();
			}
		});

		limpiarButton.setOnAction(e -> {
			// Limpiar todos los campos
			codigoDeBarras.clear();
			nombreField.clear();
			marcaField.clear();
			descripcionArea.clear();
			categoriaCombo.getSelectionModel().clearSelection();
			unidadDeMedida.getSelectionModel().clearSelection();
			contenidoField.clear();
			presentacionCombo.getSelectionModel().clearSelection();
			activoCheckBox.setSelected(false);
			imageURLField.clear();
		});

		// Crear el layout del formulario
		GridPane grid = new GridPane();
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(20, 20, 20, 20));

		// Agregar campos al grid
		grid.add(new Label("Código de Barras:"), 0, 0);
		grid.add(codigoDeBarras, 1, 0);
		grid.add(new Label("Nombre:"), 0, 1);
		grid.add(nombreField, 1, 1);
		grid.add(new Label("Marca:"), 0, 2);
		grid.add(marcaField, 1, 2);
		grid.add(new Label("Descripción:"), 0, 3);
		grid.add(descripcionArea, 1, 3);
		grid.add(new Label("Categoría:"), 0, 4);
		grid.add(categoriaCombo, 1, 4);
		grid.add(new Label("Unidad de Medida:"), 0, 5);
		grid.add(unidadDeMedida, 1, 5);
		grid.add(new Label("Contenido:"), 0, 6);
		grid.add(contenidoField, 1, 6);
		grid.add(new Label("Presentación:"), 0, 7);
		grid.add(presentacionCombo, 1, 7);
		grid.add(new Label("Disponible para la venta:"), 0, 8);
		grid.add(activoCheckBox, 1, 8);
		grid.add(new Label("URL de la Imagen:"), 0, 9);
		grid.add(imageURLField, 1, 9);

		// Botones en un HBox
		HBox botonesBox = new HBox(10, guardarButton, limpiarButton);
		botonesBox.setPadding(new Insets(20, 0, 0, 0));

		// Contenedor principal
		VBox root = new VBox(20, titulo, grid, botonesBox);
		root.setPadding(new Insets(20));

		// Crear la escena
		Scene scene = new Scene(root, 600, 600);
		primaryStage.setTitle("Captura de productos");
		primaryStage.setScene(scene);
		primaryStage.show();

		final int[] childrenCount = {0};
		grid.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				grid.getChildren().get(childrenCount[0] += 2).requestFocus();
			}
		});

	}

	private boolean cajasLlenas() {
		return !contenidoField.getText().isEmpty() &&
				!nombreField.getText().isEmpty() &&
				!marcaField.getText().isEmpty() &&
				!descripcionArea.getText().isEmpty() &&
				!unidadDeMedida.getValue().isEmpty() &&
				!contenidoField.getText().isEmpty() &&
				!presentacionCombo.getValue().isEmpty() &&
				!imageURLField.getText().isEmpty();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
