package com.learning;

public enum ValidationType {
	
	EMAIL(1),NAME(2),TELNO(3);
	
	private int i;
	
	ValidationType(int i){
		this.i=i;
	}

	
	public Integer getValue() {
		return i;
	}


}
