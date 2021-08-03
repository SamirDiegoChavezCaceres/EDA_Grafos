
public class QueueLink<E> implements Queue<E> {
	
	private Enlace<E> front;
	private Enlace<E> back;
	
	public QueueLink() {
		this.front = null;
		this.back = null;
	}

	@Override
	public void enqueue(E x) {
		if(this.isEmpty()) {
			this.front = new Enlace<E>(x);
			this.back = front;
		} else {
			this.back.siguiente = (new Enlace<E>(x));
			this.back = this.back.siguiente;
		}
	}

	@Override
	public E dequeue() {
		E aux = this.front.valor;
		this.front = this.front.siguiente;
		return aux;
	}

	@Override
	public boolean isEmpty() {
		return this.front == null;
	}
	
	public String toString() {
		if(isEmpty()) {
			return "\nCola Vacia\n";
		}
		String str="";
		Enlace<E> aux = this.front;
		for(; aux!=null; aux = aux.siguiente) {
			str = str + "# " + aux.valor;
		}
		return str;
	}
}
