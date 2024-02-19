package MP2;

public class HtmlConverter implements DocumentConverter, DocumentConverterVisitor {

	StringBuilder htmlOutput = new StringBuilder();

	@Override
	public void visitHeader(Header header) {
		htmlOutput.append("<h1>").append(header.getText()).append("</h1>");

	}

	@Override
	public void visitParagraph(Paragraph paragraph) {
		htmlOutput.append("<h1>").append(paragraph.getText()).append("</h1>");

	}

	@Override
	public void visitTable(Table table) {

	}

	@Override
	public void vistTableRow(TableRow tableRow) {
		// TODO Auto-generated method stub

	}

	@Override
	public void vistTableCell(TableCell tableCell) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitDocumentList(DocumentList documentList) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visitListItem(ListItem listItem) {
		// TODO Auto-generated method stub

	}

	@Override
	public String convert(Document document) {
		for (DocumentParts part : document) {
			part.accept(this);
		}
		return htmlOutput.toString();
	}
	
	public String getConvertedHtml() {
		return htmlOutput.toString();
	}

}
