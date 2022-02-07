package ShowTime;

public class Espectador {
    private String nombre;
    private String apellido;
    private String dni;
    private double valorEntrada;

    public Espectador(String nombre, String apellido, String dni, double valorEntrada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.valorEntrada = valorEntrada;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public boolean mismoEspectador(String dni) {
        return this.dni.equals(dni);
    }

    @Override
    public String toString() {
        return "Espectador [apellido=" + apellido + ", dni=" + dni + ", nombre=" + nombre + ", valor=" + valorEntrada
                + "]";
    }

}
