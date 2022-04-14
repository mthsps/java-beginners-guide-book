package chapter13;

public class GenericQueueDemo {
	
	public static void main(String[] args) {
		Integer[] intStore = new Integer[10];
		GenericQueue<Integer> queue = new GenericQueue<Integer>(intStore);
		
		Integer intValue;
		
		System.out.println("Queue of Integers");

		try {
			for (int i=0; i < 5; i++) {
				System.out.println("Adding " + i + " to queue.");
				queue.put(i);
			}
		} catch (QueueFullException exc) {
			System.out.println(exc);
		}
		System.out.println();
		
		try {
			for (int i=0; i < 5; i++) {
				System.out.println("Getting next Integer from queue: ");
				intValue = queue.get();
				System.out.println(intValue);
			}
			
		} catch (QueueEmptyException exc) {
			System.out.println(exc);
		}
		
		System.out.println();
		
		Double[] doubleStore = new Double[10];
		GenericQueue<Double> queue2 = new GenericQueue<Double>(doubleStore);
		Double doubleValue;
		
		System.out.println("Queue of Doubles");
		
		try {
			for (int i=0; i < 5; i++) {
				System.out.println("Adding " + (double)i/2 + " to queue2.");
				queue2.put((double)i/2);
			}
		} catch (QueueFullException exc) {
			System.out.println(exc);
		}
		System.out.println();
		
		try {
			
			for (int i =0; i < 6; i++) {
				System.out.println("Getting next Double from queue2: ");
				doubleValue = queue2.get();
				System.out.println(doubleValue);
			}
			
		} catch (QueueEmptyException exc) {
			System.out.println(exc);
		}
		
	}

}
