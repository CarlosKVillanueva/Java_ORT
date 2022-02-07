package EquipoFutbol;

public class Jugador {
    private int numero;
    private String apellido;
    private int goles;

    public Jugador(int numero, String apellido, int goles) {
        this.numero = numero;
        this.apellido = apellido;
        this.goles = goles;
    }

    public boolean mismoJugador(int numero) {
        return this.numero == numero;
    }

    public int getGoles() {
        return this.goles;
    }

    @Override
    public String toString() {
        return "Apellido: " + apellido + " | Goles: " + goles;
    }
}
