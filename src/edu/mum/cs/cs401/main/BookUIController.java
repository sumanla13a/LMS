package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.entity.Address;
import edu.mum.cs.cs401.entity.Book;
import edu.mum.cs.cs401.entity.Member;
import edu.mum.cs.cs401.controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
//import javafx.scene.paint.Color;

public class BookUIController implements Initializable {

	@FXML
	private TextField isbnText;
	@FXML
	private TextField titleText;
	
	private BookController ctrl = BookController.getInstance();
	
	@Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }

	public void onSubmit(ActionEvent event) {
		Book book = new Book(isbnText.getText(), titleText.getText(), true);

		ctrl.addBook(book);

		for (Book b : ctrl.getAll()) {
			System.out.println(b.toString());
		}
	}
}
