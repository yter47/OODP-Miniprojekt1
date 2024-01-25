package MP1;


public class DocumentBuilder implements DocumentBuilderInterface {

	@Override
	public void createDocument() {
			
	}

	@Override
	public void addHeader(String header) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParagraph(String paragraph) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}

}

class LetterDocumentBuilder implements DocumentBuilderInterface {
	
	private Document document;
	
	@Override
	public void createDocument() {
		document = new Document();
	}

	@Override
	public void addHeader(String header) {
		DocumentParts part = new Header(header);
		document.addParts(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		DocumentParts part = new Paragraph(paragraph);
		document.addParts(part);
	}

	@Override
	public Document getDocument() {
		return document;
		
	}	
}

class ExamPaperDocumentBuilder implements DocumentBuilderInterface {

	Document document;
	
	@Override
	public void createDocument() {
		document = new Document();
	}

	@Override
	public void addHeader(String header) {
		DocumentParts part = new Header(header);
		document.addParts(part);
	}

	@Override
	public void addParagraph(String paragraph) {
		DocumentParts part = new Paragraph(paragraph);
		document.addParts(part);
	}

	@Override
	public Document getDocument() {
		return document;
		
	}	
	
}
class CalendarDocumentBuilder implements DocumentBuilderInterface {

	@Override
	public void createDocument() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addHeader(String header) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParagraph(String paragraph) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Document getDocument() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
