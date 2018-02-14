package com.learning;

public interface   EnumType<T>{
	
	T getValue();

	 public static  <E extends EnumType<?>, V>E getEnumString(Class<E> class1, V v) {

         for(E en: class1.getEnumConstants()){
        	 if(en.getValue().equals(v)) {
        		 return en;
        	 }
        	        }
   return null;
     }
}
