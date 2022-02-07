package ShowTime;

public class Hora {
    private int hora;
    private int min;

    public Hora(int hora, int min) {
        this.hora = hora;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Hora: " + hora + ":" + min;
    }

}
