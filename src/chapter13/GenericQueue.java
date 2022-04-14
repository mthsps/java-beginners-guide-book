package chapter13;

public class GenericQueue<T> implements IGenericQueue<T> {
	private T[] queue;
	private int putloc;
	private int getloc;
	
	public GenericQueue(T[] aRef) {
		queue = aRef;
		putloc = getloc = 0;
	}
	
	@Override
	public void put(T ch) throws QueueFullException {
		
		if (putloc==queue.length) {
			throw new QueueFullException(queue.length);
		}
		
		queue[putloc++] = ch;
		
		
	}

	@Override
	public T get() throws QueueEmptyException {
		

		if (getloc == putloc) {
			throw new QueueEmptyException();
		}
		
		return queue[getloc++];
	}

}
