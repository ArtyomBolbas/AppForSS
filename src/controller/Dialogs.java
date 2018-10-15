package controller;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dialogs {
	public static void showErrorDialog(String errorText, String ImagePath) {
		System.out.println("method - showErrorDialog, class - Dialogs");

		Alert alert = new Alert(AlertType.ERROR);
		if (ImagePath != null) {
			Image imageError = new Image(ImagePath);
			ImageView imageViewError = new ImageView(imageError);
			alert.setGraphic(imageViewError);
		}
		alert.setTitle("Ошибка");
		alert.setHeaderText(null);
		alert.setContentText(errorText);
		alert.showAndWait();

	}
	
	public static void showWarningDialog(String warningText, String ImagePath) {
		System.out.println("method - showWarningDialog, class - Dialogs");

		Alert alert = new Alert(AlertType.WARNING);
		if (ImagePath != null) {
			Image imageWorning = new Image(ImagePath);
			ImageView imageViewWorning = new ImageView(imageWorning);
			alert.setGraphic(imageViewWorning);
		}
		alert.setTitle("Предупреждение");
		alert.setHeaderText(null);
		alert.setContentText(warningText);
		alert.showAndWait();
	}

	public static void showInformationDialog(String infoText, String ImagePath) {
		System.out.println("method - showInformationDialog, class - Dialogs");

		Alert alert = new Alert(AlertType.INFORMATION);
		if (ImagePath != null) {
			Image imageInfo = new Image(ImagePath);
			ImageView imageViewInfo = new ImageView(imageInfo);
			alert.setGraphic(imageViewInfo);
		}
		alert.setTitle("Информация");
		alert.setHeaderText(null);
		alert.setContentText(infoText);
		alert.showAndWait();
	}
	
	
}