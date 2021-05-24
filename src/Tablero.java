import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Tablero {
	
	private int tamanio;
	private int cantidadReinas;
	private LinkedList<Reina> reinas;

	public Tablero(String archivo) {
		
		reinas = new LinkedList<Reina>();
		
		try{
			cargarReinas(archivo);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	
	
	private void cargarReinas(String archivo) throws FileNotFoundException {

		Scanner entrada = new Scanner(new File(archivo));

		if (entrada.hasNext()) 
			this.tamanio = entrada.nextInt();
		
		if (entrada.hasNext())
			this.cantidadReinas = entrada.nextInt();
		
		int numeroReina = 1;

		while (numeroReina <= this.cantidadReinas) {
			
			reinas.add(new Reina(numeroReina, entrada.nextInt(), entrada.nextInt()));
			
			numeroReina++;
		}
		
		entrada.close();
	}
	

	
	public void chequearConflictos() {
		for(Reina r: reinas) {
			r.buscarConflictos(reinas, tamanio);
		}
	}
	
	
	public void grabarReinas(String archivo){
			
			FileWriter fichero = null;
			PrintWriter pw = null;

			try {
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);
	            
				
	            for(int i=0;i<reinas.size();i++) {
	            	pw.print(reinas.get(i));
	            	if(i<reinas.size()-1)
	            		pw.println();
	            }
	            
	            
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if (fichero != null)
						fichero.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}
}
