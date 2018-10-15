package controller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;
import model.Human;
import view.View;

public class ControllerStart {
	
	private static ObservableList<Human> humansList = FXCollections.observableArrayList();

	private Stage primaryStage = new Stage();
	private static View view;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonAddID;

    @FXML
    private Button buttonEditID;

    @FXML
    private Button buttonDeleteID;
    
    @FXML
    private TreeTableView<Human> tableView;

    @FXML
    private TreeTableColumn<Human, String> columnName;

    @FXML
    private TreeTableColumn<Human, Integer> columnAge;

    @FXML
    private TreeTableColumn<Human, Date> columnBirthday;

    @FXML
    void buttonAdd(ActionEvent event) {
    	if (!primaryStage.isShowing()) {
    		view.showWindowAdd(primaryStage);
    	}
    }

    @FXML
    void buttonDelete(ActionEvent event) {

    }

    @FXML
    void buttonEdit(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
    	view = Main.getView();
    	//Вот тут возник вопрос , как передать humansList( - это ObservableList) tableView ????
    	tableView.setRoot(value);
    }
}
