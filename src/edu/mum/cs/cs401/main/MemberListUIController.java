package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.controller.CheckoutRecordController;
import edu.mum.cs.cs401.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MemberListUIController implements Initializable {
	MemberController ctrl = MemberController.getInstance();
	@FXML
	private TableView<Member> tblMembers;
	@FXML
	private TableColumn<Member, String> firstNameColumn;
	@FXML
	private TableColumn<Member, String> lastNameColumn;
	private CheckoutRecordController checkoutRecordCtrl = CheckoutRecordController.getInstance();
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		firstNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("firstName"));
		lastNameColumn.setCellValueFactory(new PropertyValueFactory<Member, String>("lastName"));

		tblMembers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		        System.out.println(newSelection);	        
			    System.out.println(checkoutRecordCtrl.getCheckoutRecordByUserId(newSelection.getId()));
		    }
		});
		
		load();
	}

	public void onSubmit(ActionEvent event) {
		load();
	}
	
	private void load(){
		ObservableList<Member> memberList = FXCollections.observableArrayList();
		for (Member m : ctrl.getAll()) {
			memberList.add(m);
			//System.out.println(m.toString());
		}
		tblMembers.setItems(memberList);
	}
}
