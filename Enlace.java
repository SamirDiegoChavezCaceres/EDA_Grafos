public class Enlace<E> {
	public E valor;
    public Enlace<E> siguiente;
    public Enlace(E val) {
    	this(val, null);
    }
    public Enlace(E val, Enlace<E> sig){
    	this.valor = val;
        this.siguiente = sig;
    }
}
