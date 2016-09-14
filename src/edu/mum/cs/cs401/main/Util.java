package edu.mum.cs.cs401.main;

import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.entity.User;
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
				
		userCtrl.addNew(new User("super", "super", "Yoseph Solomon", "admin lib"));
		userCtrl.addNew(new User("admin", "admin", "Suman lama", "admin"));
		userCtrl.addNew(new User("lib", "lib", "Alex Xie", "lib"));
	}
}
