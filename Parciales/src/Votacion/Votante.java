/**
 * 
 */
package Votacion;

/**
 * @author Carlos K. Villanueva
 *
 * 7 nov 2021
 */
public class Votante {

	private int dni;
	private String nombre;
	private ValorVoto voto;
	
	
	public Votante(int dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.voto = null;
		
	}

	public ValorVoto getVoto() {
		return voto;
	}
	
	public void votar(ValorVoto voto) {
		this.voto = voto;
	}

	public boolean mismoDni(int dni) {
		return this.dni == dni;
	}
	
	
	
	@Override
	public String toString() {
		return "Votante dni: " + dni + " | nombre: " + nombre + " | voto: " + voto;
	}

	


	
	
	
	
	
	
}
