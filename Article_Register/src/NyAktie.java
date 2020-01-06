import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class NyAktie extends Alert {

	private TextField namnField = new TextField();
	private TextField antalField = new TextField();
	private TextField prisField = new TextField();
	
	public NyAktie() {
		super(AlertType.CONFIRMATION);
		super.setTitle("Ny aktie");
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(10);
		
		
		
		grid.addRow(0, new Label("Namn:"), namnField);
		grid.addRow(1, new Label("Antal:"), antalField);
		grid.addRow(2, new Label("pris:"), prisField);
		getDialogPane().setContent(grid);
		
	}
		public String getNamn() {
			return namnField.getText();
		}
		
		public int getAntal() {
			return Integer.parseInt(antalField.getText());
		}
		
		public double getPris() {
			return Double.parseDouble(prisField.getText());
		}

		
	}

