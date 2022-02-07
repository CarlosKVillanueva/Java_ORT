package Garage;

import java.util.ArrayList;

public class Vehiculo {
    private static final int MESES_DEUDA_MAX = 3;
    private static final int MESES_DEUDA = 0;
    private String patente;
    private boolean estacionado;
    private int mesesDeuda;
    private ArrayList<Persona> autorizados;

    /* --------------------- CONSTRUCTOR -------------------- */
    public Vehiculo(String patente, boolean estacionado, int mesesDeuda) {
        this.patente = patente;
        this.estacionado = estacionado;
        this.mesesDeuda = mesesDeuda;
    }

    /* ----------------------- GETTERS ---------------------- */
    public String getPatente() {
        return patente;
    }

    public int getMesesDeuda() {
        return mesesDeuda;
    }

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    private Persona buscarAutorizado(String dni) {
        Persona elementoBuscado = null;
        int i = 0, cantElementos = autorizados.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (autorizados.get(i).mismaPersona(dni)) {
                elementoBuscado = autorizados.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean mismoVehiculo(String patente) {
        return this.patente.equals(patente);
    }

    public boolean estaEstacionado() {
        return estacionado;
    }

    public boolean tieneDeudaMax() {
        return this.mesesDeuda > MESES_DEUDA_MAX;
    }

    public void estacionar() {
        this.estacionado = true;
    }

    public void retirar() {
        this.estacionado = false;
    }

    public boolean estaAtutorizada(String dni) {
        return buscarAutorizado(dni) != null;
    }

    public boolean tieneDeuda() {
        return mesesDeuda > MESES_DEUDA;
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Vehiculo [estacionado=" + estacionado + ", patente=" + patente + "]";
    }

}
