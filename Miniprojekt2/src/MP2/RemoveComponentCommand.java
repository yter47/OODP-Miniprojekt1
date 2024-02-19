package MP2;

public class RemoveComponentCommand implements DocumentCommand {
	private Document document;
	private DocumentParts component;
	private int index;
	
	public RemoveComponentCommand(Document document, DocumentParts component) {
		this.document = document;
		this.component = component;
		this.index = document.indexOf(component);
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
