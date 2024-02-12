package MP1;

public class DocumentFactory {
	
	public DocumentFacade createLetterDocument() {
		DocumentBuilderInterface builder = new LetterDocumentBuilder();
		return new DocumentFacade(builder); 
	}
	
	public DocumentFacade createExamPaperDocument() {
		DocumentBuilderInterface builder = new ExamPaperDocumentBuilder();
		return new DocumentFacade(builder);
	}	
	
	public DocumentFacade createCalendarDocument() {
		DocumentBuilderInterface builder = new CalendarDocumentBuilder();
		return new DocumentFacade(builder);
	}
}
