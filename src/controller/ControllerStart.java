package controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.TextFieldTreeTableCell;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import model.Human;
import view.View;

public class ControllerStart {

	private static final Logger LOG = Logger.getLogger(ControllerStart.class);

	private Stage primaryStage = new Stage();
	private static View view;

	private static String INFORMATION_NOT_SELECTED = "Выберите, пожалуйста, строку!";
	private static String INFORMATION_BRITHDAY = "Сегодня у этого Human день рождения!";

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
	private TreeTableColumn<Human, LocalDate> columnBirthday;

	@FXML
	void buttonAdd(ActionEvent event) {
		if (!primaryStage.isShowing()) {
			view.showWindowAdd(primaryStage);
		}
	}

	@FXML
	void buttonDelete(ActionEvent event) {
		TreeItem<Human> human = tableView.getSelectionModel().getSelectedItem();
		if (human == null) {
			Dialogs.showInformationDialog(INFORMATION_NOT_SELECTED, null);
		} else {
			tableView.getRoot().getChildren().remove(human);
		}
	}

	@FXML
	void buttonEdit(ActionEvent event) {
		TreeItem<Human> human = tableView.getSelectionModel().getSelectedItem();
		if (human == null) {
			Dialogs.showInformationDialog(INFORMATION_NOT_SELECTED, null);
		} else {
			if (!primaryStage.isShowing()) {
				view.showWindowEdit(primaryStage);
			}
		}
	}

	/*
	 * @FXML void treeTableViewMouseClicked(MouseEvent event) {
	 * if(event.getClickCount() == 2) { birthday(); } }
	 */

	@FXML
	void initialize() {
		LOG.debug("Запущен метод - initialize(); (), в классе -  ControllerStart");
		view = Main.getView();
		initTreeTableColumns();

		tableView.setOnMouseClicked(event -> {
			if (event.getButton().equals(MouseButton.PRIMARY) && event.getClickCount() == 2) {
				birthday();
			}
		});
	}

	private void birthday() {
		Human human = Transmitter.getTable().getSelectionModel().getSelectedItem().getValue();
		LocalDate now = LocalDate.now();

		try {
			if (now.getMonthValue() == human.getBirthday().getMonthValue()
					&& now.getDayOfMonth() == human.getBirthday().getDayOfMonth()) {
				Dialogs.showInformationDialog(INFORMATION_BRITHDAY, null);
			}
		} catch (NullPointerException e) {
			LOG.error("Error - NullPointerException, в методе birthday(), в классе ControllerStart");
		}
	}

	private void initTreeTableColumns() {
		LOG.debug("Запущен метод - initTreeTableColumns(); (), в классе -  ControllerStart");
		columnName.setCellFactory(TextFieldTreeTableCell.forTreeTableColumn());
		columnName.setCellValueFactory(new TreeItemPropertyValueFactory<Human, String>("name"));
		columnAge.setCellValueFactory(new TreeItemPropertyValueFactory<Human, Integer>("age"));
		columnBirthday.setCellValueFactory(new TreeItemPropertyValueFactory<Human, LocalDate>("birthday"));
		addRoot();
	}

	private void addRoot() {
		LOG.debug("Запущен метод - addRoot(); (метод добавляем корень с treeTableView), в классе -  ControllerStart");
		TreeItem<Human> root = new TreeItem<Human>(new Human("Humans", null, null));
		Transmitter.setTable(tableView);
		Transmitter.getTable();
		tableView.setRoot(root);
	}

}

class Transmitter {
	private static TreeTableView<Human> table;
	private static Logger LOG = Logger.getLogger(Transmitter.class);

	public static TreeTableView<Human> getTable() {
		LOG.debug("Запущен метод - getTable(); (), в классе -  Transmitter");
		return table;
	}

	public static void setTable(TreeTableView<Human> table) {
		LOG.debug("Запущен метод - setTable(); (), в классе -  Transmitter");
		Transmitter.table = table;
	}
}