package com.learning;


public enum DocumentType implements EnumType<String> {
	
	PANCARD("pan","sar"),ADHAAR("adhaar"),BANKSTATEMENT("stmt");

	 String name;
	 String sar;
	 
	 DocumentType(String name) {
		this.name = name;
	}
	 DocumentType(String name,String sar) {
			this.name = name;
			this.sar = sar;
		}

	public String getName() {
		return name;
	}
	
	@Override
	public String getValue() {
		return name;
	}


}
