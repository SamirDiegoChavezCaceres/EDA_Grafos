//codigo de teoria
public class Arista<E> {
	protected Vertice<E> refDest; //referencia al vertice
	protected int weight; //peso en caso de ponderado
	protected int label; // para algoritmos
	
	public Arista(Vertice<E> refDest) {
		this(refDest, -1);
	}
	
	public Arista(Vertice<E> refDest, int weight) {
		this.refDest = refDest;
		this.weight = weight;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Arista<?>) {
			Arista e = (Arista<E>) o;
			return this.refDest.equals(e.refDest);
		}
		return false;
	}
	
	public String toString() {
		if(this.weight > -1) return refDest.data+" <"+label+"> ["+this.weight+"], ";
		else return refDest.data+" <"+label+">, ";
	}
}
