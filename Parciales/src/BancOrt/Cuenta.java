package BancOrt;

import java.util.ArrayList;

public class Cuenta {
    private String nroCuenta;
    private int saldoCuenta;
    private ArrayList<Billete> billetesCuenta;

    public Cuenta(String nroCuenta, int saldo) {
        this.nroCuenta = nroCuenta;
        this.saldoCuenta = recargarCuenta(saldo);

    }

    public String getNroCuenta() {
        return nroCuenta;
    }

    public int getSaldoCuenta() {
        return saldoCuenta;
    }

    private int recargarCuenta(int saldo) {
        billetesCuenta = new ArrayList<>();

        while (saldoCuenta < saldo) {
            Billete billete = new Billete();
            billetesCuenta.add(billete);
            saldoCuenta += billete.getDenominacion();
        }

        return saldoCuenta;
    }

    public boolean mismoCuenta(String nombre) {
        return nroCuenta.equals(nombre);
    }

    public void actualizarSaldo(int acumSaldo) {
        this.saldoCuenta += acumSaldo;
    }

    @Override
    public String toString() {
        return "Cuenta [nroCuenta=" + nroCuenta + ", saldo=" + saldoCuenta + "]";
    }

}
