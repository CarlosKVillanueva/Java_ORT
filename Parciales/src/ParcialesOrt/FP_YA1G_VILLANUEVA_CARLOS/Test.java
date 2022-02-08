package FP_YA1G_VILLANUEVA_CARLOS;

public class Test {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("LA LOCOMOTORA DEL OESTE");

        empresa.agregarMaquinista("Kaio", "123456");

        empresa.agregarVagones(10, TipoVagon.PASAJEROS);
        empresa.agregarVagones(10, TipoVagon.CARGA);
        empresa.agregarVagones(2, TipoVagon.LOCOMOTARA);

        System.out.println("");
        empresa.armarTren(8, 8, "Avellaneda", "123456");

        empresa.mostrarTrenes();

    }
}
