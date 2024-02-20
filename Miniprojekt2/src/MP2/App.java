package MP2;

import java.util.Arrays;
import java.util.List;

public class App {

	public static void main(String[] args) {
		DocumentFactory factory = new DocumentFactory();
        DocumentFacade paper = factory.createExamPaperDocument();
        
        paper.createNewDocument();
        paper.addComponent(new Header("Examensarbete"));
        paper.addComponent(new Paragraph("Hej! Detta �r mitt examensarbete"));
        paper.addComponent(new Paragraph("test"));
        
        printDocument(paper.getDocument());
        System.out.println();
        
        // Redigerar Header1 och Paragraph1
        paper.editComponent(0, new Header("Hej test med editComponent"));
        printDocument(paper.getDocument());
        System.out.println();
        
        //Testar undo() på första komponenten
        paper.undo();
        printDocument(paper.getDocument()); 
        System.out.println();
        
        List<String> list = Arrays.asList("1", "2", "3");
		paper.addComponent(new DocumentList(list));
		printDocument(paper.getDocument());
		System.out.println();
		
		paper.removeComponent(0);
		printDocument(paper.getDocument());
		System.out.println();
		
		paper.undo();
		printDocument(paper.getDocument());
		System.out.println();
		
		//Konverterar dokumentet till HTML
		HtmlConverter htmlConverter = new HtmlConverter();
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
