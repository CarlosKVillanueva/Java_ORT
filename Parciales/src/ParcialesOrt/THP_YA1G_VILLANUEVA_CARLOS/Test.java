package THP_YA1G_VILLANUEVA_CARLOS;

/**
 * @author Carlos K. Villanueva
 *
 */
public class Test {

	public static void main(String[] args) {

		Empresa empresa = new Empresa("Trenes");
		System.out.println("Formaciones");
		System.out.println(empresa.crearFormacion());
		System.out.println(empresa.crearFormacion());
		System.out.println("Agregar Vagones");
		System.out.println(empresa.agregarVagones(1, 15, TipoVagon.MEDIUM));
		System.out.println(empresa.agregarVagones(1, 15, TipoVagon.LARGE));
		System.out.println(empresa.agregarVagones(2, 20, TipoVagon.MEDIUM));
		System.out.println(empresa.agregarVagones(2, 20, TipoVagon.LARGE));
		System.out.println(empresa.agregarVagones(999, 20, TipoVagon.LARGE));

		System.out.println("Cargar");

		// System.out.println(empresa.cargarTren(1, 151));
	}

}
