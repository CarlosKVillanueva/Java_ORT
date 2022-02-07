package Zapatos;

public class MAIN {

	public static void main(String[] args) {
		Sitio zapateria = new Sitio("LAZAPA");
		
		zapateria.agregarProductoint(1, 300, "Deportivo",Categoria.DEPORTIVO);
		zapateria.agregarProductoint(1, 300, "Deportivo",Categoria.DEPORTIVO);
		zapateria.agregarProductoint(2, 230, "Zapato   ",Categoria.ZAPATO);
		zapateria.agregarProductoint(3, 984, "Zapato   ",Categoria.ZAPATO);
		zapateria.agregarProductoint(4, 486, "Zapato   ",Categoria.ZAPATO);
		zapateria.agregarProductoint(5, 123, "Deportivo",Categoria.DEPORTIVO);
		zapateria.agregarProductoint(6, 785, "Ojota    ",Categoria.OJOTA);
		zapateria.agregarProductoint(7, 985, "Zapatilla",Categoria.ZAPATILLA);
		zapateria.agregarProductoint(8, 147, "Ojota    ",Categoria.OJOTA);
		zapateria.agregarProductoint(9, 889, "Zapatilla",Categoria.ZAPATILLA);
		zapateria.agregarProductoint(0, 123, "Deportivo",Categoria.DEPORTIVO);
		
		zapateria.listarProductos(null);
		zapateria.listarProductos(Categoria.DEPORTIVO);

		
		System.out.println("\nEl precio promedio de todos los productos es: $" + zapateria.precioPromedio());
		System.out.println("\nEl precio promedio de la categoria es de: $" + zapateria.precioPromedioPorCat(Categoria.DEPORTIVO));
	}

}
