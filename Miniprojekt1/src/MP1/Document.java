package MP1;

import java.util.ArrayList;
import java.util.List;

public class Document implements DocumentParts{
	
	List<DocumentParts> parts;
	
	public Document() {
		this.parts = new ArrayList<>(); 
	}
	
	public void addParts(DocumentParts part) {
		parts.add(part);
	}
	
	@Override
	public String getText() {
		StringBuilder text = new StringBuilder();
		for(DocumentParts part : parts) {
			text.append(part.getText());
			text.append("\n");
		}
		return text.toString(); 
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
	
}
