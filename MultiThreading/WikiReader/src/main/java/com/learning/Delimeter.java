package com.learning;

public enum Delimeter {

		TAB_SEPERATED("Multithreading_Task_2_fortune1000companies"),COMMA_SEPERATED("Multithreading_Task_2_java Keywords"),NEWLINE("Multithreading_Task2_ProgrammingLanguages");
	String name;

	private Delimeter(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
