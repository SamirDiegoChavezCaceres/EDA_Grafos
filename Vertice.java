//Codigo de teoria
public class Vertice<E> implements Comparable<Vertice<E>> {
	protected E data;
	protected ListEnlazada<Arista<E>> listArt;
	protected int label; //0 unexp , 1 explored, 2 otro
	protected int dist; //para algoritmos
	protected Vertice<E> path;

	public Vertice(E data) {
		this.data = data;
		listArt = new ListEnlazada<Arista<E>>();
	}
	
	public E getData() {
		return data;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Vertice<?>) {
			Vertice<E> v = (Vertice<E>) o;
			return this.data.equals(v.data);
		}
		return false;
	}
	
	public String toString() {
		return this.data+" <"+label+"> --> "+this.listArt.toString()+"\n";
	}
	
	public int compareTo(Vertice<E> v) {
		return this.dist - v.dist;
	}

}
