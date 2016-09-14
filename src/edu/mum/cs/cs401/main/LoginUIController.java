package edu.mum.cs.cs401.main;

import java.net.URL;
import java.util.ResourceBundle;

import edu.mum.cs.cs401.controller.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LoginUIController implements Initializable {
//    private Button myButton; // Value injected by FXMLLoader

    @Override // This method is called by the FXMLLoader when initialization is complete
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
//        assert myButton != null : "fx:id=\"myButton\" was not injected: check your FXML file 'simple.fxml'.";

        // initialize your logic here: all @FXML variables will have been injected
    }
    
    public void onSubmit(ActionEvent event) {
        System.out.println("Login info submit");
    }
}
