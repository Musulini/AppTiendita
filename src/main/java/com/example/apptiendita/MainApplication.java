package com.example.apptiendita;

import com.example.interfaces.Operable;
import com.example.model.Contenedor;
import com.example.model.Producto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.swing.*;

import static com.example.dao.IOXUtility.*;

import java.io.IOException;

public class MainApplication extends Application {

	private static final String FILE_PATH = "productos";

	private Operable<Producto> catalogo;

	@Override
	public void start(Stage stage) throws IOException {
		catalogo = new Contenedor<>();
		catalogo.addAll(loadDataX(FILE_PATH));

		//catalogo.getAll().forEach(System.out::println);

		FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main.fxml"));
		Parent root = fxmlLoader.load();

		double screenWidth = Screen.getPrimary().getBounds().getWidth();
		double screenHeight = Screen.getPrimary().getBounds().getHeight();
		Scene scene = new Scene(root, screenWidth - 100, screenHeight - 100);

		MainController controller = fxmlLoader.getController();
		controller.setModel(catalogo);

		MenuBar menuBar = controller.getMenuBar();
		menuBar.prefWidthProperty().bind(stage.widthProperty().subtract(70));

		stage.setTitle("Ejemplo con MenuBar en FXML");
		stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("/css/Styles.css").toExternalForm());
		stage.show();

		stage.setOnCloseRequest(event -> {
			try {
				saveData(FILE_PATH, catalogo.getAll());
				JOptionPane.showMessageDialog(null, "Datos respaldados");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		});

	}

	public static void main(String[] args) {
		launch();
	}
}