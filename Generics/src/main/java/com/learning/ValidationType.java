package com.learning;

public enum ValidationType implements EnumType {
	
	EMAIL(1),NAME(2),TELNO(3);
	
	private int i;
	
	ValidationType(int i){
		this.i=i;
	}

	
	@Override
	public Integer getValue() {
		return i;
	}
	

}
