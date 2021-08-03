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
		Vertice<E> refOrig = this.listVert.contiene(new Vertice<E>(verOrig)).valor;
		Vertice<E> refDest = this.listVert.contiene(new Vertice<E>(verDest)).valor;
		
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
	
	private void initLabel() { //el pseudocodigo fue dado en teoria
		Enlace<Vertice<E>> aux = this.listVert.cabeza();
		for(; aux != null; aux = aux.siguiente) {
			aux.valor.label = 0;
			Enlace<Arista<E>> auxE = aux.valor.listArt.cabeza();
			for(; auxE != null; auxE = auxE.siguiente) {
				auxE.valor.label = 0;
			}
		}
		
	}
	
	public void DFS(E data) {
		Vertice<E> nuevo = new Vertice<E>(data);
		Vertice<E> v;
		if((v = this.listVert.contiene(nuevo).valor) == null) {
			System.out.println("Vertice no existe");
			return;
		}
		initLabel();
		DFSRecursivo(v, 0);
	}
	
	private void DFSRecursivo(Vertice<E> v, int i) {
		v.label = 1;
		Enlace<Arista<E>> e = v.listArt.cabeza();
		for(; e != null; e = e.siguiente) {
			System.out.println("Analizando en "+v.data+" a "+e.valor.refDest.data);
			if(e.valor.label == 0) {
				Vertice<E> w = e.valor.refDest;
				if(w.label == 0) {
					e.valor.label = 1;
					DFSRecursivo(w, ++i);
				} else {
					e.valor.label = 2; //back
				}
			}
		}
	}
	
	public void BFS(E data) {
		Vertice<E> nuevo = new Vertice<E>(data);
		Vertice<E> v;
		if((v = this.listVert.contiene(nuevo).valor) == null) {
			System.out.println("Vertice no existe");
			return;
		}
		initLabel();
		BFS(v);
	}
	
	private void BFS(Vertice<E> v) {
		QueueLink<Vertice<E>> seq = new QueueLink<>();
		seq.enqueue(v);
		v.label = 1;
		int i = 0;
		while(!seq.isEmpty()) {
			System.out.print("Vert\t --> Enlaces\n");
			System.out.println("Gen "+i+":\n"+seq+"\n");
			QueueLink<Vertice<E>> sigSeq = new QueueLink<Vertice<E>>();
			while(!seq.isEmpty()) {
				Vertice<E> vert = seq.dequeue();
				Enlace<Arista<E>> enlacVert = vert.listArt.cabeza();
				for(; enlacVert != null; enlacVert = enlacVert.siguiente) {
					if(enlacVert.valor.label == 0) {
						Vertice<E> w = enlacVert.valor.refDest;
						if(w.label == 0) {
							enlacVert.valor.label = 1;
							w.label = 1;
							sigSeq.enqueue(w);
						} else {
							enlacVert.valor.label = 2; //cross
						}
					}
				}
			}
			seq = sigSeq;
			i++;
		}
	}
	
	public void Dijkstra(E info) {
		PriorityQueue<Vertice<E>> q = new PriorityQueue<Vertice<E>>();
		
		Vertice<E> u = this.listVert.contiene(new Vertice<E>(info)).valor;
		
		Enlace<Vertice<E>> aux = this.listVert.cabeza();
		for(; aux!=null ; aux = aux.siguiente)  {
			if(aux.valor == u)
				aux.valor.dist = 0;
			else
				aux.valor.dist = 9999;
			aux.valor.path = null;
			aux.valor.label = 0;
			q.enqueue(aux.valor);
		}
		
		while(!q.isEmpty()) {
			System.out.println(q.toString());
			u = q.dequeue();
			u.label = 1;
			Enlace<Arista<E>> e = u.listArt.cabeza();
			for(;e != null; e = e.siguiente) {
				Vertice<E> z = e.valor.refDest;
				if(z.label == 0) {
					if(z.dist > (u.dist + e.valor.weight)) {
						z.dist = u.dist + e.valor.weight;
						z.path = u;
					}
				}
			}
			System.out.println(q.toString());
		}
		printDijkstra();
	}
	
	public void printDijkstra() {
		Enlace<Vertice<E>> aux = this.listVert.cabeza();
		System.out.println("\nVertex\t\tDistance\tPath");
		for(; aux != null; aux = aux.siguiente) {
			Vertice<E> ver = aux.valor;
			if(ver.path != null)
				System.out.println(ver.data+"\t\t"+ver.dist+"\t\t"+ver.path.data);
			else
				System.out.println(ver.data+"\t\t"+ver.dist+"\t\t --");
		}
	}
	

	private Enlace<Vertice<E>> revisar() { 
		Enlace<Vertice<E>> aux = this.listVert.cabeza();
		for(; aux != null; aux = aux.siguiente) {
			if(aux.valor.label == 0) {
				return aux;
			}
		}
		return null;
		
	}
	
	public boolean estaIncluidoEn(GrafoLink<E> b) {
		Enlace<Vertice<E>> ainicial = this.listVert.cabeza();
		System.out.println("Revisando desde el vertice: "+ainicial.valor.data);
		//Para grafos no conexos se tendria que probar con un solo vertice
		//y aquellos vertices sin revisar, se deberian revisar si estan en el grafo b
		boolean resultado = estaIncluidoEn(ainicial, b);
		boolean total = resultado;
		System.out.println("Resultado: "+resultado);
		while((ainicial = this.revisar()) != null) {
			System.out.println("Grafo no conexo revisando siguiente componente desde el vertice: "+ainicial.valor.data);
			resultado = estaIncluidoEn(ainicial, b);
			System.out.println("Resultado: "+resultado);
			total = resultado && total;
		}
		return total;
	}
	
	private boolean estaIncluidoEn(Enlace<Vertice<E>> ainicial, GrafoLink<E> b) { //Hace un recorrido BFS pero en el camino
		QueueLink<Vertice<E>> seq = new QueueLink<>();								//confirma que nuestro grafo b tenga los mismos elementos
		Vertice<E> v1 = ainicial.valor;												//en grafos conexos solo revisa un componente
		seq.enqueue(v1);
		v1.label = 1;
		Enlace<Arista<E>> aux;
		while(!seq.isEmpty()) {
			QueueLink<Vertice<E>> sigSeq = new QueueLink<Vertice<E>>();
			while(!seq.isEmpty()) {
				Vertice<E> vert = seq.dequeue();
				Enlace<Arista<E>> enlacVert = vert.listArt.cabeza();
				Vertice<E> vert2 = b.listVert.contiene(vert).valor;
				if(vert2 == null)
					return false;
				if(vert.equals(vert2)) {
					for(; enlacVert != null; enlacVert = enlacVert.siguiente) {
						
						if((aux = vert2.listArt.contiene(enlacVert.valor)) != null) {
							if(aux.valor.weight == enlacVert.valor.weight) {
								if(enlacVert.valor.label == 0) {
									Vertice<E> w = enlacVert.valor.refDest;
									if(w.label == 0) {
										enlacVert.valor.label = 1;
										w.label = 1;
										sigSeq.enqueue(w);
									} else {
										enlacVert.valor.label = 2; //cross
									}
								}
							} else {
								System.out.println("Pesos Diferentes a1"+aux.valor.weight+"-- a2"+enlacVert.valor.weight);
								return false;
							}
						} else {
							System.out.println("Aristas diferentes ("+enlacVert.valor+")no existe en el grafo parametro");
							return false;
						}
					}
				} else {
					System.out.println("Vertices Diferentes v1"+vert.data+"-- v2"+vert2.data);
					return false;
				}
			}
			seq = sigSeq;
		}
		return true;
	}
	
	public String toString() {
		return this.listVert.toString();
	}
}
