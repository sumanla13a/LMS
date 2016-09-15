package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.Observable;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.controller.BookController;
import edu.mum.cs.cs401.controller.CheckoutRecordController;
import edu.mum.cs.cs401.entity.Book;
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

public class BookListUIController implements Initializable {
	BookController ctrl = BookController.getInstance();
	@FXML
	private TableView<Book> tblMembers;
	@FXML
	private TableColumn<Book, String> isbnColumn;
	@FXML
	private TableColumn<Book, String> titleColumn;
	
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		isbnColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("ISBN"));
		titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));

		tblMembers.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
//		        System.out.println(newSelection);	        
		    }
		});
		
		load();
	}

	public void onSubmit(ActionEvent event) {
		load();
	}
	
	private void load(){
		ObservableList<Book> memberList = FXCollections.observableArrayList();
		for (Book m : ctrl.getAll()) {
			memberList.add(m);
			//System.out.println(m.toString());
		}
		tblMembers.setItems(memberList);
	}
}
