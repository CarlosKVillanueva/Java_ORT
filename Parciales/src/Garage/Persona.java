package Garage;

public class Persona {
    private String dni;
    private String nombreCompleto;

    /* --------------------- CONSTRUCTOR -------------------- */

    public Persona(String dni, String nombreCompleto) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
    }

    /* ----------------------- GETTERS ---------------------- */

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    public boolean mismaPersona(String dni) {
        return this.dni.equals(dni);
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Persona [dni=" + dni + ", nombreCompleto=" + nombreCompleto + "]";
    }

}
