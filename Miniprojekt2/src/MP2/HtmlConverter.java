package MP2;

public class HtmlConverter implements DocumentConverter, DocumentConverterVisitor {

	StringBuilder htmlOutput = new StringBuilder();

	@Override
	public void visitHeader(Header header) {
		htmlOutput.append("<h1>").append(header.getText()).append("</h1>\n");
	}

	@Override
	public void visitParagraph(Paragraph paragraph) {
		htmlOutput.append("<p>").append(paragraph.getText()).append("</p>\n");
	}

	@Override
	public void visitTable(Table table) {
		htmlOutput.append("<table>\n");
		for (DocumentParts tableRow : table) {
				tableRow.accept(this);
		}
		
		htmlOutput.append("</table>\n");
	}

	@Override
	public void visitTableRow(TableRow tableRow) {
	    htmlOutput.append("<tr>\n");
	    for (TableCell cell : tableRow) {
	        htmlOutput.append("<td>").append(cell.getText()).append("</td>\n");
	    }
	    htmlOutput.append("</tr>\n");
	}

	@Override
	public void visitDocumentList(DocumentList documentList) {
		htmlOutput.append("<ul>\n");
		for (DocumentParts listItem : documentList) {
			htmlOutput.append("<li>").append(listItem.getText()).append("</li>\n");
		}
		htmlOutput.append("</ul>\n");
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
