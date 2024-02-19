package MP2;

import java.util.List;
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

	public void addList(List<String> items) {
		DocumentList list = new DocumentList();
		for (String item : items) {
			list.addItem(new ListItem(item));
		}
		builder.addList(list);
	}

	public void addTable(List<List<String>> rows) {
		Table table = new Table();
		for (List<String> rowItems : rows) {
			TableRow row = new TableRow();
			for (String cell : rowItems) {
				row.addCell(new TableCell(cell));
			}
			table.addRow(row);
		}
		builder.addTable(table);
	}

	public void editPart(int index, String newText) {
		DocumentParts component = builder.getDocument().getComponent(index);
		if (component != null) {
			DocumentCommand editCommand = new EditComponentCommand(component, newText);
			editCommand.execute();
			commandHistory.push(editCommand);
		} else {
			throw new IllegalArgumentException("No component at that index!");
		}
	}

	public Document getDocument() {
		return builder.getDocument();

	}

}
