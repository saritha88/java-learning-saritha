package com.subject;

import com.constants.ContentType;
import com.observer.Observer;

public interface Subject {

	public void register(Observer obj);

	public void unregister(Observer obj);

	public void notifyObservers();

	public Object getUpdate(Observer obj);

	public void UpdateContent();

	public void RemoveContent();

	void addContent(ContentType type, String str);

}
