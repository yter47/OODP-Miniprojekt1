package MP2;

import java.util.Stack;

public class DocumentFacade {

	private DocumentBuilderInterface builder;
	private Stack<DocumentCommand> commandHistory = new Stack<>();

	public DocumentFacade(DocumentBuilderInterface builder) {
		this.builder = builder;
	}

	public void createNewDocument() {
		builder.createDocument();
	}

	public void addComponent(DocumentParts component) {
		DocumentCommand addCommand = new AddComponentCommand(builder.getDocument(), component);
		addCommand.execute();
		commandHistory.push(addCommand);
	}
	
	public void editComponent(int index, DocumentParts component) {
		DocumentCommand editCommand = new EditComponentCommand(index, builder.getDocument(), component);
		editCommand.execute();
		commandHistory.push(editCommand);
	}
	
	public void removeComponent(int index) {
		DocumentCommand removeCommand = new RemoveComponentCommand(builder.getDocument(), index);
		removeCommand.execute();
		commandHistory.push(removeCommand);
	}
	
	public void undo() {
		if (!commandHistory.isEmpty()) {
			DocumentCommand lastCommand = commandHistory.pop();
			lastCommand.undo();
		}
	}

	public Document getDocument() {
		return builder.getDocument();
	}
}
