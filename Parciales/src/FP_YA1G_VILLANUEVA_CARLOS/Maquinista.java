package FP_YA1G_VILLANUEVA_CARLOS;

public class Maquinista {
    private String nombre;
    private String dni;
    Tren tren = null;

    public Maquinista(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        setTren(tren);
    }

    public Tren getTren() {
        return tren;
    }

    public void setTren(Tren tren) {
        this.tren = tren;
    }

    public boolean mismoDni(String dni) {
        return this.dni.equals(dni);
    }

    @Override
    public String toString() {
        return "Maquinista [dni=" + dni + ", nombre=" + nombre + "]";
    }

}
