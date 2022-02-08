package THP_YA1G_VILLANUEVA_CARLOS;

public class Vagon {
    private static final double CARGA_SMALL = 30;
    private static final double CARGA_MEDIUM = 40;
    private static final double CARGA_LARGE = 50;
    private int numeroVagon;
    private TipoVagon tipoVagon;
    private double carga;

    public Vagon(int numeroVagon, TipoVagon tipoVagon) {
        this.numeroVagon = numeroVagon;
        this.tipoVagon = tipoVagon;

    }

    public double cargaPorTipo() {

        if (tipoVagon == TipoVagon.SMALL) {
            this.carga = CARGA_SMALL;
        } else if (tipoVagon == TipoVagon.MEDIUM) {
            this.carga = CARGA_MEDIUM;
        } else {
            this.carga = CARGA_LARGE;
        }
        return carga;
    }

    @Override
    public String toString() {
        return "Vagon [carga=" + carga + ", numeroVagon=" + numeroVagon + "]";
    }

}
