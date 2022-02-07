package Zapatos;

public class Producto {
	private int id;
	private double precio;
	private String descripcion;
	private Categoria tipo;

	public Producto(int id, double precio, String descripcion, Categoria tipo) {
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.tipo = tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public Categoria getTipo() {
		return tipo;
	}

	public boolean mismoID(int id) {
		return this.id == id;
	}

	@Override
	public String toString() {
		return descripcion + "\t\t" +"$"+ precio + "\t\t" + tipo ;
	}
	
	
	
	

}
