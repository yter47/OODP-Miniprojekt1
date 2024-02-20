package MP2;

public class EditComponentCommand implements DocumentCommand {

	private Document document;
	private DocumentParts component;
	private DocumentParts newComponent;
	private int index;

	public EditComponentCommand(int index, Document document, DocumentParts newComponent) {
		this.document = document;
		this.index = index;
		
		try {
			this.component = document.getComponent(index);
			this.newComponent = newComponent;
		} catch (IndexOutOfBoundsException e) {
			String errorMessage = "Index finns ej " + e.getMessage();
			throw new IllegalArgumentException(errorMessage);
		}
		
	}

	@Override
	public void execute() {
		document.setComponent(index, newComponent);
	}

	@Override
	public void undo() {
		document.setComponent(index, component);
	}
}
