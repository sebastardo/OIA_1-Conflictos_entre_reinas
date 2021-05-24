
public class App {

	public static void main(String[] args) {
		
		Tablero tablero = new Tablero("reinas.in");
		tablero.chequearConflictos();
		tablero.grabarReinas("reinas.out");
		
	}

}
