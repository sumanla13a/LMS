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
	private static Stage primaryStage;
	private static Menu menuMember;
	private static Menu menuCheckout;
	private static Menu menuUser;

	public static User getCurrentUser() {
		return CurrentUser;
	}

	public static void setCurrentUser(User currentUser) {
		CurrentUser = currentUser;
		modalStage.close();
		resetMenu();
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		
		Util.generateTestData();

		Parent login = FXMLLoader.load(Main.class.getResource("login.fxml"));
		Parent member = FXMLLoader.load(Main.class.getResource("member.fxml"));
		Parent memberList = FXMLLoader.load(Main.class.getResource("memberList.fxml"));
		Parent checkout = FXMLLoader.load(Main.class.getResource("checkout.fxml"));
		Parent checkoutList = FXMLLoader.load(Main.class.getResource("checkoutList.fxml"));
		Parent book = FXMLLoader.load(Main.class.getResource("book.fxml"));
		Parent bookCopy = FXMLLoader.load(Main.class.getResource("bookCopy.fxml"));

		Util.showModal(modalStage, "Login", login);
		modalStage.setOnCloseRequest(e -> primaryStage.close());
		
		if(getCurrentUser() == null) System.exit(0);

		primaryStage.setTitle("Library Management System : " + "(Roles: " + getCurrentUser().getRole() + ")");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		primaryStage.setX(bounds.getMinX());
		primaryStage.setY(bounds.getMinY());
		primaryStage.setWidth(bounds.getWidth());
		primaryStage.setHeight(bounds.getHeight());

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

		// Member Menu
		Menu menuMember = new Menu("Member");
		Main.menuMember = menuMember;
		MenuItem add = new MenuItem("Add", new ImageView(new Image("img/add.png")));
		MenuItem listMember = new MenuItem("Member List", new ImageView(new Image("img/list.png")));
		menuMember.getItems().addAll(add, listMember);

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
		menuBar.getMenus().addAll(menuMember);
		formContainer.getChildren().add(member);

		// Checkout Menu
		Menu menuCheckout = new Menu("Check Out");
		Main.menuCheckout = menuCheckout;
		MenuItem btnCheckout = new MenuItem("Add", new ImageView(new Image("img/add.png")));
		MenuItem listCheckout = new MenuItem("Checkout List", new ImageView(new Image("img/list.png")));
		menuCheckout.getItems().addAll(btnCheckout, listCheckout);

		btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(checkout);
			}
		});
		listCheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(checkoutList);
			}
		});
		menuBar.getMenus().addAll(menuCheckout);
		formContainer.getChildren().add(checkout);

		// Book Menu
		Menu menuBook = new Menu("Book");
		MenuItem addBook = new MenuItem("Add Book", new ImageView(new Image("img/add.png")));
		MenuItem addBookCopy = new MenuItem("Add Book Copy", new ImageView(new Image("img/add.png")));
		menuBook.getItems().addAll(addBook, addBookCopy);

		addBook.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(book);
			}
		});

		addBookCopy.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				formContainer.getChildren().clear();
				formContainer.getChildren().add(bookCopy);
			}
		});
		menuBar.getMenus().addAll(menuBook);

		// User Menu
		Menu menuUser = new Menu(getCurrentUser().getFullName());
		Main.menuUser = menuUser;
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
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void resetMenu() {
		if (menuUser != null) {
			primaryStage.setTitle("Library Management System : " + "(Roles: " + getCurrentUser().getRole() + ")");
			menuUser.setText(getCurrentUser().getFullName());
			menuMember.setVisible(getCurrentUser().hasRole("admin"));
			menuCheckout.setVisible(getCurrentUser().hasRole("lib"));
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
