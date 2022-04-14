package chapter13;

public interface IGenericQueue<T> {
	
	void put(T ch) throws QueueFullException;
	
	T get() throws QueueEmptyException;

}
