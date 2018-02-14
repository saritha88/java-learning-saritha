package com.learning;

import java.util.logging.Logger;

public class Document {
	public static final Logger log=Logger.getLogger(Document.class.getName());

	public static void main(String[] args){
		try {
			
		Object e=EnumType.getEnumString(DocumentType.class,"adhaar");
		String str=e.toString();
		log.info(str);
		}catch(Exception e) {
			log.severe("error");
		}
		
	}
}
