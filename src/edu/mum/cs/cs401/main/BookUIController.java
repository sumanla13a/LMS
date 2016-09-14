package edu.mum.cs.cs401.main;

//import java.awt.print.Book;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.prism.paint.Color;

import edu.mum.cs.cs401.entity.Book;

import edu.mum.cs.cs401.controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BookUIController implements Initializable {

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
//        assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
    }
    
    public void lookUpBook(ActionEvent event) {
        System.out.println("look up book ");
        System.out.println("look " + lookUpTextField.getText());
        
        String ISBNStr = lookUpTextField.getText(); 
        Book book = bookContr.getBookAccess().get(ISBNStr);
        LookResultLabel.setText(book.toString());
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
        	addBookResultLabel.setTextFill(javafx.scene.paint.Color.web("#0076a3"));
        } else {
        	addBookResultLabel.setText("book not fund");
        	addBookResultLabel.setTextFill(javafx.scene.paint.Color.web("#0076a3"));
        }
    }

}
