package com.learning;


public enum DocumentType implements EnumType<String> {
	
	PANCARD("pan"),ADHAAR("adhaar"),BANKSTATEMENT("stmt");

	
	 String name;
	
	 
	 DocumentType(String name) {
		this.name = name;
	}
	 
	
	@Override
	public String getValue() {
		return name;
	}
	


}
