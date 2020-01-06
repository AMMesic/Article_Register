import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;

public class NySmycken extends Alert {

	private TextField namnField = new TextField();
	private TextField stenarField = new TextField();
	CheckBox cbox = new CheckBox("Av guld");
	
	
	public NySmycken() {
		super(AlertType.CONFIRMATION);
		super.setTitle("Nytt smycke");
		GridPane grid = new GridPane();
		
		grid.setAlignment(Pos.CENTER);
		grid.setPadding(new Insets(10));
		grid.setHgap(5);
		grid.setVgap(10);
		
		grid.addRow(0, new Label("Name:"), namnField);
		grid.addRow(1, new Label("Stenar:"), stenarField);
		
		grid.addRow(2, cbox);
		setHeaderText(null);
		getDialogPane().setContent(grid);
		
	}
		public String getNamn() {
			return namnField.getText();
		}
		
		public int getStenar() {
			return Integer.parseInt(stenarField.getText());
		}
		
		public boolean avGuld() {
			return cbox.isSelected();
		}
		
		

		
	}

