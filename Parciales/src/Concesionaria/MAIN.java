package Concesionaria;

public class MAIN {

	public static void main(String[] args) {
		Concesionaria concesionaria = new Concesionaria("KaioCars");
		
		
		concesionaria.agregarVehiculo(Marca.CHEVROLET, 123, 80000, Categoria.CAMIONETA);
		concesionaria.agregarVehiculo(Marca.CHEVROLET, 123, 80000, Categoria.CAMIONETA);
		concesionaria.agregarVehiculo(Marca.CHEVROLET, 456, 90000, Categoria.CAMIONETA);
		concesionaria.agregarVehiculo(Marca.FIAT, 789, 90000, Categoria.AUTO);
		concesionaria.agregarVehiculo(Marca.FIAT, 654, 90000, Categoria.CAMIONETA);
		concesionaria.agregarVehiculo(Marca.FIAT, 321, 90000, Categoria.UTITLITARIO);
		concesionaria.agregarVehiculo(Marca.FIAT, 741, 10000, Categoria.UTITLITARIO);
		concesionaria.agregarVehiculo(Marca.FIAT, 852, 10000, Categoria.UTITLITARIO);
		concesionaria.agregarVehiculo(Marca.PEUGEOT, 147, 90000, Categoria.CAMIONETA);
		concesionaria.agregarVehiculo(Marca.PEUGEOT, 258, 90000, Categoria.UTITLITARIO);
		concesionaria.agregarVehiculo(Marca.PEUGEOT, 369, 10000, Categoria.AUTO);
		
		
		concesionaria.vehiculosMasEconomicos();
		concesionaria.listarEconomicos();
		
		
		System.out.println(concesionaria.cantidadDeVehiculosSegunMarca(Marca.CHEVROLET));
		
	}

}
