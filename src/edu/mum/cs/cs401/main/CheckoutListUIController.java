package edu.mum.cs.cs401.main;

import java.lang.management.MemoryPoolMXBean;
import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.controller.CheckoutRecordController;
import edu.mum.cs.cs401.entity.CheckoutRecord;
import edu.mum.cs.cs401.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class CheckoutListUIController implements Initializable {
	MemberController ctrl = MemberController.getInstance();
	private CheckoutRecordController checkoutRecordCtrl = CheckoutRecordController.getInstance();

	@FXML
	private TextField memberIdText;
	@FXML
	private TextArea checkoutListTextArea;

	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		load();
	}

	public void onSubmit(ActionEvent event) {
		checkoutListTextArea.clear();
		load();
	}

	private void load() {
		for (CheckoutRecord m : checkoutRecordCtrl.getAll()) {
			if (memberIdText.getText().isEmpty() || memberIdText.getText().equals(m.getCurrentMemberId())) {
				checkoutListTextArea.appendText(m.toString());
				checkoutListTextArea.appendText("\n");
			}
		}
	}
}
