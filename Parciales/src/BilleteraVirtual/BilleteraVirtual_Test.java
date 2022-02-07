package BilleteraVirtual;

public class BilleteraVirtual_Test {
    public static void main(String[] args) {
        BilleteraVirtual uala = new BilleteraVirtual("UALORT");

        System.out.println("Agregar CLiente");
        System.out.println(uala.agregarCliente("12456789"));
        System.out.println(uala.agregarCliente("987654321"));
        System.out.println(uala.agregarCliente("147258369"));
        System.out.println(uala.agregarCliente("147258369"));

        System.out.println("Agregar Tarjetas");
        System.out.println(uala.registrarTarjeta("12456789", "1111 2222 3333 4444", NombreTarjeta.INSTICARD, 50000));
        System.out.println(uala.registrarTarjeta("12456789", "9999 8888 7777 6666", NombreTarjeta.YATAYPLUS, 15000));

        System.out.println(uala.registrarTarjeta("987654321", "4444 3333 2222 1111", NombreTarjeta.MONTACARD, 1500000));
        System.out
                .println(uala.registrarTarjeta("987654321", "5555 4444 9999 7777", NombreTarjeta.YATAYPLUS, -1500000));

        System.out.println(uala.registrarTarjeta("147258369", "7777 4444 1111 2222", NombreTarjeta.MONTACARD, 1500000));

        System.out.println(uala.registrarTarjeta("147258369", "7777 4444 1111 2222", NombreTarjeta.YATAYPLUS, 1500000));

        System.out.println("Compra 1 Tarjeta");

        uala.mostrarTarjetasPuedenComprar("12456789", 20000);
        System.out.println("Compra 2 Trajetas");
        uala.mostrarTarjetasPuedenComprar("12456789", 10000);
        System.out.println("Compras");
        System.out.println(uala.realizarCompra("12456789", -1, 3));
        System.out.println(uala.realizarCompra("12456789", 1, -1));
        System.out.println(uala.realizarCompra("1", 158512545, 3));
        System.out.println(uala.realizarCompra("12456789", 158512545, 3));
        System.out.println(uala.realizarCompra("12456789", 15, 3));
        System.out.println(uala.realizarCompra("987654321", 15, 3));
        System.out.println(uala.realizarCompra("987654321", 30, 2));
        System.out.println(uala.realizarCompra("12456789", 1158, 2));

        System.out.println("Obtener");
        System.out.println(uala.obtenerCompras());
    }
}
