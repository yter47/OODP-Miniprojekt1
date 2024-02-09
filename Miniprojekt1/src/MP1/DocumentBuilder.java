package MP1;


public abstract class DocumentBuilder implements DocumentBuilderInterface {

	protected Document document;
	
	@Override
	public void createDocument() {
		document = new Document();
	}

	@Override
	public Document getDocument() {
		return document;
	}
}

class LetterDocumentBuilder extends DocumentBuilder {
	
	@Override
	public void addHeader(String header) {
		Header part = new Header(header);
		document.addHeader(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addParagraph(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addList(list);
	}

	@Override
	public void addTable(Table table) {
		document.addTable(table);	
	}
}

class ExamPaperDocumentBuilder extends DocumentBuilder {

	@Override
	public void addHeader(String header) {
		Header part = new Header(header);
		document.addHeader(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addParagraph(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addList(list);
		
	}

	@Override
	public void addTable(Table table) {
		document.addTable(table);
		
	}
}
class CalendarDocumentBuilder extends DocumentBuilder {

	@Override
	public void addHeader(String header) {
		Header part = new Header(header);
		document.addHeader(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addParagraph(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addList(list);
		
	}

	@Override
	public void addTable(Table table) {
		document.addTable(table);
		
	}
	
}
