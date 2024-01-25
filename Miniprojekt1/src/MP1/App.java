package MP1;

public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
		DocumentFacade letter = factory.createLetterDocument();
		letter.createNewDocument();
		letter.addHeader("Brev");
		letter.addParagraph("Detta �r ett brev");
		Document doc = letter.getDocument();
		System.out.println(doc.getText());
		
		DocumentFacade paper = factory.createExamPaperDocument();
		paper.createNewDocument();
		paper.addHeader("Examensarbete");
		paper.addParagraph("Hej! detta �r mitt examensarbete");
		doc = paper.getDocument();
		System.out.println(doc.getText());
	}

}
