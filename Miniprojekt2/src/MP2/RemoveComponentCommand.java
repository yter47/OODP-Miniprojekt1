package MP2;

public class RemoveComponentCommand implements DocumentCommand {
	private Document document;
	private DocumentParts component;
	private int index;
	
	public RemoveComponentCommand(Document document, int index) {
		this.document = document;
		this.index = index;
		this.component = document.getComponent(index);
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
