//Codigo ref de teoria
public class GrafoLink<E> {
	protected ListEnlazada<Vertice<E>> listVert;
	
	public GrafoLink() {
		listVert = new ListEnlazada<Vertice<E>>();
	}
	
	public void insertVert(E data) {
		Vertice<E> nuevo = new Vertice<E>(data);
		if(this.listVert.contiene(nuevo) != null) {
			System.out.println("Vertice ya insertado");
			return;
		}
		this.listVert.agregar(nuevo);
	}
	
	public void insertArista(E verOrig, E verDest, boolean dirig) {
		insertArista(verOrig, verDest, -1, dirig);
	}
	
	public void insertArista(E verOrig, E verDest, int weight, boolean dirig) {
		Vertice<E> refOrig = this.listVert.contiene(new Vertice<E>(verOrig));
		Vertice<E> refDest = this.listVert.contiene(new Vertice<E>(verDest));
		
		if(refOrig == null || refDest == null) {
			System.out.println("Vertice origen / dest no existe");
			return;
		}
		if(refOrig.listArt.contiene(new Arista<E>(refDest)) != null) {
			System.out.println("Arista ya insertada");
			return;
		}
		if(dirig) { //si el enlace sera dirigido o no
			refOrig.listArt.agregar(new Arista<E>(refDest, weight));
		} else {
			refOrig.listArt.agregar(new Arista<E>(refDest, weight));
			refDest.listArt.agregar(new Arista<E>(refOrig, weight));
		}
	}
	
	public String toString() {
		return this.listVert.toString();
	}
}
