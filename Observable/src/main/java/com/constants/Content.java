package com.constants;


public class Content {

	public ContentType getType() {
		return type;
	}

	public void setType(ContentType type) {
		this.type = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	ContentType type;
	Object value;
	public Content(ContentType type, Object value) {
		super();
		this.type = type;
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "Content [type=" + type + ", value=" + value + "]";
	}

	

	
}
