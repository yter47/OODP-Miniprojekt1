package MP1;

public class DocumentFacade {
	
	private DocumentBuilderInterface builder;
	
	public DocumentFacade(DocumentBuilderInterface builder) {
		this.builder = builder;
	}
	public void createNewDocument() {
		builder.createDocument();
	}
	
	public void addHeader(String header) {
		builder.addHeader(header);
	}
	
	public void addParagraph(String paragraph) {
		builder.addParagraph(paragraph);
	}
	
	public Document getDocument() {
		return builder.getDocument();
		
	}

}
