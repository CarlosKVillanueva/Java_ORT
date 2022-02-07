package Corredores;

public class Vuelta {
    private double tiempoVuelta;

    /* --------------------- CONSTRUCTOR -------------------- */
    public Vuelta(double tiempoVuelta) {
        this.tiempoVuelta = tiempoVuelta;
    }

    /* ----------------------- GETTERS ---------------------- */

    public double getTiempoVuelta() {
        return tiempoVuelta;
    }
    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Vuelta [tiempoVuelta=" + tiempoVuelta + "]";
    }

}
