public interface Queue<E> {
	void enqueue(E x);
	E dequeue();
	boolean isEmpty();
}
