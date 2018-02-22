package com.learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadData {
	public static final Logger logger = Logger.getLogger(ReadData.class.getName());
	

	public static String getText(String url) throws IOException {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		StringBuilder response = new StringBuilder();
		try(BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))){
			
			String inputLine;
			while ((inputLine = in.readLine()) != null)
				response.append(inputLine);

		}catch(IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}

		
		return response.toString();
	}

	public static String getData(JSONObject obj) {
		@SuppressWarnings("unchecked")
		Set<JSONObject> keys = obj.keySet();
		String data = "";
		for (Object key : keys) {
			if (obj.get(key) instanceof JSONObject) {
				getData((JSONObject) obj.get(key));
			}
			if ("extract".equals(key.toString())) {
				return (String) obj.get(key);
			}
		}
		return data;

	}

	public static void writeDataToTxt() {
		Factory f = new Factory();
		Keywords key = null;
		try {
			for (Delimeter e : Delimeter.values()) {
				Optional<Keywords> g = f.getInstance(e);
				if (g.isPresent()) {
					key = g.get();
					List<String> list = key.getKeywords();
					for (int i = 1; i < list.size(); i++) {
						String s = list.get(i);
						s = URLEncoder.encode(s, "UTF-8");
						String baseurl = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles="
								+ s;
						String content = ReadData.getText(baseurl);

						JSONParser parser = new JSONParser();
						Object obj = parser.parse(content);
						JSONObject jsonObject = (JSONObject) obj;

						String str2 = ReadData.getData(jsonObject);
						if (str2 != null) {
							new Thread(new DataWriter(str2, i, s)).start();
						}
					}
					logger.info("finished");
				}
			}
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
	}
}