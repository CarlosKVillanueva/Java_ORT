package FabricaGalletitas;

public class Galletita {
    private final double GRAMOS_DESEADOS = 10;
    private final double GRAMOS_ACEPTABLES = (GRAMOS_DESEADOS / 2);
    private final double PORC_COBER_VALIDO = 98;
    private final double PORCENTAJE_VALIDO = 0.8;

    private double gramos;
    private boolean entera;
    private double porcCobertura;
    private Calidad calidad;

    public Galletita() {
        obtenerEntereza();
        calcCobertura();
        evaluarCalidad();
    }

    public double getGramos() {
        return this.gramos;
    }

    private void calcCobertura() {
        porcCobertura = Math.min(100, 60 + Math.random() * 50);
    }

    public Calidad getCalidad() {
        return calidad;
    }

    private void obtenerEntereza() {
        entera = Math.random() < PORCENTAJE_VALIDO;
        if (entera) {
            gramos = GRAMOS_DESEADOS;
        } else {
            gramos = Math.random() * GRAMOS_DESEADOS;
        }
    }

    private void evaluarCalidad() {
        calidad = Calidad.DESEADA;

        if (!entera || this.porcCobertura < PORC_COBER_VALIDO) {
            if (this.gramos >= GRAMOS_ACEPTABLES) {
                calidad = Calidad.ACEPTABLE;
            } else {
                calidad = Calidad.DESCARTE;
            }
        }

    }

    @Override
    public String toString() {
        return "Galletita [calidad=" + calidad + ", entera=" + entera + ", gramos=" + gramos + ", porcCobertura="
                + porcCobertura + "]";
    }

}
