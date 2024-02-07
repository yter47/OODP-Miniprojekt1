package MP1;

public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
		DocumentFacade letter = factory.createLetterDocument();
		letter.createNewDocument();
		letter.addHeader("Brev");
		letter.addParagraph("Detta är ett brev");
		System.out.println(letter.getDocument().getText());
		
		DocumentFacade paper = factory.createExamPaperDocument();
		paper.createNewDocument();
		paper.addHeader("Examensarbete");
		paper.addParagraph("Hej! detta är mitt examensarbete");
		paper.addParagraph("test");
		System.out.println(paper.getDocument().getText());
		paper.editPart("Header1", "Uppdaterade header1" );
		paper.editPart("Paragraph1", "Uppdaterade paragraph1");
		System.out.println(paper.getDocument().getText());
	}

}
