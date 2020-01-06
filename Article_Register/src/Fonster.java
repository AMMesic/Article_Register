import java.util.Optional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Fonster extends Application {
	private TextArea display;

	private ArrayList<Vardesak> ting = new ArrayList<Vardesak>();
	Alert alert = new Alert(AlertType.ERROR);

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-font-weight: bold");
		primaryStage.setTitle("Sakregister ");

		display = new TextArea();
		display.setEditable(false);
		display.setStyle("-fx-font-alignment: center");
		root.setCenter(display);

		FlowPane top = new FlowPane();
		Label topLabel = new Label(" Värdesaker ");
		top.getChildren().add(topLabel);

		top.setAlignment(Pos.CENTER);
		top.setPrefWidth(100);
		top.setStyle("-fx-backround-color: white");

		FlowPane right = new FlowPane();
		Label rightLabel = new Label(" Sortering    ");

		right.getChildren().add(rightLabel);

		RadioButton radio1 = new RadioButton("Namn");
		// right.getChildren().add(radio1);
		RadioButton radio2 = new RadioButton("Värde");
		// right.getChildren().add(radio2);
		right.getChildren().addAll(radio1, radio2);

		ToggleGroup group = new ToggleGroup();
		radio1.setToggleGroup(group);
		radio2.setToggleGroup(group);

		radio1.setOnAction(new NamnHanterare());
		radio2.setOnAction(new VardeHanterare());
		right.setPrefWidth(75);
		top.setPrefWidth(100);
		top.setStyle("-fx-backround-color: white");

		// VBox vbox = new VBox();
		// vbox.getChildren().add(new RadioButton ("Namn "));
		// vbox.getChildren().add(new RadioButton("Värde"));
		// root.setRight(vbox);

		// Gör att det blir mer luft bakom varje knapp
		FlowPane bottom = new FlowPane();
		bottom.setPadding(new Insets(5));
		bottom.setHgap(5);
		// sätta den i mitten
		bottom.setAlignment(Pos.CENTER);
		bottom.setPrefWidth(100);
		bottom.setStyle("-fx-backround-color: white");

		// Deklarera samtliga
		root.setTop(top);
		root.setRight(right);
		root.setBottom(bottom);

		// Lägga till knappar längst ned
		Label bottomLabel = new Label("Ny: ");
		MenuButton menuButton = new MenuButton("Välj");
		MenuItem item1 = new MenuItem("Smycke");
		item1.setOnAction(new Nyhanterare());
		MenuItem item2 = new MenuItem("Aktie");
		item2.setOnAction(new Nyhanterare());
		MenuItem item3 = new MenuItem("Apparater");
		item3.setOnAction(new Nyhanterare());
		Button Visa = new Button("Visa");
		Button Krasch = new Button("Börskrasch");
		Krasch.setOnAction(new BorsKrasch());
		menuButton.getItems().addAll(item1, item2, item3);
		bottom.getChildren().addAll(bottomLabel, menuButton, Visa, Krasch);
		Visa.setOnAction(new VisaHanterare());
		Scene scene = new Scene(root, 500, 400);
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	class Nyhanterare implements EventHandler<ActionEvent> {

		@Override
		public void handle(ActionEvent event) {
			if (((MenuItem) event.getSource()).getText().equals("Aktie")) {
				nyAktie();
				// NyAktie dialog = new NyAktie();
				// Optional<ButtonType> result = dialog.showAndWait();
			} else if (((MenuItem) event.getSource()).getText().equals("Smycke")) {
				nySmycken();
				// NySmycken dialog = new NySmycken();
				// Optional<ButtonType> result = dialog.showAndWait();
			} else if (((MenuItem) event.getSource()).getText().equals("Apparater")) {
				nyApparat();
				// NyApparat dialog = new NyApparat();
				// Optional<ButtonType> result = dialog.showAndWait();
			}

		}

	}

	class VisaHanterare implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			display.clear();
			for (Vardesak a : ting)
				display.appendText(a.toString() + "\n");

		}
	}

	class BorsKrasch implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			for (Vardesak a : ting)
				if (a instanceof Aktier) {
					Aktier temp = (Aktier) a;
					temp.setKurs(0.0);

				}

		}

	}

	private void nyApparat() {
		NyApparat app = new NyApparat();
		Optional<ButtonType> result = app.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {

			String namn = app.getNamn();
			if (namn.isEmpty()) {
				alert.setContentText("Fel eller ingen inmatning av namn, försök igen!");
				alert.showAndWait();
			} else {

			try {
				Double pris = app.getPris();
				int skick = app.getSkick();
				if (app.getSkick() > 10 || app.getSkick() < 1) {
					alert.setContentText("Fel inmatning av nummer, var vänlig och mata in mellan 1 - 10!");
					alert.showAndWait();
				}
				Apparat ap1 = new Apparat(namn, pris, skick);
				ting.add(ap1);
				new VisaHanterare();
			}

			catch (NumberFormatException nfe) {
				alert.setContentText("Fel");
				alert.showAndWait();

			}
			}
		}
	}

	private void nyAktie() {
		NyAktie akt = new NyAktie();
		Optional<ButtonType> result = akt.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {
			String namn = akt.getNamn();
			if (namn.isEmpty()) {
				alert.setContentText("Fel inmatning av namn, var vänlig och försök igen!");
				alert.showAndWait();
			}else {

			try {
				int antal = akt.getAntal();

				double pris = akt.getPris();
				Aktier akt1 = new Aktier(namn, antal, pris);
				ting.add(akt1);
				new VisaHanterare();
			}

			catch (NumberFormatException nfe) {
				alert.setContentText("Fel");
				alert.showAndWait();

			}
		}
		}

	}

	private void nySmycken() {
		NySmycken smycken = new NySmycken();
		Optional<ButtonType> result = smycken.showAndWait();

		if (result.isPresent() && result.get() == ButtonType.OK) {

			String namn = smycken.getNamn();
			if (namn.isEmpty()) {
				alert.setContentText("Fel inmatning av namn, var vänlig och försök igen!");
				alert.showAndWait();
			} else {
			try {
				int stenar = smycken.getStenar();
				boolean avGuld = smycken.avGuld();
				Smycken smy = new Smycken(namn, avGuld, stenar);
				ting.add(smy);
				new VisaHanterare();
			} catch (NumberFormatException nfe) {
				alert.setContentText("Fel");
				alert.showAndWait();

			}
			}

		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	class NamnHanterare implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Collections.sort(ting, new NamnSort());
		}
	}

	class VardeHanterare implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Collections.sort(ting, new SortVarde());

		}
	}

	class NamnSort implements Comparator<Vardesak> {

		@Override
		public int compare(Vardesak o1, Vardesak o2) {
			return o1.getNamn().compareTo(o2.getNamn());
		}
	}

	class SortVarde implements Comparator<Vardesak> {
		@Override
		public int compare(Vardesak o1, Vardesak o2) {
			return Double.compare(o1.getVarde(), o2.getVarde());
		}
	}

}
