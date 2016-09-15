package edu.mum.cs.cs401.main;

import edu.mum.cs.cs401.controller.BookController;
import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.entity.Member;
import edu.mum.cs.cs401.entity.User;
import edu.mum.cs.cs401.entity.Book;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Util {
	public static void showModal(Stage window, String title, Parent body){
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		
		Scene scene = new Scene(body);
		window.setScene(scene);
		window.showAndWait();
	}
	
	public static void generateTestData(){
		UserController userCtrl = UserController.getInstance();
		MemberController memberCtrl = MemberController.getInstance();
		BookController bookCtrl = BookController.getInstance();
		
		userCtrl.addNew(new User("super", "super", "Yoseph Solomon", "admin,lib"));
		userCtrl.addNew(new User("admin", "admin", "Suman Lama", "admin"));
		userCtrl.addNew(new User("lib", "lib", "Alex Xie", "lib"));

		memberCtrl.addNewMember(new Member("981", "Alex", "Xie", "641 123 4567", null));
		memberCtrl.addNewMember(new Member("982", "Suman", "Lama", "641 231 9876", null));
		memberCtrl.addNewMember(new Member("983", "Yoseph", "Solomon", "641 321 3456", null));
		
		//Adding dummy books
		bookCtrl.addBook(new Book("1", "Java: The Complete Reference, Ninth Edition", true));
		bookCtrl.addBook(new Book("2", "50 Shades of Grey", true));
		bookCtrl.addBook(new Book("3", "How to be a bad programmer: 101", true));
}
}
