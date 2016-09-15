/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.entity.Address;
import edu.mum.cs.cs401.entity.Member;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MemberUIController implements Initializable {
	MemberController ctrl = MemberController.getInstance();

	@FXML
	private TextField idText;
	@FXML
	private TextField firstNameText;
	@FXML
	private TextField lastNameText;
	@FXML
	private TextField phoneNumberText;

	@FXML
	private TextField streetAddressText;
	@FXML
	private TextField cityAddressText;
	@FXML
	private TextField stateAddressText;
	@FXML
	private TextField zipAddressText;

	@Override // This method is called by the FXMLLoader when initialization is
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

	}

	public void onSubmit(ActionEvent event) {
		Address address = new Address(streetAddressText.getText(), cityAddressText.getText(),
				stateAddressText.getText(), zipAddressText.getText());

		Member member = new Member(idText.getText(), firstNameText.getText(), lastNameText.getText(), phoneNumberText.getText(), address);

		ctrl.addNewMember(member);

//		for (Member m : ctrl.getAll()) {
//			System.out.println(m.toString());
//		}
	}

}