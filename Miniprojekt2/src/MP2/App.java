package MP2;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
        DocumentFacade letter = factory.createLetterDocument();
        letter.createNewDocument();
        letter.addComponent(new Header("brev"));
        letter.addComponent(new Paragraph("Detta �r ett brev"));

        DocumentFacade paper = factory.createExamPaperDocument();
        paper.createNewDocument();
        paper.addComponent(new Header("Examensarbete"));
        paper.addComponent(new Paragraph("Hej! Detta �r mitt examensarbete"));
        paper.addComponent(new Paragraph("test"));
        
        // Redigerar Header1 och Paragraph1
        paper.editPart(0, "Uppdaterade header1");
        paper.editPart(2, "Uppdaterade paragraph1");
        
        List<String> list = Arrays.asList("1", "2", "3");
		paper.addList(list);
		
		//Adderar en tabell
		List<List<String>> tableRows = Arrays.asList(
				Arrays.asList("Cell 1.1", "Cell 1.2"),
				Arrays.asList("Cell 1.2", "Cell 2.2"));
		paper.addTable(tableRows);
		printDocument(paper.getDocument());

        HtmlConverter htmlConverter = new HtmlConverter();

        printDocument(paper.getDocument());
       
        // Konverterar dokumentet till HTML
        paper.getDocument().accept(htmlConverter);
        String htmlResult = htmlConverter.getConvertedHtml();
        System.out.println(htmlResult);
    }
	
	public static void printDocument(Document document) {
		for(DocumentParts part : document) {
			System.out.println(part.getText());
		}
	}

}
