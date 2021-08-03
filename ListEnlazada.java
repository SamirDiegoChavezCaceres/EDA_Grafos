public class ListEnlazada<E> {

    private class Enlace{
        public E valor;
        public Enlace siguiente;
        public Enlace(E val, Enlace sig){
            this.valor = val;
            this.siguiente = sig;
        }
    }
    
    private Enlace cabeza;
    
    public ListEnlazada(){
        this.cabeza = null;
    }
    
    public boolean EstaVacio(){
        return this.cabeza==null;
    }
    
    public void agregar(E elemento){
        this.cabeza = new Enlace(elemento, this.cabeza);
    }

    public E contiene(E elemento){
        Enlace actual = this.cabeza;
        while(actual != null){
            if (actual.valor.equals(elemento)){
                return actual.valor;
            }
            else {
                actual = actual.siguiente;
            }
        }
        return null;
    }
    
    public String toString() {
    	String str = "";
    	Enlace aux = this.cabeza;
    	while(aux != null) {
    		str = str + aux.valor;
    		aux = aux.siguiente;
    	}
    	return str;
    }
}
