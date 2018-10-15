package view;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class View {

	public void showWindowStart(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/WindowStart.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent root = loader.getRoot();
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.setTitle("AppForSS - Main");
		primaryStage.show();
	}
	
	public void showWindowAdd(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/WindowAdd.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent root = loader.getRoot();
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.setTitle("AppForSS - Add");
		primaryStage.show();
	}

}
