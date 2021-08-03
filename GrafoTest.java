
public class GrafoTest {
	public static void main(String[] args) {
		GrafoLink<String> g = new GrafoLink<String>();
		
		/* 
		//TEST DIJKSTRA 
		//Problema obtenido de las diapositivas de teoria, cumple con lo esperado
		g.insertVert("HNL");
		g.insertVert("LAX");
		g.insertVert("SFO");
		g.insertVert("ORD");
		g.insertVert("DFW");
		g.insertVert("LGA");
		g.insertVert("PVD");
		g.insertVert("MIA");
		
		g.insertArista("HNL", "LAX", 2555,false);
		g.insertArista("LAX", "SFO", 337,false);
		g.insertArista("LAX", "DFW", 1233,false);
		g.insertArista("LAX", "ORD", 1743,false);
		g.insertArista("SFO", "ORD", 1843,false);
		g.insertArista("DFW", "ORD", 802,false);
		g.insertArista("ORD", "PVD", 849,false);
		g.insertArista("DFW", "LGA", 1387,false);
		g.insertArista("LGA", "PVD", 142,false);
		g.insertArista("DFW", "MIA", 1120,false);
		g.insertArista("LGA", "MIA", 1099,false);
		g.insertArista("PVD", "MIA", 1205,false);
		
		g.Dijkstra("PVD");
		*/
		
		
		//TEST GRAFO, DFS Y BFS
		g.insertVert("lima");
		g.insertVert("aqp");
		g.insertVert("cusco");
		g.insertVert("piura");
		g.insertVert("tarap");
		g.insertVert("puno");
		g.insertVert("tacna");
		
		g.insertArista("lima", "aqp", 3,false);
		g.insertArista("cusco", "aqp", 2,false);
		g.insertArista("piura", "lima", 1,false);
		g.insertArista("cusco", "lima", 6,false);
		g.insertArista("piura", "tarap", 10,false);
		g.insertArista("puno", "tacna", 8,false);
		
		System.out.println("Grafo ciudades:\n"+g);
		
		g.DFS("lima");
		System.out.println("\n------------------ IMPRIMIENDO ESTADO DEL GRAFO");
		System.out.println("0 unexp , 1 explored, 2 otro\n"+g);
		System.out.println("------------------ FIN");
		
		g.BFS("lima");
		System.out.println("------------------ IMPRIMIENDO ESTADO DEL GRAFO");
		System.out.println("\n0 unexp , 1 explored, 2 otro\n"+g);
		System.out.println("------------------ FIN");
		
		/*
		g.insertVert("a");
		g.insertVert("b");
		g.insertVert("c");
		g.insertVert("d");
		g.insertVert("e");
		g.insertVert("f");
		g.insertVert("g");
		g.insertVert("h");
		g.insertVert("i");
		g.insertVert("j");
		
		g.insertArista("b", "c",3, true); //1
		g.insertArista("a", "d",7, true); //2
		g.insertArista("c", "g",8, true); //3
		g.insertArista("e", "d",10, true);
		g.insertArista("e", "h",2, true);
		g.insertArista("i", "j",1, true);
		g.insertArista("g", "a",2, true);
		g.insertArista("b", "e",6, true);
		g.insertArista("a", "j",3, true);
		g.insertArista("h", "d",7, true);
		g.insertArista("c", "d",9, true);
		g.insertArista("d", "j",6, true);
		g.insertArista("b", "f",4, true);
		g.insertArista("g", "h",5, true);
		g.insertArista("i", "d",4, true);
		g.insertArista("h", "f",3, true);
		g.insertArista("e", "f",5, true);
		g.insertArista("c", "e",1, true);
		*/
		
		
		//System.out.println("Grafo ciudades:\n"+g);
		
	}
}
