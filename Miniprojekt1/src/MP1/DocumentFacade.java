package MP1;

import java.util.List;

public class DocumentFacade {
	
	private DocumentBuilderInterface builder;
	
	public DocumentFacade(DocumentBuilderInterface builder) {
		this.builder = builder;
	}
	public void createNewDocument() {
		builder.createDocument();
	}
	
	public void addHeader(String header) {
		builder.addHeader(header);
	}
	
	public void addParagraph(String paragraph) {
		builder.addParagraph(paragraph);
	}
	
	public void addList(List<String> items) {
		DocumentList list = new DocumentList();
		for (String item: items) {
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
	
	public void editPart(String key, String newText) {
		builder.getDocument().editPart(key, newText);
	}
	
	public Document getDocument() {
		return builder.getDocument();
		
	}

}
