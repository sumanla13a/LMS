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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginUIController implements Initializable {
	@FXML
	private TextField userNameText;
	@FXML
	private PasswordField  passwordText;
	@FXML
	private Label messageLabel;

	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
	}

	public void onSubmit(ActionEvent event) {
		UserController userCtrl = UserController.getInstance();

		User user = userCtrl.getById(userNameText.getText());

		if (user == null || !user.getPassword().equals(passwordText.getText())) {
			messageLabel.setText("Invalid user name or password!");
		} else {
			Main.setCurrentUser(user);
		}
	}
}
