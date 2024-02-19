package MP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Document implements DocumentParts, Iterable<DocumentParts> {
	
	private Map<String, DocumentParts> parts;
	private int headerCounter = 0;
	private int paragraphCounter = 0;
	private int listCounter = 0;
	private int tableCounter = 0;
	
	public Document() {
		this.parts = new LinkedHashMap<>(); 
	}
	
	public void addHeader(Header header) {
		String key = "Header" + (++headerCounter);
		parts.put(key, header);
	}
	
	public void addParagraph(Paragraph paragraph) {
		String key = "Paragraph" + (++paragraphCounter);
		parts.put(key, paragraph);
	}
	
	public void addList(DocumentList list) {
		String key = "List" + (listCounter++);
		parts.put(key, list);
	}
	
	public void addTable(Table table) {
		String key = "Table" + (tableCounter++);
		parts.put(key, table);
	}
	
	public void addParts(String key, DocumentParts part) {
		parts.put(key, part);
	}
	
	@Override
	public String getText() {
		return parts.values().stream().map(DocumentParts::getText).collect(Collectors.joining("\n"));
	}

	public void editPart(String key, String newText) {
		DocumentParts part = parts.get(key);
		if(part != null) {			
			part.setText(newText);
		} else {
			throw new IllegalArgumentException("No part with that key!");
		}
		
	}

	@Override
	public void setText(String newText) {
		
	}
	
	@Override
	public Iterator<DocumentParts> iterator() {
		return new DocumentIterator();
	}
	
	private class DocumentIterator implements Iterator<DocumentParts> {

		private Iterator<Map.Entry<String, DocumentParts>> entries = parts.entrySet().iterator();
		
		@Override
		public boolean hasNext() {
			return entries.hasNext();
		}

		@Override
		public DocumentParts next() {
			return entries.next().getValue();
		}
		
	}

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		// TODO Auto-generated method stub
		
	}
	
}

class Header implements DocumentParts {

	String header;
	
	Header(String header) {
		this.header = header;	
	}
	
	@Override
	public String getText() {
		return header;
	}

	@Override
	public void setText(String newText) {
		header = newText;
	}

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.visitHeader(this);
		
	}	
}

class Paragraph implements DocumentParts {

	String paragraph;
	
	Paragraph(String paragraph) {
		this.paragraph = paragraph;
	}
	
	@Override
	public String getText() {
		return paragraph;
	}

	@Override
	public void setText(String newText) {
		this.paragraph = newText;
	}

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.visitParagraph(this);
		
	}	
}

class DocumentList implements DocumentParts, Iterable<DocumentParts> {
    private java.util.List<DocumentParts> items = new ArrayList<>();

    public void addItem(DocumentParts item) {
        items.add(item);
    }

    @Override
    public String getText() {
        return items.stream().map(DocumentParts::getText).collect(Collectors.joining("\n"));
    }

    @Override
    public void setText(String newText) {
        throw new UnsupportedOperationException("Cannot set text directly on a list.");
    }

    @Override
    public Iterator<DocumentParts> iterator() {
        return items.iterator();
    }

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.visitDocumentList(this);
		
	}
}

class ListItem implements DocumentParts {

	private String list;
	
	ListItem(String text) {
		this.list = text;
	}
	
	@Override
	public String getText() {
		return list;
	}

	@Override
	public void setText(String newText) {
		this.list = newText;	
	}

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.visitListItem(this);
		
	}
	
}

class Table implements DocumentParts, Iterable<TableRow> {
    private java.util.List<TableRow> rows = new ArrayList<>();

    public void addRow(TableRow row) {
        rows.add(row);
    }

    @Override
    public String getText() {
        return rows.stream().map(TableRow::getText).collect(Collectors.joining("\n"));
    }

    @Override
    public void setText(String newText) {
        throw new UnsupportedOperationException("Cannot set text directly on a table.");
    }

    @Override
    public Iterator<TableRow> iterator() {
        return rows.iterator();
    }

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.visitTable(this);
	}   
}

class TableRow implements DocumentParts, Iterable<TableCell> {
    private java.util.List<TableCell> cells = new ArrayList<>();

    public void addCell(TableCell cell) {
        cells.add(cell);
    }

    @Override
    public String getText() {
        return cells.stream().map(TableCell::getText).collect(Collectors.joining(" | "));
    }

    @Override
    public void setText(String newText) {
        throw new UnsupportedOperationException("Cannot set text directly on a table row.");
    }

    @Override
    public Iterator<TableCell> iterator() {
        return cells.iterator();
    }

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.vistTableRow(this);
		
	}
}

class TableCell implements DocumentParts {
    private String text;

    TableCell(String text) {
        this.text = text;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String newText) {
        this.text = newText;
    }

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		visitor.vistTableCell(this);
		
	}
}

