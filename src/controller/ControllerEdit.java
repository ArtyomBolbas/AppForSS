package controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Human;

public class ControllerEdit {
	
	private static final Logger LOG = Logger.getLogger(ControllerEdit.class);

	private static String INFORMATION_FAIL = "Поля \"Name\" и \"Age\" и \"Birthday\" не должны быть пустыми";
	private static String INFORMATION_EDIT_HUMAN = "Human изменен";


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
    	LOG.debug("Запущен метод - buttonCancel(); (Метод закрывает окошко добавления Human), в классе -  ControllerEdit");
    	close();
    }

	@FXML
    void buttonSave(ActionEvent event) {
		LOG.debug("Запущен метод - buttonSave(); (Метод проверет на корректность заполнения данных пользователем), в классе -  ControllerEdit");
		if (!textFieldNameId.getText().isEmpty() && !textFieldAgeID.getText().isEmpty() && datePickerID.getValue() != null) {
			editHuman();
		} else {
			Dialogs.showInformationDialog(INFORMATION_FAIL, null);
		}
    }

    private void editHuman() {
    	Human human = Transmitter.getTable().getSelectionModel().getSelectedItem().getValue();
		human.setName(textFieldNameId.getText());
		human.setAge(Integer.parseInt(textFieldAgeID.getText()));
		//!!!!!!!!!!!!!!!!!!!!! Error
		human.setBirthday(datePickerID.getValue());
		Dialogs.showInformationDialog(INFORMATION_EDIT_HUMAN, null);
		Transmitter.getTable().refresh();
		close();
	}

	@FXML
    void initialize() {
		LOG.debug("Запущен метод - initialize(); (Метод инициализирует ком-ты, при запуске окна), в классе -  ControllerEdit");

    	Human human = Transmitter.getTable().getSelectionModel().getSelectedItem().getValue();
		textFieldNameId.setText(human.getName());
		textFieldAgeID.setText(String.valueOf(human.getAge()));
		datePickerID.setValue(human.getBirthday());
    }
    
    private void close() {
    	LOG.debug("Запущен метод - close(); (Метод закрывает окошко Edit), в классе -  ControllerEdit");
		Stage stage = (Stage) buttonCancelID.getScene().getWindow();
		stage.close();			
	}
}
