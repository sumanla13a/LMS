package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.controller.UserController;
import edu.mum.cs.cs401.entity.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginUIController implements Initializable {
	@FXML
	private TextField userNameText;
	
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
    }
    
    public void onSubmit(ActionEvent event) {
        UserController userCtrl = UserController.getInstance();
        
        User user = userCtrl.getById(userNameText.getText());
        
        Main.setCurrentUser(user);
    }
}
