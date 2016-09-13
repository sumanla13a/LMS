package application;


import java.io.IOException;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class Main extends Application {
	@Override
	public void start(Stage stage) throws IOException {
		stage.setTitle("Menu Sample");
		Scene scene = new Scene(new VBox(), 400, 350);
		scene.setFill(Color.OLDLACE);

		MenuBar menuBar = new MenuBar();

		Menu menuEdit = new Menu("Member");
		MenuItem add = new MenuItem("Add");
		// MenuItem add = new MenuItem("Add", new ImageView(new
		// Image("menusample/new.png")));
		menuEdit.getItems().addAll(add);

		Menu menuCheckout = new Menu("Check Out");
		MenuItem btnCheckout = new MenuItem("Add");
		menuCheckout.getItems().addAll(btnCheckout);

		Menu menuView = new Menu("Add Book Copy");

		menuBar.getMenus().addAll(menuCheckout, menuEdit, menuView);

		ObservableList<Node> list = ((VBox) scene.getRoot()).getChildren();
		list.addAll(menuBar);
		list.addAll(new VBox());
		Parent member = FXMLLoader.load(Main.class.getResource("member.fxml"));
		Parent checkout = FXMLLoader.load(Main.class.getResource("checkout.fxml"));

		add.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				list.remove(list.size() - 1);
				list.add(member);
			}
		});

		btnCheckout.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent t) {
				list.remove(list.size() - 1);
				list.add(checkout);
			}
		});

		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
