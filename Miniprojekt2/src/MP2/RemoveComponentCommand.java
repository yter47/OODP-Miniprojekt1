package MP2;

public class RemoveComponentCommand implements DocumentCommand {
	private Document document;
	private DocumentParts component;
	private int index;
	
	public RemoveComponentCommand(Document document, int index) {
		this.document = document;
		this.index = index;
		try {
			this.component = document.getComponent(index);
		} catch (IndexOutOfBoundsException e) {
			String errorMessage = "Index finns ej " + e.getMessage();
			throw new IllegalArgumentException(errorMessage);
		}
	}

	@Override
	public void execute() {
		document.removeComponent(index);
	}

	@Override
	public void undo() {
		document.addComponent(index, component);
	}
}
