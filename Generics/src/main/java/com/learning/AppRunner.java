package com.learning;

import java.util.logging.Logger;

public class AppRunner {
	public static final Logger log = Logger.getLogger(AppRunner.class.getName());

	public  <E extends EnumType<?>, V> E getEnumString(Class<E> class1, V v) {

		for (E en : class1.getEnumConstants()) {
			if (en.getValue().equals(v)) {
				return en;
			}
}
		return null;
	}

	public static void main(String[] args) {
		AppRunner obj=new AppRunner();
		try {

			Object result = obj.getEnumString(ValidationType.class, 2);
			if (result != null) {
				String str = result.toString();

				log.info(str);
			}
		} catch (NullPointerException e) {
			log.severe("error");
		}

	}
}
