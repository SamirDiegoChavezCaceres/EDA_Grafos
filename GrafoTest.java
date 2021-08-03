
public class GrafoTest {
	public static void main(String[] args) {
		GrafoLink<String> g = new GrafoLink<String>();
		
		g.insertVert("lima");
		g.insertVert("aqp");
		g.insertVert("cusco");
		g.insertVert("piura");
		g.insertVert("tarapoto");
		
		g.insertArista("lima", "aqp", true);
		g.insertArista("cusco", "aqp", false);
		g.insertArista("piura", "lima", true);
		g.insertArista("cusco", "lima", false);
		g.insertArista("piura", "tarapoto", false);
		
		System.out.println("Grafo ciudades:\n"+g);
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
		g.insertArista("c", "e",1, true);*/
		
		
		System.out.println("Grafo ciudades:\n"+g);
		
	}
}
