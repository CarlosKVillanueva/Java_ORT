package BilleteraVirtual;

import java.util.ArrayList;

public class Cliente {
    private String dni;
    private int cantCompras;
    private ArrayList<Tarjeta> tarjetas;

    public Cliente(String dni) {
        this.dni = dni;
        this.cantCompras = 0;
        this.tarjetas = new ArrayList<>();
    }

    public boolean mismoCliente(String dni) {
        return this.dni.equals(dni);
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Tarjeta buscarTarjeta(String numeroTarjeta) {
        Tarjeta elementoBuscado = null;
        int i = 0, cantElementos = tarjetas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (tarjetas.get(i).mismoTarjeta(numeroTarjeta)) {
                elementoBuscado = tarjetas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean registrarTarjeta(String numeroTarjeta, NombreTarjeta nombreTarjeta, double saldo) {
        boolean seAgrego = false;
        Tarjeta tarjeta = buscarTarjeta(numeroTarjeta);

        if (tarjeta == null) {
            tarjetas.add(new Tarjeta(numeroTarjeta, nombreTarjeta, saldo));
            seAgrego = true;
        }

        return seAgrego;
    }

    public ArrayList<Tarjeta> controlarSaldo(double monto) {
        ArrayList<Tarjeta> listaTarjetas = new ArrayList<>();

        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta.getSaldo() >= monto) {
                listaTarjetas.add(tarjeta);
            }
        }

        return listaTarjetas;
    }

    public Tarjeta tarjetaConMasSaldo() {
        double masAlta = Double.MIN_VALUE;
        Tarjeta tarjetaMasAlta = null;

        for (Tarjeta tarjeta : tarjetas) {
            if (tarjeta.getSaldo() > masAlta) {
                tarjetaMasAlta = tarjeta;
                masAlta = tarjeta.getSaldo();
            }
        }

        return tarjetaMasAlta;
    }

    @Override
    public String toString() {
        return "Cliente [cantCompras=" + cantCompras + ", dni=" + dni + "]";
    }

    public void sumarCompra() {
        cantCompras++;
    }

    public String getDni() {
        return dni;
    }

    public int getCantCompras() {
        return cantCompras;
    }
}
