/**
 * Sample Skeleton for "simple.fxml" Controller Class
 * Use copy/paste to copy paste this code into your favorite IDE
 **/

package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


public class MemberUIController
    implements Initializable {
	
	@FXML private TextField idText;
	@FXML private Button myButton; // Value injected by FXMLLoader
	@FXML private TextField firstNameText;
	@FXML private TextField lastNameText;
	@FXML private TextField streetAddressText;
	@FXML private TextField cityAddressText;
	@FXML private TextField zipAddressText;
	@FXML private TextField phoneNoText;
	@FXML private TextField stateAddressText;


    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected

    }
    
    public void onSubmit(ActionEvent event) {
    	System.out.println(idText.getText());
        System.out.println(firstNameText.getText());
        System.out.println(lastNameText.getText());
        System.out.println(phoneNoText.getText());
        System.out.println(streetAddressText.getText());
        System.out.println(cityAddressText.getText());
        System.out.println(stateAddressText.getText());
        System.out.println(zipAddressText.getText());
    }

}