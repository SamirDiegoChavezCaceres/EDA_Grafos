
public class ListEnlazada<E> {

    private Enlace<E> cabeza;
    
    public ListEnlazada(){
        this.cabeza = null;
    }
    
    public boolean EstaVacio(){
        return this.cabeza==null;
    }
    
    public void agregar(E elemento){
        this.cabeza = new Enlace<E>(elemento, this.cabeza);
    }

    public Enlace<E> contiene(E elemento){
        Enlace<E> actual = this.cabeza;
        while(actual != null){
            if (actual.valor.equals(elemento)){
                return actual;
            }
            else {
                actual = actual.siguiente;
            }
        }
        return null;
    }
    
    public Enlace<E> cabeza(){
       return this.cabeza;
    }
    
    public void insertLast(E x) {
		if(this.EstaVacio())
			this.agregar(x);
		else {
			Enlace<E> lastNode = getLastNode();
			lastNode.siguiente = (new Enlace<E>(x));
		}
	}

	private Enlace<E> getLastNode() {
		Enlace<E> aux = this.cabeza();
		while(aux.siguiente != null)
			aux = aux.siguiente;
		return aux;
	}
	
    public String toString() {
    	String str = "";
    	Enlace<E> aux = this.cabeza;
    	while(aux != null) {
    		str = str + aux.valor;
    		aux = aux.siguiente;
    	}
    	return str;
    }
}
