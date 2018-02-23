package com.learning;

public enum DocumentType implements EnumType<String> {

	PANCARD {

		@Override

		public String getValue() {

			return "pan";
		}
	},
	ADHAAR{
	@Override

	public String getValue() {

		return "Adhaar";

	}

	},BANKSTATEMENT{

	@Override

	public String getValue() {

		return "statement";
	}};

	
	//  DocumentType(String name) { this.name = name; }
	 

	/*
	 * @Override public String getValue() { return name; }
	 */

}
