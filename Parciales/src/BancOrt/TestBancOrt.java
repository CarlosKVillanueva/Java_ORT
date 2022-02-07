package BancOrt;

import java.util.ArrayList;

public class TestBancOrt {
    public static void main(String[] args) {
        Banco banco = new Banco("BancOrt");

        banco.agregarCuenta("1111", 10000);
        banco.agregarCuenta("2222", 20000);
        banco.agregarCuenta("3333", 30000);

        Cajero cajero = new Cajero("A1B2", banco);

        ArrayList<Billete> billeteCliente = new ArrayList<Billete>();

        for (int i = 0; i < 100; i++) {
            billeteCliente.add(new Billete());
        }
        cajero.obtenerCantidadDeEfectivo();

        cajero.realizarDeposito("1111", billeteCliente);

        cajero.mostrarResultado();

        cajero.obtenerCantidadDeEfectivo();

        cajero.realizarExtraccion("1111", 5000);

        cajero.mostrarResultado();
        // for (Billete billete : billeteCliente) {
        // System.out.println(billete);
        // }
    }
}
