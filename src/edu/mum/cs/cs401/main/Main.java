package edu.mum.cs.cs401.main;

import edu.mum.cs.cs401.controller.MemberController;
import edu.mum.cs.cs401.entity.Address;
import edu.mum.cs.cs401.entity.Member;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("Menu Sample");
		VBox root = new VBox();
		VBox menuContainer = new VBox();
		VBox formContainer = new VBox();
		root.getChildren().add(menuContainer);
		root.getChildren().add(formContainer);
		Scene scene = new Scene(root, 400, 350);
		scene.setFill(Color.OLDLACE);

//		ToolBar toolBar = new ToolBar();		
//		Button openFileBtn = new Button("Add Member");
//		Button snapshotBtn = new Button("Checkout");
//		Button printBtn = new Button("Add Book Copy");		 
//		toolBar.getItems().addAll(openFileBtn, printBtn, snapshotBtn);
//		menuContainer.getChildren().addAll(toolBar);

		MenuBar menuBar = new MenuBar();

		Menu menuEdit = new Menu("Member");
		MenuItem add = new MenuItem("Add", new ImageView(new Image("img/add.png")));
		menuEdit.getItems().addAll(add);

		Menu menuCheckout = new Menu("Check Out");
		MenuItem btnCheckout = new MenuItem("Add");
		menuCheckout.getItems().addAll(btnCheckout);

		Menu menuView = new Menu("Add Book Copy");

		menuBar.getMenus().addAll(menuCheckout, menuEdit, menuView);

		menuContainer.getChildren().addAll(menuBar);

		Parent member = FXMLLoader.load(Main.class.getResource("member.fxml"));
		Parent checkout = FXMLLoader.load(Main.class.getResource("checkout.fxml"));

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(member);
			}
		});

		btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(checkout);
			}
		});

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
