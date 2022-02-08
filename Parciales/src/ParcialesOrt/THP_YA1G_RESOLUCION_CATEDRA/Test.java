package THP_YA1G_RESOLUCION_CATEDRA;

public class Test {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("123");

        System.out.println(empresa.crearFormacion());
        System.out.println(empresa.crearFormacion());

        System.out.println(empresa.agregarVagones(1, 15, TipoVagon.MEDIUM));

        System.out.println(empresa.agregarVagones(1, 15, TipoVagon.LARGE));

        System.out.println(empresa.agregarVagones(2, 20, TipoVagon.SMALL));

        System.out.println(empresa.agregarVagones(2, 20, TipoVagon.MEDIUM));

        System.out.println(empresa.agregarVagones(999, 2, TipoVagon.LARGE));

        System.out.println(empresa.cargarTren(1, 151.0));

        System.out.println(empresa.cargarTren(1, 252.0));

        System.out.println(empresa.cargarTren(2, 353.0));

        System.out.println(empresa.cargarTren(2, 4567.0));

        System.out.println(empresa.cargarTren(999, 1.0));

        empresa.listarCapacidadTrenes();

        System.out.println(empresa.sacarVagonesVacios(1));
        System.out.println(empresa.sacarVagonesVacios(1));
        System.out.println(empresa.sacarVagonesVacios(2));
        System.out.println(empresa.sacarVagonesVacios(999));
    }
}
