package com.learning;


public enum DocumentType implements EnumType {
	
	PANCARD("pan"),ADHAAR("adhaar"),BANKSTATEMENT("stmt");

	
	 String name;
	 int sar;
	 
	 DocumentType(String name) {
		this.name = name;
	}
	 
	
	
	@Override
	public String getValue() {
		return name;
	}


}
