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
import model.Human;

public class ControllerAdd {

	private static final Logger LOG = Logger.getLogger(ControllerAdd.class);

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

	}

	@FXML
	void buttonSave(ActionEvent event) {
		LOG.debug("Запущен метод - buttonSave(); (Сохранение свойств новой сущности - Human), в классе -  ControllerAdd");
		if (!textFieldNameId.getText().isEmpty() && !textFieldAgeID.getText().isEmpty()) {
	
		
		} else {
			Dialogs.showInformationDialog("Поля \"Name\" и \"Age\" и \"Birthday\" не должны быть пустыми", null);
		}
	}

	@FXML
	void datePicker(ActionEvent event) {

	}

	@FXML
	void textFieldAge(ActionEvent event) {

	}

	@FXML
	void textFieldName(ActionEvent event) {

	}

	@FXML
	void initialize() {

	}
}
