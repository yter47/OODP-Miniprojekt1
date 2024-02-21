package MP2;

public class MarkDownConverter implements DocumentConverter, DocumentConverterVisitor {

	StringBuilder markDownOutput = new StringBuilder();

	@Override
	public void visitHeader(Header header) {
		markDownOutput.append("# ").append(header.getText()).append("\n");
	}

	@Override
	public void visitParagraph(Paragraph paragraph) {
		markDownOutput.append(paragraph.getText()).append("\n");

	}

	@Override
	public void visitTable(Table table) {
		for (DocumentParts tableRow : table) {
			tableRow.accept(this);
			markDownOutput.append("|\n");
		}
	}

	@Override
	public void visitTableRow(TableRow tableRow) {
		for (TableCell cell : tableRow) {
			markDownOutput.append("|").append(cell.getText());
		}
	}

	@Override
	public void visitDocumentList(DocumentList documentList) {
		for (DocumentParts listItem : documentList) {
			markDownOutput.append("- ").append(listItem.getText()).append("\n");
		}

	}

	@Override
	public String convert(Document document) {
		for (DocumentParts part : document) {
			part.accept(this);
		}
		return markDownOutput.toString();
	}

	public String getConverterMarkDown() {
		return markDownOutput.toString();
	}

}
