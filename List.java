

public class List <T> implements Lista<T> {
	
	private Node<T> first;
	private int count;
	
	public List() {
		this.first = null;
		this.count = 0;
	}
	
	@Override
	public boolean isEmptuList() {
		// TODO Auto-generated method stub
		return this.first == null;
	}

	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public void destroyList() {
		// TODO Auto-generated method stub
		while(this.first != null) {
			this.first = this.first.getNext();
		}
		this.count = 0;
	}

	@Override
	public int search(T x) {
		Node<T> aux = this.first;
		for(int i = 0; aux != null; aux = aux.getNext(), i++)
			if(aux.getData().equals(x))
				return i;
		return -1;
	}

	@Override
	public void insertLast(T x) {
		// TODO Auto-generated method stub
		
		if(this.isEmptuList())
			this.insertFirst(x);
		else {
			Node<T> lastNode = getLastNode();
			lastNode.setNext(new Node<T>(x));
			this.count++;
		}
	}

	//PreCondition: List is not empty
	private Node<T> getLastNode() {
		Node<T> aux = this.first;
		while(aux.getNext() != null)
			aux = aux.getNext();
		return aux;
	}

	@Override
	public void insertFirst(T x) {
		// TODO Auto-generated method stub
		this.first = new Node<T>(x,this.first);
		this.count++;
	}

	@Override
	public void remove(T x) {
		// TODO Auto-generated method stub
		//ver casos
	}
	
	public String toString() {
		String str = "";
		return str;
	}

}
