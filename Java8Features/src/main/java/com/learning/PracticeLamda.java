package com.learning;

import java.util.ArrayList;
import java.util.List;

public class PracticeLamda {
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<>();
		list.add("Saritha");
		list.add("Sunil");
		list.add("prabal");
		list.add("krishna");
		list.add("vivel");
		list.forEach(str->System.out.println(str));
	}

}
