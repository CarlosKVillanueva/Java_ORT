package FP_YA1G_VILLANUEVA_CARLOS;

public class Vagon {
    private static int NUMERACION_VAGON = 0;
    private String numeroSerie;
    private TipoVagon tipo;
    private boolean repacion;

    public Vagon(String numeroSerie, TipoVagon tipo, boolean repacion) {
        this.numeroSerie = numeroSerie;
        this.tipo = tipo;
        this.repacion = repacion;
    }

    public static String numeroVagon() {
        NUMERACION_VAGON++;
        return String.valueOf(NUMERACION_VAGON);
    }

    public boolean enRepacion() {
        return repacion;
    }

    public boolean controlarTipo(TipoVagon tipo) {
        return this.tipo.equals(tipo);
    }

    @Override
    public String toString() {
        return "Vagon Nº: " + numeroSerie + " , " + tipo;
    }

    public boolean mismoVagon(String numeroSerie) {
        return this.numeroSerie == numeroSerie;
    }

}
