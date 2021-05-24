import java.util.LinkedList;
import java.util.List;

public class Reina {
	
	private int numero;
	private int fila;
	private int columna;
	private List<Integer> conflictos;
	
	public Reina(int numero, int fila, int columna) {
		this.numero = numero;
		this.fila = fila;
		this.columna = columna;
		this.conflictos = new LinkedList<>();
	}
	
	public void buscarConflictos(List<Reina> reinas, int tamanioTablero) {
		
		// Fila
		buscarFilaArriba(reinas);
		buscarFilaAbajo(reinas, tamanioTablero);
		
		
		// Columna
		buscarColumnaIzq(reinas);
		buscarColumnaDer(reinas, tamanioTablero);

		
		// Diagonal principal
		buscarDiagIzqArriba(reinas);
		buscarDiagDerAbajo(reinas, tamanioTablero);
		
		
		// Diagonal secundaria
		buscarDiagDerArriba(reinas, tamanioTablero);
		buscarDiagIzqAbajo(reinas, tamanioTablero);

		
	}
	
	// Fila
	
	private boolean buscarFilaArriba(List<Reina> reinas) {
		int posicion = this.fila - 1;
		while(posicion > 0) {
			for(Reina r : reinas) {
				if(r.fila == posicion && r.columna == this.columna) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicion--;
		}
		return false;
	}
	
	
	private boolean buscarFilaAbajo(List<Reina> reinas, int tamanioTablero) {  // filas
		int posicion = this.fila + 1;
		while(posicion <= tamanioTablero) {
			for(Reina r : reinas) {
				if(r.fila == posicion && r.columna == this.columna) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicion++;
		}
		return false;
	}
	////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	// Columna
	
	private boolean buscarColumnaIzq(List<Reina> reinas) {
		int posicion = this.columna - 1;
		while(posicion > 0) {
			for(Reina r : reinas) {
				if(r.columna == posicion && r.fila == this.fila) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicion--;
		}
		return false;
	}
	
	private boolean buscarColumnaDer(List<Reina> reinas, int tamanioTablero) {
		int posicion = this.columna + 1;
		while(posicion <= tamanioTablero) {
			for(Reina r : reinas) {
				if(r.columna == posicion && r.fila == this.fila) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicion++;
		}
		return false;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	// Diagonal principal

	private boolean buscarDiagIzqArriba(List<Reina> reinas) {
		int posicionF = this.fila - 1;
		int posicionC = this.columna - 1;
		
		
		while(posicionF > 0 && posicionC > 0) {
			for(Reina r : reinas) {
				if(r.columna == posicionC && r.fila == posicionF) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicionF--;
			posicionC--;
		}
		
		return false;
	}
	
	
	
	private boolean buscarDiagDerAbajo(List<Reina> reinas, int tamanioTablero) { 
		int posicionF = this.fila + 1;
		int posicionC = this.columna + 1;
		
		
		while(posicionF <= tamanioTablero && posicionC <= tamanioTablero) {
			for(Reina r : reinas) {
				if(r.columna == posicionC && r.fila == posicionF) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicionF++;
			posicionC++;
		}
		
		return false;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	// Diagonal secundaria
	private boolean buscarDiagDerArriba(List<Reina> reinas, int tamanioTablero) { 
		
		int posicionF = this.fila - 1;
		int posicionC = this.columna + 1;
		
		while(posicionF > 0 && posicionC <= tamanioTablero) {
			for(Reina r : reinas) {
				if(r.fila == posicionF && r.columna == posicionC) {
					this.conflictos.add(r.numero);
					return true;
				}
			}
			posicionF--;
			posicionC++;
		}
		return false;
	}
	
	
	
	private boolean buscarDiagIzqAbajo(List<Reina> reinas, int tamanioTablero) {
		
		int posicionF = this.fila + 1;
		int posicionC = this.columna - 1;
		
		while(posicionF <= tamanioTablero && posicionC > 0) {
			
			for(Reina r : reinas) {
				if(r.fila == posicionF && r.columna == posicionC) {
					this.conflictos.add(r.numero);
					return true;
				}
				
				
			}
			posicionF++;
			posicionC--;
		}
		return false;
	}
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	
	
	public int cantidadConflictos() {
		return this.conflictos.size();
	}

	
	public List<Integer> getConflictos() {
		return conflictos;
	}

	
	@Override
	public String toString() {
		String aux = "" + this.conflictos.size();
		
		this.conflictos.sort(null);
		
		for(int n:this.conflictos)
			aux += " " + n;
		
		return aux;
	}
	
	
	
}

