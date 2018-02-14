package validators;

import java.util.List;

import model.DocumentType;

public interface Validation {
	
	boolean checkDocumentsAreValid(List<DocumentType> documents);

}
