package THP_YA1G_RESOLUCION_CATEDRA;

public class Vagon {
    private static final double CAPACIDAD_SMALL = 30;
    private static final double CAPACIDAD_MEDIUM = 40;
    private static final double CAPACIDAD_LARGE = 50;
    private TipoVagon tipo;
    private double carga;

    public Vagon(TipoVagon tipo) {
        this.tipo = tipo;
        this.carga = 0;
    }

    public double capacidadVagon() {
        double capacidad = 0;

        switch (tipo) {

        case SMALL:
            capacidad = CAPACIDAD_SMALL;
            break;
        case MEDIUM:
            capacidad = CAPACIDAD_MEDIUM;
            break;
        case LARGE:
            capacidad = CAPACIDAD_LARGE;
            break;
        }
        return capacidad;
    }

    public double capacidadLibre() {
        return capacidadVagon() - carga;
    }

    public boolean estaVacio() {
        return carga == 0;
    }

    public boolean estaLleno() {
        return carga == capacidadVagon();
    }

    public void cargarVagon(double cantidadTrigo) {
        carga += cantidadTrigo;
    }
}
