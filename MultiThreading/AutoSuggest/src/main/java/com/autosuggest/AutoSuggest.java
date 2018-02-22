package com.autosuggest;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class AutoSuggest {
	
	public static final Logger logger = Logger.getLogger(AutoSuggest.class.getName());
    
		public static void main(String[] args) throws Exception {

			ExecutorService executer = Executors.newCachedThreadPool();

			Future<List<String>> future=executer.submit(new WordLengthCallable("/home/sarithab/Desktop/result/result.txt"));

			for (String str : future.get()) {

				logger.info(str);

			}
			
			
		}
	}

