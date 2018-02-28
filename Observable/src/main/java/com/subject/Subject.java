package com.subject;

import java.util.List;

import com.constants.Content;
import com.constants.ContentType;
import com.observer.Observer;

public interface Subject {

	public void register(Observer obj);

	public void unregister(Observer obj);

	public void notifyObservers();

	public Object getUpdate(Observer obj);

	public void UpdateContent(Content content);

	void addContent(Content content);

	void RemoveContent(Content cont);

}
