package MP2;

public interface DocumentParts {
	String getText();
	void setText(String newText);
	void accept(DocumentConverterVisitor visitor);
}
