package MP2;

public class AddComponentCommand implements DocumentCommand {

	private Document document;
	private DocumentParts component;

	public AddComponentCommand(Document document, DocumentParts component) {
		this.document = document;
		this.component = component;
	}

	@Override
	public void execute() {
		document.addComponent(component);
	}

	@Override
	public void undo() {
		document.removeComponent(document.indexOf(component));
	}
}
