package com.example.utility;

import javafx.scene.control.Alert;

public class UserMessage {
	public static Alert message(String titulo, String message, Alert.AlertType alertType){
		Alert alerta = new Alert(alertType);
		alerta.setTitle(titulo);
		alerta.setHeaderText(null);
		alerta.setContentText(message);
		alerta.showAndWait();
		return alerta;
	}
}
