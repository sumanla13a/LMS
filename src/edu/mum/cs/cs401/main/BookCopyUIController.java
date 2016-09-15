package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;
import edu.mum.cs.cs401.entity.Book;
import edu.mum.cs.cs401.entity.BookCopy;
import edu.mum.cs.cs401.controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.paint.Color;

public class BookCopyUIController implements Initializable {

	@FXML
	private TextField ISBNTextField;
	@FXML
	private Label resultLabel;
	
	private BookController bookContr = BookController.getInstance();
	
	@Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }
    
    public void lookUpBook(ActionEvent event) {
        System.out.println("look up with isbn: " + resultLabel.getText());
        
        String ISBN = ISBNTextField.getText(); 
        Book book = bookContr.getBookAccess().get(ISBN);
        if (book == null) {
        	resultLabel.setText("book not fund");
        	changeLabelColorwithResult(resultLabel, false);
        } else {
        	resultLabel.setText(book.toString());
        	changeLabelColorwithResult(resultLabel, true);
        }
    }
    
    public void addBook(ActionEvent event) {
        System.out.println("add book copy with ISBN: " + ISBNTextField.getText());
        
        String ISBN = ISBNTextField.getText();
        System.out.println("isbn is " + ISBN);
        
        BookCopy bookCopy =  bookContr.addBookCopy(ISBN);
        if (bookCopy != null) {
        	resultLabel.setText("add bookCopy success, copyNum is: " + bookCopy.getCopyNumber());
        	changeLabelColorwithResult(resultLabel, true);
        } else {
        	resultLabel.setText("book not fund");
        	changeLabelColorwithResult(resultLabel, false);
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
