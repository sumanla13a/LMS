package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import edu.mum.cs.cs401.controller.CheckoutController;
import edu.mum.cs.cs401.entity.CheckoutEntryRecord;
import edu.mum.cs.cs401.controller.MemberController;
public class CheckoutUIController implements Initializable {
	MemberController memberController = MemberController.getInstance();
	CheckoutController checkoutController = CheckoutController.getInstance();
	@FXML
	private TextField memberIdText;
	@FXML
	private TextField bookISBNText;
	@FXML
	private DatePicker dueDate;
	@FXML
	private DatePicker checkoutDate;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void onCheckout(ActionEvent event) {
		if(memberController.getMemberById(memberIdText.getText()) != null) {
//			TODO: check for book case here as well
			if(bookISBNText.getText() != null 
					&& checkoutDate.getValue() != null
					&& bookISBNText.getText() != null
					&& dueDate.getValue() != null) {
				CheckoutEntryRecord newRecord = new CheckoutEntryRecord();
				newRecord.setISBNNumber(bookISBNText.getText());
				newRecord.setCheckoutDate(checkoutDate.getValue());
				newRecord.setCurrentMemberId(memberIdText.getText());
				newRecord.setDueDate(dueDate.getValue());
				
				checkoutController.addRecord(newRecord);
			}
		} else {
			System.out.println("User doesn't exist");
//			TODO: show message from here
		}
		

	}
}
