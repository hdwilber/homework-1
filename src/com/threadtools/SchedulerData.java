package com.threadtools;

interface SchedulerDataReceiver {
	public void setSchedulerData(SchedulerData shared);
}

public class SchedulerData {
	String text;
	public SchedulerData(String initialText) {
		text = initialText;
	}

	public synchronized String getText() {
		System.out.println("---> SHARED DATA: sending: " + text);
		return text;
	}
	public synchronized void setText(String newText) {
		System.out.println("---> SHARED DATA: updating: " + newText);
		text = newText;
	}
}
