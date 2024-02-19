package MP2;


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
		document.addComponent(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addComponent(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addComponent(list);
		
	}

	@Override
	public void addTable(Table table) {
		document.addComponent(table);
		
	}
}

class ExamPaperDocumentBuilder extends DocumentBuilder {

	@Override
	public void addHeader(String header) {
		Header part = new Header(header);
		document.addComponent(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addComponent(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addComponent(list);
		
	}

	@Override
	public void addTable(Table table) {
		document.addComponent(table);
		
	}
}
class CalendarDocumentBuilder extends DocumentBuilder {

	@Override
	public void addHeader(String header) {
		Header part = new Header(header);
		document.addComponent(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		Paragraph part = new Paragraph(paragraph);
		document.addComponent(part);
	}

	@Override
	public void addList(DocumentList list) {
		document.addComponent(list);
		
	}

	@Override
	public void addTable(Table table) {
		document.addComponent(table);
		
	}
	
}
