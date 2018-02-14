package com.learning;

public class Factory {

	public  Keywords getMethods(String filename) {
		if(filename.equals("Multithreading_Task2_ProgrammingLanguages"))
		{
		return new ThreadingLanguages(filename);
		}
		if(filename.equals("Multithreading_Task_2_java Keywords")) {
			return new ThreadingKeywords(filename);
		}
		if(filename.equals("Multithreading_Task_2_fortune1000companies"))
		{
			return new ThreadingCompanies(filename);
		}
			
		return null;
		
	}
}
