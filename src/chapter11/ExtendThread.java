package chapter11;

/*
 * Try This 11-1
 * 
 * Extend Thread.
 */

class MyThread extends Thread {
	MyThread(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(getName() + " starting.");
		try {
			for (int count=0; count < 100; count++) {
				Thread.sleep(4000);
				System.out.println("In " + getName() + ", count is " + count);
			}
		} catch (InterruptedException exc) {
			System.out.println(getName() + " interruped.");
		}
		
		System.out.println(getName() + " terminating.");
	}
	
	
	public static MyThread createAndStart(String name) {
		MyThread myThrd = new MyThread(name);
		myThrd.start();
		return myThrd;
	}
}


public class ExtendThread {
	
	public static void main(String[] args) {
		//System.out.println("Main thread starting.");
		//MyThread mt = new MyThread("Child #1");
		
		@SuppressWarnings("unused")
		MyThread mt = MyThread.createAndStart("Child #1");
		
		//mt.start();
		
		for (int i=0; i < 500; i++) {
			System.out.println(".");
			try {
				Thread.sleep(100);
			} catch (InterruptedException exc) {
				System.out.println("Main thread interruped.");
			}
		}
		
		System.out.println("Main thread interruped.");
	}
	
}
