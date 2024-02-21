package MP2;

public interface DocumentConverterVisitor {
	void visitHeader(Header header);
	void visitParagraph(Paragraph paragraph);
	void visitTable(Table table);
	void visitTableRow(TableRow tableRow);
	void visitDocumentList(DocumentList documentList);
}
