package Zapatos;

import java.util.ArrayList;

public class Sitio {
	private String nombre;
	private ArrayList<Producto> productos;

	public Sitio(String nombre) {
		this.nombre = nombre;
		productos = new ArrayList<>();
	}

	private Producto buscarProducto(int id) {
		Producto productoBuscado = null;
		int i = 0, cantElementos = productos.size();

		while (i < cantElementos && productoBuscado == null) {
			if (productos.get(i).mismoID(id)) {
				productoBuscado = productos.get(i);
			} else {
				i++;
			}
		}
		return productoBuscado;
	}

	public boolean agregarProductoint(int id, double precio, String descripcion, Categoria tipo) {
		boolean pudeAgregar = true;

		if (buscarProducto(id) == null) {
			productos.add(new Producto(id, precio, descripcion, tipo));
			pudeAgregar = true;
		}

		return pudeAgregar;
	}

	private void cabecera() {

		System.out.println("LISTADO DE TODOS LOS PRODUCTOS");
		System.out.println("DESCRIPCION \t\tPRECIO \t\tCATEGORIA");
		System.out.println("----------- \t\t------ \t\t---------");
	}

	public void listarProductos(Categoria tipo) {
		this.cabecera();
		for (Producto producto : productos) {
			if (tipo == null) {
				System.out.println(producto);
			} else if (tipo == producto.getTipo()) {
				System.out.println(producto);
			}
		}
	}

	public double precioPromedio() {
		double total = 0;
		for (Producto producto : productos) {
			total += producto.getPrecio();
		}
		return retornaPromedio(total, productos.size());
	}

	public double precioPromedioPorCat(Categoria tipo) {
		double total = 0;
		int cont = 0;

		for (Producto producto : productos) {
			if (tipo == producto.getTipo()) {
				total += producto.getPrecio();
				cont++;
			}
		}
		return retornaPromedio(total, cont);
	}

	private double retornaPromedio(double total, int cantidad) {
		return cantidad > 0 ? total / cantidad : 0;
	}

	@Override
	public String toString() {
		return "Sitio nombre: " + nombre + " | productos: " + productos;
	}

}
