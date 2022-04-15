package chapter11;

class TickTock {
	
	String state;
	
	synchronized void tick(boolean running) {
		if(!running) {
			state = "ticked";
			notify();
			return;
		}
		
		//System.out.println("Tick ");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		state = "ticked";
		
		notify();
		try {
			while(!state.equals("tocked"))
				wait();
		} catch (InterruptedException exc) {
			System.out.println("Thread interrupted");
		}
	}
	
	synchronized void tock(boolean running) {
		if(!running) {
			state = "tocked";
			notify();
			return;
		}
		
		//System.out.println("Tock");
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		state = "tocked";
		
		notify();
		
		try {
			while(!state.equals("ticked"))
				wait();
		} catch (InterruptedException exc) {
			System.out.println("Thread interrupted");
		}
	} 
}


class TheThread implements Runnable {
	Thread thread;
	TickTock clockOb;
	
	TheThread(String name, TickTock clock) {
		thread = new Thread(this, name);
		clockOb = clock;
	}
	
	public static TheThread createAndStart(String name, TickTock clock) {
		TheThread myThread = new TheThread(name, clock);
		
		myThread.thread.start();
		return myThread;
	}

	@Override
	public void run() {
		if(thread.getName().equals("Tick")) {
			for (int i=0; i<10; i++) {
				System.out.println("Tick: "+ i);
				clockOb.tick(true);
			}
			clockOb.tick(false);
		} else {
			
			for (int i=0; i<10; i++) {
				System.out.println("Tock: " + i);
				clockOb.tock(true);
			}
			clockOb.tock(false);
		}
		
	}
}

public class Question8 {
	public static void main(String[] args) {
		TickTock tt = new TickTock();
		TheThread mt1 = TheThread.createAndStart("Tick", tt);
		TheThread mt2 = TheThread.createAndStart("Tock", tt);
		
		try {
			mt1.thread.join();
			mt2.thread.join();
		} catch (InterruptedException exc) {
			System.out.println("Main thread interrupted");
		}
		
	}
}