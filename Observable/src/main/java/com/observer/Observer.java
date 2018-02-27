package com.observer;

import com.subject.Subject;

public interface Observer {

		public void update();
		
		public void setSubject(Subject sub);

}
