package Concesionaria;

public class Vehiculo {
	private Marca marca;
	private int id;
	private double precio;
	private Categoria categoria;

	public Vehiculo(Marca marca, int id, double precio, Categoria categoria) {
		this.marca = marca;
		this.id = id;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public double getPrecio() {
		return precio;
	}

	public String mostrarDatos() {
		return marca + "\t\t$" + precio ;
	}
	@Override
	public String toString() {
		return "Vehiculo marca: " + marca + " | id: " + id + " | precio: " + precio + " | categoria: " + categoria
				+ "\n";
	}

	public boolean mismoID(int id) {
		return this.id == id;
	}

}
