package Garage;

public class Deuda {
    private String patente;
    private int mesesDeuda;

    /* --------------------- CONSTRUCTOR -------------------- */

    public Deuda(String patente, int mesesDeuda) {
        this.patente = patente;
        this.mesesDeuda = mesesDeuda;
    }

    /* ----------------------- GETTERS ---------------------- */

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    /* ---------------------- TO STRING --------------------- */

    @Override
    public String toString() {
        return "Deuda [mesesDeuda=" + mesesDeuda + ", patente=" + patente + "]";
    }

}
