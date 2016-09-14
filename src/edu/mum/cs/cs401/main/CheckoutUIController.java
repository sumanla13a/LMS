package edu.mum.cs.cs401.main;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import edu.mum.cs.cs401.controller.CheckoutController;
import edu.mum.cs.cs401.entity.CheckoutEntryRecord;
import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.BookController;
public class CheckoutUIController implements Initializable {
	MemberController memberController = MemberController.getInstance();
	CheckoutController checkoutController = CheckoutController.getInstance();
	BookController bookController = BookController.getInstance();
	@FXML
	private TextField memberIdText;
	@FXML
	private TextField bookISBNText;
	@FXML
	private DatePicker dueDate;
	@FXML
	private DatePicker checkoutDate;
	@FXML
	private Label errorLabel;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void onCheckout(ActionEvent event) {
		String bookISBN = bookISBNText.getText()
				, memberId = memberIdText.getText();
		LocalDate coutDate = checkoutDate.getValue(),
				dDate = dueDate.getValue();
		if(bookISBN != null 
				&& memberId != null
				&& coutDate != null
				&& dDate != null) {

			if(memberController.getMemberById(memberId) != null) {
				if(bookController.getBookByISBN(bookISBN) != null) {
					CheckoutEntryRecord newRecord = new CheckoutEntryRecord();
					newRecord.setISBNNumber(bookISBN);
					newRecord.setCheckoutDate(coutDate);
					newRecord.setCurrentMemberId(memberId);
					newRecord.setDueDate(dDate);
				
					checkoutController.addRecord(newRecord);
					errorLabel.setText("");
				} else {
					errorLabel.setText("Book doesn't exist in the system");
				}
			} else {
				errorLabel.setText("User doesn't exist in the system");
			}
		} else {
			errorLabel.setText("Please fill in all fields");
		}
		

	}
}
