package MP2;

public interface DocumentConverterVisitor {
	void visitHeader(Header header);
	void visitParagraph(Paragraph paragraph);
	void visitTable(Table table);
	void vistTableRow(TableRow tableRow);
	void vistTableCell(TableCell tableCell);
	void visitDocumentList(DocumentList documentList);
	void visitListItem(ListItem listItem);
}
