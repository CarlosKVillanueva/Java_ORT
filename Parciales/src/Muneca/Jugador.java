package Muneca;

public class Jugador {
    private final int MAX_METROS = 22;
    private final int MIN_METROS = 15;
    private int id;
    private double mtsRecorridos;

    private boolean vivo;
    @SuppressWarnings("unused")
	private boolean mueve = false;
    private int ronda;

    public Jugador(int id) {
        this.id = id;
        this.mtsRecorridos = 0;
        this.vivo = true;
        this.ronda = 0;
    }

    public double getmtsRecorridos() {
        return mtsRecorridos;
    }

    public void avanzar() {
        this.mtsRecorridos += obtenerAvance();

    }

    private double obtenerAvance() {
        return Math.floor(Math.random() * (MAX_METROS - MIN_METROS) + MIN_METROS);
    }

    public boolean estaQuieto() {
        return this.mueve = Math.random() > 0.7 ? true : false;
    }

    public void setVivo(boolean b) {
        this.vivo = b;
    }

    public boolean isVivo() {
        return vivo;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return "Jugador [Mts. Recorridos: " + mtsRecorridos + "\t ID: " + id + "\t Ronda: " + ronda + "\t Estado: "
                + (vivo ? "Vivo" : "Muerto") + "]";
    }
}
