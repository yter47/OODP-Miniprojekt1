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
