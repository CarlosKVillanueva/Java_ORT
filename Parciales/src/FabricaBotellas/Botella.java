package FabricaBotellas;

public class Botella {
    private static int idActual = 0;
    private int id;
    private double altura;
    private Calidad calidad;

    public Botella(int id, double altura, Calidad calidad) {
        this.id = id;
        this.altura = altura;
        this.calidad = calidad;
    }

    public static int generarID() {
        return idActual++;
    }

    public boolean correcta() {
        return this.calidad == Calidad.CORRECTA;
    }

    @Override
    public String toString() {
        return "Botella [ID: " + id + "| Altura: " + altura + "| Calidad: " + calidad + " ]";
    }

}
