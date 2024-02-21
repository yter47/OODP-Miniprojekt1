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
}

class ExamPaperDocumentBuilder extends DocumentBuilder {
}
class CalendarDocumentBuilder extends DocumentBuilder {

	
}
