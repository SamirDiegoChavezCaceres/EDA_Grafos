

public interface Lista<T> {
	boolean isEmptuList();
	int length();
	void destroyList();
	int search(T x);
	void insertLast(T x);
	void insertFirst(T x);
	void remove(T x);
	String toString();
}
