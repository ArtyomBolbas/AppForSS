package application;
	
import org.apache.log4j.Logger;


import javafx.application.Application;
import javafx.stage.Stage;
import view.View;


public class Main extends Application {
	
	private static View view = new View();
	
	private static final Logger LOG =  Logger.getLogger(Main.class);
			
	
	@Override
	public void start(Stage primaryStage) {
		view.showWindowStart(primaryStage);
	}
	
	public static void main(String[] args) {
		LOG.info("Приложение AppForSS - запущенно!");
		LOG.debug("Запущен метод - main(String[] args); (Главный метод приложения), в классе -  Main");
		launch(args);
	}
	
	public static View getView() {
		return view;
	}
	
}

