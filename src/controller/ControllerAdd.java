package controller;

import java.net.URL;


import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.stage.Stage;
import model.Human;

public class ControllerAdd {

	private static final Logger LOG = Logger.getLogger(ControllerAdd.class);

	private static String INFORMATION_EMPTY = "Поля \"Name\" и \"Age\" и \"Birthday\" не должны быть пустыми";
	private static String INFORMATION_FAIL = "В строке age должны быть только цифры";
	private static String INFORMATION_ADD_HUMAN = "Добавлен новый Human";

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField textFieldNameId;

	@FXML
	private TextField textFieldAgeID;

	@FXML
	private DatePicker datePickerID;

	@FXML
	private Button buttonSaveID;

	@FXML
	private Button buttonCancelID;

	@FXML
	void buttonCancel(ActionEvent event) {
		close();
	}

	@FXML
	void buttonSave(ActionEvent event) {
		LOG.debug(
				"Запущен метод - buttonSave(); (Метод проверет на корректность заполнения данных пользователем), в классе -  ControllerAdd");		
		if (!textFieldNameId.getText().isEmpty() && !textFieldAgeID.getText().isEmpty()
				&& datePickerID.getValue() != null) {
			addHuman();
		} else {
			Dialogs.showInformationDialog(INFORMATION_EMPTY, null);
		}
	}

	private void addHuman() {
		LOG.debug("Запущен метод - addHuman(); (Метод добавляет новую сущность Human), в классе -  ControllerAdd");
		TreeItem<Human> root = Transmitter.getTable().getRoot();
		try {
			TreeItem<Human> children = new TreeItem<>(new Human(textFieldNameId.getText(),
					Integer.parseInt(textFieldAgeID.getText()), datePickerID.getValue()));
			
			root.getChildren().add(children);
			
			
			Dialogs.showInformationDialog(INFORMATION_ADD_HUMAN, null);
			close();
		} catch (NumberFormatException e) {
			LOG.error("Ошибка - NumberFormatException; Methos - addHuman(); Class - ControllerAdd");
			textFieldAgeID.clear();
			Dialogs.showInformationDialog(INFORMATION_FAIL, null);
		}
	}

	private void close() {
		LOG.debug("Запущен метод - cancel(); (Метод закрывает окошко добавления Human), в классе -  ControllerAdd");
		Stage stage = (Stage) buttonCancelID.getScene().getWindow();
		stage.close();
	}

	@FXML
	void initialize() {
		//LOG.debug("Запущен метод - initialize(); (), в классе -  ControllerAdd");

	}
}
