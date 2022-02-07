package Corredores;

import java.util.ArrayList;

public class Piloto {
    private String dni;
    private String nombre;
    private ArrayList<Vuelta> vueltas;

    public Piloto(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        vueltas = new ArrayList<>();
    }
    /* --------------------- CONSTRUCTOR -------------------- */

    /* ----------------------- GETTERS ---------------------- */

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    public void agregarVueltasPiloto(int cantVueltas) {
        int min = 0, max = 40;
        int randVueltas = (int) Math.random() * (15 - 8 + 1) + 8;

        for (int i = 0; i < randVueltas; i++) {
            vueltas.add(new Vuelta(Math.random() * (max - min + 1) + min));
        }
    }

    public boolean mismoPiloto(String dni) {
        return this.dni.equals(dni);
    }

    public double calcularPromedioVuelta() {
        double promedio = 0;
        int cantVueltas = 0;
        for (Vuelta vuelta : vueltas) {
            promedio += vuelta.getTiempoVuelta();
            cantVueltas++;
        }

        return promedio / cantVueltas;
    }

    public boolean tieneVueltasMinimas() {
        return this.vueltas.size() <= 10;
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Piloto [dni=" + dni + ", nombre=" + nombre + "]";
    }

}
