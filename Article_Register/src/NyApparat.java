import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;

public class NyApparat extends Alert {

	private TextField namnField = new TextField();
	private TextField prisField = new TextField();
	private TextField skickField = new TextField();
	
	public NyApparat() {
		super(AlertType.CONFIRMATION);
		super.setTitle("Ny apparat");
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(10);
		
		grid.addRow(0, new Label("Namn:"), namnField);
		grid.addRow(1, new Label("pris:"), prisField);
		grid.addRow(2, new Label("skick:"), skickField);
		setHeaderText(null);
		getDialogPane().setContent(grid);
		
	}
		public String getNamn() {
			return namnField.getText();
		}
		
		public double getPris() {
			return Double.parseDouble(prisField.getText());
		}
		
		public int getSkick() {
			return Integer.parseInt(skickField.getText());
		}

		
	}

