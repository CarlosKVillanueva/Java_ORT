package BancOrt;

public class Billete {
    private String nroSerie;
    private int denominacion;

    public Billete() {
        this.nroSerie = generarNroSerie();
        this.denominacion = generarDenominacion();
    }

    private String generarNroSerie() {
        String nroAleatorio = "A";

        for (int i = 0; i < 10; i++) {
            nroAleatorio += (int) (Math.random() * 10);
        }

        return nroAleatorio;
    }

    public int generarDenominacion() {
        double random = Math.random();

        if (random >= 0.66) {
            this.denominacion = 500;
        } else if (random >= 0.33 && random <= 0.66) {
            this.denominacion = 200;
        } else {
            this.denominacion = 100;
        }

        return this.denominacion;
    }

    public int getDenominacion() {
        return denominacion;
    }

    @Override
    public String toString() {
        return "Billete => Denominacion: $" + denominacion + " | Nro. Serie: " + nroSerie + "]";
    }

}
