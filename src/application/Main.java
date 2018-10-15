package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import view.View;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	private static View view = new View();
	
	@Override
	public void start(Stage primaryStage) {
		view.showWindowStart(primaryStage);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public static View getView() {
		return view;
	}
	
}

