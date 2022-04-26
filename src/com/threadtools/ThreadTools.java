package com.threadtools;

public class ThreadTools {
	
	static Scheduler schedule(Runnable target, String id) {
		return new Scheduler(target, id);
	}
	public static void main(String args[]) {
		Person p1 = new Person("Ines", 1000);
		Person p2 = new Person("Efrain", 1500);
		SchedulerData shared = new SchedulerData("NO OWNER");
		Scheduler sp1 = new Scheduler(p1, "For Person 1");
		Scheduler sp2 = new Scheduler(p2, "For Person 2");
		p1.setSchedulerData(shared);
		p2.setSchedulerData(shared);
		sp1.schedule(3000, 3);
		sp2.schedule(2500, 5);
	}
}