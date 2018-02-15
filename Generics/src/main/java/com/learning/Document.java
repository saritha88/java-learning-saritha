package com.learning;

import java.util.logging.Logger;

public class Document {
	public static final Logger log = Logger.getLogger(Document.class.getName());

	public  <E extends EnumType, V> E getEnumString(Class<E> class1, V v) {

		for (E en : class1.getEnumConstants()) {
			if (en.getValue().equals(v)) {
				return en;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Document d=new Document();
		try {

			Object e = d.getEnumString(ValidationType.class, 2);
			if (e != null) {
				String str = e.toString();

				log.info(str);
			}
		} catch (NullPointerException e) {
			log.severe("error");
		}

	}
}
