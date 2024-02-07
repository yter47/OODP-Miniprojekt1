package MP1;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Document implements DocumentParts{
	
	private Map<String, DocumentParts> parts;
	private int headerCounter = 0;
	private int paragraphCounter = 0;
	
	public Document() {
		this.parts = new HashMap<>(); 
	}
	
	public void addHeader(Header header) {
		String key = "Header" + (++headerCounter);
		parts.put(key, header);
	}
	
	public void addParagraph(Paragraph paragraph) {
		String key = "Paragraph" + (++paragraphCounter);
		parts.put(key, paragraph);
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
	
}
