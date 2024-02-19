package MP2;

import java.util.Arrays;
import java.util.List;


public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
        DocumentFacade letter = factory.createLetterDocument();
        letter.createNewDocument();
        letter.addHeader("Brev");
        letter.addParagraph("Detta är ett brev");

        DocumentFacade paper = factory.createExamPaperDocument();
        paper.createNewDocument();
        paper.addHeader("Examensarbete");
        paper.addParagraph("Hej! Detta är mitt examensarbete");
        paper.addParagraph("test");

        // Redigerar Header1 och Paragraph1
        paper.editPart("Header1", "Uppdaterade header1");
        paper.editPart("Paragraph1", "Uppdaterade paragraph1");

        // Adderar en Lista
        List<String> list = Arrays.asList("1", "2", "3");
        paper.addList(list);

        // Adderar en tabell
        List<List<String>> tableRows = Arrays.asList(
                Arrays.asList("Cell 1.1", "Cell 1.2"),
                Arrays.asList("Cell 2.1", "Cell 2.2"));
        paper.addTable(tableRows);
        
        printDocument(paper.getDocument());

        // Create the HTML converter
        HtmlConverter htmlConverter = new HtmlConverter();

        // Convert the document to HTML
        paper.getDocument().accept(htmlConverter);

        // Retrieve the converted HTML
        String htmlResult = htmlConverter.getConvertedHtml();

        // Print the result
        System.out.println(htmlResult);
    }
	
	public static void printDocument(Document document) {
		for(DocumentParts part : document) {
			System.out.println(part.getText());
		}
	}

}
