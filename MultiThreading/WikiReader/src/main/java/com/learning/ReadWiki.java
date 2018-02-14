package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadWiki {
	
	public static final Logger logger=Logger.getLogger(ReadWiki.class.getName());
	
	public static String getText(String url) throws IOException {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

		StringBuilder response = new StringBuilder();
		String inputLine;
		while ((inputLine = in.readLine()) != null)
			response.append(inputLine);

		in.close();
		return response.toString();
	}
public static String getData(JSONObject obj) {
	Set<JSONObject> keys=obj.keySet();
	String data="";
	for(Object key :keys) {
		if(obj.get(key) instanceof JSONObject) {
			getData((JSONObject)obj.get(key));
		}
		if("extract".equals(key.toString())) {
			return (String) obj.get(key);
		}
	}	
	return data;
	
}
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		logger.info("Please tell me the name of the file: ");
		String fileName = in.nextLine();
		Factory f=new Factory();
		Keywords g = f.getMethods(fileName);
		List<String> list = g.getKeywords();
		for (int i = 1; i < list.size(); i++) {
			String s = list.get(i);
			s = URLEncoder.encode(s, "UTF-8");
			String baseurl = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="+s;
			String content = getText(baseurl);

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(content);
			JSONObject jsonObject = (JSONObject) obj;

			String str2 = getData(jsonObject);
			if (str2!= null) {
				new Thread(new DataWriter(str2, i, s)).start();
			}
		}
		logger.info("finished");
	}
	
}
