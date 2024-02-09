package MP1;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
		DocumentFacade letter = factory.createLetterDocument();
		letter.createNewDocument();
		letter.addHeader("Brev");
		letter.addParagraph("Detta �r ett brev");
		System.out.println(letter.getDocument().getText());
		
		DocumentFacade paper = factory.createExamPaperDocument();
		paper.createNewDocument();
		paper.addHeader("Examensarbete");
		paper.addParagraph("Hej! detta �r mitt examensarbete");
		paper.addParagraph("test");
		System.out.println(paper.getDocument().getText());
		
		//Redigerar Header1 och Paragraph1
		paper.editPart("Header1", "Uppdaterade header1" );
		paper.editPart("Paragraph1", "Uppdaterade paragraph1");
		printDocument(paper.getDocument());
		System.out.println();
		System.out.println();
		
		//Adderar en Lista
		List<String> list = Arrays.asList("1", "2", "3");
		paper.addList(list);
		printDocument(paper.getDocument());
		System.out.println();
		System.out.println();
		
		//Adderar en tabell
		List<List<String>> tableRows = Arrays.asList(
				Arrays.asList("Cell 1.1", "Cell 1.2"),
				Arrays.asList("Cell 1.2", "Cell 2.2"));
		paper.addTable(tableRows);
		printDocument(paper.getDocument());
		
		
	}
	
	public static void printDocument(Document document) {
		for(DocumentParts part : document) {
			System.out.println(part.getText());
		}
	}

}
