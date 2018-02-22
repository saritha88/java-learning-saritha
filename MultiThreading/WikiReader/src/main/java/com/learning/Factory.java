package com.learning;

import java.util.Optional;

public class Factory {

	
	
	public  Optional<Keywords> getInstance(Delimeter e) {
		if(e.equals(Delimeter.COMMA_SEPERATED))
		{
		return Optional.of(new ThreadingKeywords(e.getName()));
		}
		if(e.equals(Delimeter.TAB_SEPERATED)) {
			return Optional.of(new ThreadingCompanies(e.getName()));
		}
		if(e.equals(Delimeter.NEWLINE))
		{
			return Optional.of(new ThreadingLanguages(e.getName()));
		}
			
		return Optional.empty();
		
	}
}
