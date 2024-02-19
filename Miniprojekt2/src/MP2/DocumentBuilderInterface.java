package MP2;

interface DocumentBuilderInterface {

	void createDocument();
	void addHeader(String header);
	void addParagraph(String paragraph);
	void addList(DocumentList list);
	void addTable(Table table);
	Document getDocument();
}
