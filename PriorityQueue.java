

public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

	private Enlace<E> front;
	private Enlace<E> back;
	
	public PriorityQueue() {
		this.front = null;
		this.back = null;
	}

	@Override
	public void enqueue(E x) {
		if(this.isEmpty()) {
			//Por si esta vacio
			this.front = new Enlace<E>(x);
			this.back = front;
		} else {
			Enlace<E> aux = this.front, anterior = this.front;
			if(x.compareTo(this.front.valor) < 0) {
				//Si el primer nodo es mayor al que queremos insertar
				this.front = new Enlace<E>(x);
				this.front.siguiente = aux;
			} else {
				//Busca el lugar donde insertar nuestro nuevo nodo
				anterior = aux; //almacena el anterior nodo a aux
				aux = aux.siguiente; //aux se actualiza pero su referencia se guarda en anterior
				for(; aux != null; aux = aux.siguiente) {
					//Buscaremos por los nodos cual es el lugar donde agregar
					if (x.compareTo(aux.valor) < 0) {
						//Si se encontro el lugar donde agregarlo
						anterior.siguiente = new Enlace<E>(x, aux);
						break;
					} 
					anterior = aux;
				}
				if(aux == null) {
					//Si se debe agregar al final
					anterior.siguiente = new Enlace<E>(x);
					this.back = anterior.siguiente;
				}
			}
		}
	}

	@Override
	public E dequeue() {
		E aux = this.front.valor;
		this.front = this.front.siguiente;
		return aux;
	}

	@Override
	public E front() {
		return front.valor;
	}

	@Override
	public E back() {
		return back.valor;
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
			str = str + "\n" + aux.valor;
		}
		str = str + "\nFrente: " + front.valor + "\nFinal: " + back.valor;
		return str;
	}
}
