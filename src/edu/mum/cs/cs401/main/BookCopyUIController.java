package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;
import edu.mum.cs.cs401.entity.Book;

import edu.mum.cs.cs401.controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.paint.Color;

public class BookCopyUIController implements Initializable {

	@FXML
	private TextField lookUpTextField;
	@FXML
	private Label LookResultLabel;
	@FXML
	private TextField addBookTextField;
	@FXML
	private Label addBookResultLabel;
	
	private BookController bookContr = BookController.getInstance();
	
	@Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }
    
    public void lookUpBook(ActionEvent event) {
        System.out.println("look up book ");
        System.out.println("look " + lookUpTextField.getText());
        
        String ISBNStr = lookUpTextField.getText(); 
        Book book = bookContr.getBookAccess().get(ISBNStr);
        if (book == null) {
        	LookResultLabel.setText("book not fund");
        	changeLabelColorwithResult(LookResultLabel, false);
        } else {
			LookResultLabel.setText(book.toString());
        	changeLabelColorwithResult(LookResultLabel, true);
        }
    }
    
    public void addBook(ActionEvent event) {
        System.out.println("add one book");
        System.out.println("add book copy ISBN: " + addBookTextField.getText());
        
        String ISBNStr = addBookTextField.getText();
        System.out.println("isbn is " + ISBNStr);
        
        boolean result =  bookContr.addBookCopy(ISBNStr);
        if (result == true) {
        	Book book = bookContr.getBookAccess().get(ISBNStr);
        	addBookResultLabel.setText(book.toString());
        	changeLabelColorwithResult(addBookResultLabel, true);
        } else {
        	addBookResultLabel.setText("book not fund");
        	changeLabelColorwithResult(addBookResultLabel, false);
        }
    }
    
    private void changeLabelColorwithResult(Label label, boolean success) {
    	if (success == true) {
    		label.setTextFill(javafx.scene.paint.Color.web("#0076a3"));
    	} else {
    		label.setTextFill(javafx.scene.paint.Color.web("#eb290f"));
    	}
    }

}
