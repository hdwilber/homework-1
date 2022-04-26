package com.threadtools;

public class Person implements Runnable, SchedulerDataReceiver {
	String id;
	SchedulerData sharedData;
	long sleepTime;
	public Person(String i, long sleep) {
		id = i;
		sleepTime = sleep;
	}
	@Override
	public void setSchedulerData(SchedulerData shared) {
		sharedData = shared;
	}
	public void logStatusAndUpdateSharedData(String status) {
		System.out.println("----------:  " + id + " :--------" );
		System.out.println("State: " + status);
		if (sharedData != null) {
			System.out.println("CURRENT DATA TEXT: " + sharedData.getText());
			sharedData.setText(id);
		}
		System.out.println("END ----------:  " + id + " :--------\n" );
	}
	@Override
	public void run() {
		while(true) {
			logStatusAndUpdateSharedData("RUNNING");
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}


