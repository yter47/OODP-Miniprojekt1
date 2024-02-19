package MP2;

public class HtmlConverter implements DocumentConverter, DocumentConverterVisitor {

	StringBuilder htmlOutput = new StringBuilder();

	@Override
	public void visitHeader(Header header) {
		htmlOutput.append("<h1>").append(header.getText()).append("</h1>\n");

	}

	@Override
	public void visitParagraph(Paragraph paragraph) {
		htmlOutput.append("<p1>").append(paragraph.getText()).append("</p1>\n");

	}

	@Override
	public void visitTable(Table table) {
		htmlOutput.append("<table>").append(table.getText()).append("</table>\n");
	}

	@Override
	public void vistTableRow(TableRow tableRow) {
		htmlOutput.append("<tr>").append(tableRow.getText()).append("</tr>\n");

	}

	@Override
	public void vistTableCell(TableCell tableCell) {
		htmlOutput.append("<th>").append(tableCell.getText()).append("</th>\n");
	}

	@Override
	public void visitDocumentList(DocumentList documentList) {
		htmlOutput.append("<ul>").append(documentList.getText()).append("</ul>\n");

	}

	@Override
	public void visitListItem(ListItem listItem) {
		htmlOutput.append("<li>").append(listItem.getText()).append("</li>\n");

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
