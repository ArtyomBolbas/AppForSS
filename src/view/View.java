package view;

import java.io.IOException;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class View {
	
	Image image = new Image("/resources/icon.png");
	
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
		
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
	        public void handle(WindowEvent we) {
	         System.out.println("Stage is closing");
	         }
	        });
		
		primaryStage.getIcons().add(image);
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
		primaryStage.getIcons().add(image);
		primaryStage.show();
	}
	
	public void showWindowEdit(Stage primaryStage) {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("/view/WindowEdit.fxml"));
		try {
			loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Parent root = loader.getRoot();
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.setTitle("AppForSS - Edit");
		primaryStage.getIcons().add(image);
		primaryStage.show();
	}

}
