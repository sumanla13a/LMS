package edu.mum.cs.cs401.main;

import java.io.IOException;

import edu.mum.cs.cs401.entity.User;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class Main extends Application {
	private static User CurrentUser;

	private static Stage modalStage = new Stage();

	public static User getCurrentUser() {
		return CurrentUser;
	}

	public static void setCurrentUser(User currentUser) {
		CurrentUser = currentUser;
		modalStage.close();
	}

	@Override
	public void start(Stage stage) throws IOException {
		Util.generateTestData();
		Parent login = FXMLLoader.load(Main.class.getResource("login.fxml"));
		Parent member = FXMLLoader.load(Main.class.getResource("member.fxml"));
		Parent memberList = FXMLLoader.load(Main.class.getResource("memberList.fxml"));
		Parent checkout = FXMLLoader.load(Main.class.getResource("checkout.fxml"));
		Parent bookCopy = FXMLLoader.load(Main.class.getResource("bookCopy.fxml"));

		Util.showModal(modalStage, "Login", login);
		
		stage.setTitle("Library Management System : " + "(Roles: " + getCurrentUser().getRole() + ")");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		stage.setX(bounds.getMinX());
		stage.setY(bounds.getMinY());
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());

		VBox root = new VBox();
		// root.setAlignment(Pos.CENTER_LEFT);
		VBox menuContainer = new VBox();
		VBox formContainer = new VBox();
		formContainer.setAlignment(Pos.CENTER);
		root.getChildren().add(menuContainer);
		root.getChildren().add(formContainer);
		Scene scene = new Scene(root, 400, 350);
		scene.setFill(Color.OLDLACE);

		// ToolBar toolBar = new ToolBar();
		// Button openFileBtn = new Button("Add Member");
		// Button snapshotBtn = new Button("Checkout");
		// Button printBtn = new Button("Add Book Copy");
		// toolBar.getItems().addAll(openFileBtn, printBtn, snapshotBtn);
		// menuContainer.getChildren().addAll(toolBar);

		MenuBar menuBar = new MenuBar();

		//Member Menu
		if (getCurrentUser().hasRole("admin")) {
			Menu menuEdit = new Menu("Member");
			MenuItem add = new MenuItem("Add", new ImageView(new Image("img/add.png")));
			MenuItem listMember = new MenuItem("Member List", new ImageView(new Image("img/add.png")));
			menuEdit.getItems().addAll(add, listMember);

			add.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					formContainer.getChildren().clear();
					formContainer.getChildren().add(member);
				}
			});

			listMember.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					formContainer.getChildren().clear();
					formContainer.getChildren().add(memberList);
				}
			});
			menuBar.getMenus().addAll(menuEdit);
			formContainer.getChildren().add(member);
		}

		//Checkout Menu
		if (getCurrentUser().hasRole("lib")) {
			Menu menuCheckout = new Menu("Check Out");
			MenuItem btnCheckout = new MenuItem("Add");
			menuCheckout.getItems().addAll(btnCheckout);

			btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent t) {
					formContainer.getChildren().clear();
					formContainer.getChildren().add(checkout);
				}
			});
			menuBar.getMenus().addAll(menuCheckout);
			formContainer.getChildren().add(checkout);
		}

		//Book Menu
		Menu menuBook = new Menu("Book");
		MenuItem addBookCopy = new MenuItem("Add Book Copy", new ImageView(new Image("img/add.png")));
		menuBook.getItems().addAll(addBookCopy);

		addBookCopy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(bookCopy);
			}
		});
		menuBar.getMenus().addAll(menuBook);

		//User Menu
		Menu menuUser = new Menu(getCurrentUser().getFullName());
		MenuItem addLogout = new MenuItem("Logout", new ImageView(new Image("img/add.png")));
		menuUser.getItems().addAll(addLogout);

		addLogout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				modalStage.showAndWait();
			}
		});
		menuBar.getMenus().addAll(menuUser);
		

		menuContainer.getChildren().addAll(menuBar);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
