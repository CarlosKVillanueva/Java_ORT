package BancOrt;

import java.util.ArrayList;

public class Banco {

    private String nombre;
    ArrayList<Cuenta> cuentas;
    ArrayList<Cajero> cajeros;

    public Banco(String nombre) {
        this.nombre = nombre;
        cuentas = new ArrayList<Cuenta>();
        cajeros = new ArrayList<Cajero>();
    }

    public Cuenta buscarCuenta(String nombre) {
        Cuenta elementoBuscado = null;
        int i = 0, cantElementos = cuentas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (cuentas.get(i).mismoCuenta(nombre)) {
                elementoBuscado = cuentas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public void agregarCuenta(String nroSerie, int saldo) {
        cuentas.add(new Cuenta(nroSerie, saldo));
    }

    @Override
    public String toString() {
        return "Banco [nombre=" + nombre + "]";
    }

}
