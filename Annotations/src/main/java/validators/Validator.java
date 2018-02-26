package validators;

public interface Validator<T,V> {
	

	public boolean isValid(T t,V v);

}
