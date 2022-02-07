package Concesionaria;

import java.util.ArrayList;

/*
 * 	Una concesionaria exclusiva de las marcas Qeugeot, Giat y Debrolet, tiene a la venta vehículos, de los cuales se conoce su marca, precio y tipo (auto, camioneta o utilitario).
	Basado en el enunciado descripto, realizá:
	A) El diagrama de clases que lo modelice, con sus relaciones, atributos y métodos.
	B) La explotación del método vehiculosMasEconomicos de la clase Concesionaria, el cual debe devolver una lista de vehículos cuyo precio esté por debajo del promedio general.
	C) La explotación del método cantidadDeVehiculosSegunMarca de la clase Concesionaria, que recibe como parámetro una marca y debe devolver la cantidad de vehículos de tal marca.
 * 
 */

public class Concesionaria {
	private String nombre;
	private ArrayList<Vehiculo> vehiculos;

	public Concesionaria(String nombre) {
		this.nombre = nombre;
		vehiculos = new ArrayList<Vehiculo>();
	}
	 
	/*--------------- BUSQUEDA ---------------*/
	
	private Vehiculo buscarVehiculo(int id) {
		Vehiculo vehiculoABuscar = null;
		int i = 0, cantidadElem = vehiculos.size();
		
		while (i< cantidadElem && vehiculoABuscar ==null) {
			if (vehiculos.get(i).mismoID(id)) {
				vehiculoABuscar = vehiculos.get(i);
			}else {
				i++;
			}
		}
		return vehiculoABuscar;
	}
	
	public boolean agregarVehiculo(Marca marca,int id, double precio, Categoria categoria) {
		boolean pudeAgregar = false;
		
		if (buscarVehiculo(id) == null) {
			vehiculos.add(new Vehiculo(marca, id, precio, categoria));
			pudeAgregar = true;
		}
		return pudeAgregar;
	}
	
	
	/*--------------- METODOS ---------------*/
	
	public ArrayList<Vehiculo> vehiculosMasEconomicos(){
		ArrayList<Vehiculo> listaEconomicos = new ArrayList<>();
		double monto = 0;
		int cantidad = vehiculos.size();
		for (Vehiculo vehiculo : vehiculos) {
			monto += vehiculo.getPrecio();
			
		}
		if(cantidad > 0) {
			double promedio = monto / cantidad;
			for (Vehiculo vehiculo : vehiculos) {
				if (vehiculo.getPrecio() < promedio) {
					listaEconomicos.add(vehiculo);
				}
			}
		}
		return listaEconomicos; 
	}
	
	public void listarEconomicos() {
			System.out.println("MARCA\t\tPRECIO");
			System.out.println("-----\t\t------");
			for (Vehiculo vehiculo : vehiculosMasEconomicos()) {
				System.out.println(vehiculo.mostrarDatos());
			}
	}
	
	
	public int cantidadDeVehiculosSegunMarca(Marca marca) {
		int resultado = 0;
		
		for (Vehiculo vehiculo : vehiculos) {
			if(vehiculo.getMarca() == marca) {
				resultado++;
			}
		}
		
		return resultado;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "Concesionaria nombre: " + nombre + " | vehiculos: " + vehiculos;
	}

}
