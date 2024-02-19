package MP2;

public class EditComponentCommand implements DocumentCommand {
	
	private DocumentParts component;
	private String text;
	private String newText;
	
	public EditComponentCommand(DocumentParts component, String newText) {
		this.component = component;
		this.text = component.getText();
		this.newText = newText;
	}

	@Override
	public void execute() {
		component.setText(newText);
		
	}

	@Override
	public void undo() {
		component.setText(text);
		
	}
}
