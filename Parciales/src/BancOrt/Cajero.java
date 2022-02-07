package BancOrt;

import java.util.ArrayList;

public class Cajero {

    private static final int EFECTIVO_INICIAL = 500000;
    private ArrayList<Billete> billetes;
    private ArrayList<Billete> falsos;
    private String nroSerie;
    private Banco banco;
    private int saldoCajero;

    public Cajero(String nroSerie, Banco banco) {
        this.nroSerie = nroSerie;
        this.banco = banco;
        this.saldoCajero = recargarCajero();
    }

    private int recargarCajero() {
        billetes = new ArrayList<>();

        while (saldoCajero < EFECTIVO_INICIAL) {
            Billete billete = new Billete();
            billetes.add(billete);
            saldoCajero += billete.getDenominacion();
        }

        return saldoCajero;
    }

    public int obtenerCantidadDeEfectivo() {
        int acumTotal = 0;

        for (Billete billete : billetes) {
            acumTotal += billete.getDenominacion();
        }
        System.out.println("\n*** Saldo Inicial: $" + acumTotal + " ***");
        return acumTotal;
    }

    public Resultado realizarExtraccion(String nroCuenta, int monto) {
        Resultado resultado;
        Estado estado = Estado.OPERACION_NO_DISPONIBLE;
        Cuenta cuentaBuscada = banco.buscarCuenta(nroCuenta);
        ArrayList<Billete> aEntregar = new ArrayList<>();

        if (cuentaBuscada != null && saldoCajero >= monto) {
            if (cuentaBuscada.getSaldoCuenta() >= monto) {
                estado = Estado.EXTRACCION_REALIZADA;
                aEntregar = retirarBilletes(monto);
            } else {
                estado = Estado.SALDO_INSUFICIENTE;
            }
        }

        resultado = new Resultado(aEntregar, estado);
        resultado.mostrarResultadoExtraccion();
        return resultado;

    }

    private ArrayList<Billete> retirarBilletes(int monto) {
        ArrayList<Billete> retirados = new ArrayList<>();
        int acumRetirar = 0;

        while (acumRetirar < monto) {
            acumRetirar += billetes.get(0).getDenominacion();
            retirados.add(billetes.remove(0));
        }
        this.saldoCajero -= acumRetirar;

        return retirados;
    }

    public Resultado realizarDeposito(String nroCuenta, ArrayList<Billete> billetes) {
        Resultado resultado;
        Estado estado = Estado.DEPOSITO_NO_REALIZADO;
        Cuenta cuentaBuscada = banco.buscarCuenta(nroCuenta);

        if (cuentaBuscada != null) {
            ArrayList<Billete> billetesADepositar = new ArrayList<Billete>();
            billetesADepositar = ingresarBilletes(cuentaBuscada, billetes);
            estado = validarEstado(billetesADepositar.size(), billetes.size());
            billetes.addAll(billetesADepositar);
        }

        resultado = new Resultado(estado, falsos);

        resultado.mostrarResultadoDeposito();
        return resultado;
    }

    private Estado validarEstado(int billetesADepositar, int billetes) {
        Estado estado = Estado.DEPOSITO_NO_REALIZADO;

        if (billetesADepositar > 0) {
            if (billetesADepositar == billetes) {
                estado = Estado.DEPOSITO_REALIZADO;
            } else {
                estado = Estado.DEPOSITO_PARCIAL_REALIZADO;
            }
        }

        return estado;
    }

    private ArrayList<Billete> ingresarBilletes(Cuenta cuentaBuscada, ArrayList<Billete> billetes) {
        int acumSaldo = 0;
        ArrayList<Billete> verdaderos = new ArrayList<>();
        falsos = new ArrayList<>();

        for (Billete billete : billetes) {

            if (validarBillete(billete)) {
                verdaderos.add(billete);
                acumSaldo += billete.getDenominacion();
            } else {
                falsos.add(billete);
            }
        }
        cuentaBuscada.actualizarSaldo(acumSaldo);
        actualizarSaldoCajero(acumSaldo);
        return verdaderos;
    }

    private void actualizarSaldoCajero(int acumSaldo) {
        this.saldoCajero += acumSaldo;
    }

    private boolean validarBillete(Billete billete) {
        return Math.random() < 0.93;
    }

    public void mostrarResultado() {
        System.out.println("\nSaldo Actualizado del cajero : $" + saldoCajero);
    }

    @Override
    public String toString() {
        return "Cajero [banco=" + banco + ", nroSerie=" + nroSerie + ", saldoCajero=" + saldoCajero + "]";
    }

}
