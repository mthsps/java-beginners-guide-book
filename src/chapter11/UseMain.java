package chapter11;

public class UseMain {

	public static void main(String[] args) {
		Thread thread;
		
		thread = Thread.currentThread();
		
		System.out.println("Main thread is called: " + thread.getName());
		
		System.out.println("Priority: " + thread.getPriority());
		
		System.out.println();
		
		System.out.println("Setting name and priority.\n");
		thread.setName("Thread #1");
		thread.setPriority(Thread.NORM_PRIORITY+3);
		
		System.out.println("Main thread is now called: " + thread.getName());
		
		System.out.println("Priotity is now: " + thread.getPriority());

	}

}
