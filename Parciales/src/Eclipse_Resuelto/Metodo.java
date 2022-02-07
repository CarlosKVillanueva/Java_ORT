package Eclipse_Resuelto;

public class Metodo {

	private String nombre;
	private int cantidadInstrucciones;
	private static int BYTES_POR_INSTRUCCION = 4;
	
	public Metodo(String nombre, int cantidadInstrucciones){
		setNombre(nombre);
		setCantidadInstrucciones(cantidadInstrucciones);
	}
	
	private void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	private void setCantidadInstrucciones(int cantidadInstrucciones){
		this.cantidadInstrucciones = cantidadInstrucciones;
	}
	
	public boolean mismoMetodo(String nombre){
		return this.nombre.equals(nombre);
	}
	
	public int getCantidadBytes(){
		return cantidadInstrucciones * BYTES_POR_INSTRUCCION;
	}
	
}
