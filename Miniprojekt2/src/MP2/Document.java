package MP2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Document implements DocumentParts, Iterable<DocumentParts> {

	private List<DocumentParts> parts;

	public Document() {
		this.parts = new ArrayList<>();
	}

	public DocumentParts getComponent(int index) {
		return parts.get(index);
	}

	public void addComponent(DocumentParts component) {
		parts.add(component);
	}

	public void addComponent(int index, DocumentParts component) {
		parts.add(index, component);
	}

	public void setComponent(int index, DocumentParts component) {
		if (index >= 0 && index < parts.size()) {
			parts.set(index, component);
		} else
			throw new IllegalArgumentException("No part at that index");

	}

	public void removeComponent(int index) {
		if (index >= 0 && index < parts.size()) {
			parts.remove(index);
		} else {
			throw new IllegalArgumentException("No part at that index!");
		}
	}

	public int indexOf(DocumentParts component) {
		return parts.indexOf(component);
	}

	@Override
	public String getText() {
		return parts.stream().map(DocumentParts::getText).collect(Collectors.joining("\n"));
	}

	@Override
	public void setText(String newText) {

	}

	@Override
	public Iterator<DocumentParts> iterator() {
		return new DocumentIterator();
	}

	public void removePart(int index) {
		if (index > 0 && index < parts.size()) {
			parts.remove(index);
		} else {
			throw new IllegalArgumentException("No part with that key!");
		}
	}

	private class DocumentIterator implements Iterator<DocumentParts> {

		private Iterator<DocumentParts> iterator = parts.iterator();

		@Override
		public boolean hasNext() {
			return iterator.hasNext();
		}

		@Override
		public DocumentParts next() {
			return iterator.next();
		}

	}

	@Override
	public void accept(DocumentConverterVisitor visitor) {
		for (DocumentParts part : this) {
			part.accept(visitor);
		}
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
	private java.util.List<DocumentParts> items;

	public DocumentList(List<String> listText) {
		this.items = listText.stream().map(ListItem::new).collect(Collectors.toList());
	}

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
	}
}

class Table implements DocumentParts, Iterable<TableRow> {
	private java.util.List<TableRow> rows;

	public Table(List<List<String>> tableRows) {
		this.rows = tableRows.stream().map(rowItems -> {
			TableRow row = new TableRow();
			for (String cell : rowItems) {
				row.addCell(new TableCell(cell));
			}
			return row;
		}).collect(Collectors.toList());
	}

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
		visitor.visitTableRow(this);
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
	}
}
