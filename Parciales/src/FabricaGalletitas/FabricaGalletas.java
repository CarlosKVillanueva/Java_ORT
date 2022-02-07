package FabricaGalletitas;

import java.util.ArrayList;

public class FabricaGalletas {
    private final int TANDA = 10000;
    private final int GRAMOS_TOTALES = 500;
    private ArrayList<Galletita> galletitasFabricadas;
    private ArrayList<Bolsa> bolsas;

    public FabricaGalletas() {
        this.galletitasFabricadas = new ArrayList<>();
        this.bolsas = new ArrayList<>();
        fabricarGalletitas();
    }

    private void fabricarGalletitas() {
        for (int i = 0; i < TANDA; i++) {
            galletitasFabricadas.add(new Galletita());
        }
    }

    public void envasar() {

        double grDescartados = 0;
        Galletita galletitaActual;
        Bolsa bolsa = new Bolsa(GRAMOS_TOTALES);

        while (galletitasFabricadas.size() > 0) {

            galletitaActual = galletitasFabricadas.remove(0);

            if (galletitaActual.getCalidad() != Calidad.DESCARTE) {
                embolsar(bolsa, galletitaActual);

                if (bolsa.estaLlena()) {
                    estivar(bolsa);
                    bolsa = new Bolsa(GRAMOS_TOTALES);
                }

            } else {
                grDescartados += galletitaActual.getGramos();
            }

        }
        while (!bolsa.estaVacia()) {
            grDescartados += bolsa.extraer().getGramos();
        }
        informarResultado(grDescartados);

    }

    private void estivar(Bolsa bolsa) {
        bolsas.add(bolsa);
    }

    private void embolsar(Bolsa bolsa, Galletita galletita) {
        bolsa.agregar(galletita);
    }

    public void informarResultado(double grDescartados) {
        double acumBolsa = 0;
        System.out.println("Total Bolsas: " + bolsas.size());

        for (Bolsa bolsa : bolsas) {
            acumBolsa += bolsa.getPesoNeto();
        }
        System.out.println("Bolsa Promedio: " + acumBolsa / bolsas.size());

        System.out.println("Kilos Descate: " + grDescartados / 1000);
    }

}
