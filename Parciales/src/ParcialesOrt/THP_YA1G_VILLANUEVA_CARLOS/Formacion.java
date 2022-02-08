package THP_YA1G_VILLANUEVA_CARLOS;

import java.util.ArrayList;

public class Formacion {
    private static final int CANT_MAX_VAGONES = 30;
    private static final int CANT_MIN_VAGONES = 0;
    private int numeroFormacion;
    private ArrayList<Vagon> vagones;

    public Formacion(int numeroFormacion) {
        this.numeroFormacion = numeroFormacion;
        vagones = new ArrayList<>();
    }

    public int getNumeroFormacion() {
        return numeroFormacion;
    }

    public boolean validarCantidad(int cantVagones) {
        boolean rango = cantVagones <= CANT_MAX_VAGONES && cantVagones > CANT_MIN_VAGONES;
        int vagonesDisponibles = CANT_MAX_VAGONES - vagones.size();
        boolean disponibles = cantVagones <= vagonesDisponibles;
        return rango && disponibles;
    }

    public void agregarVagones(int cantVagones, TipoVagon tipoVagon) {

        int i = 0;
        while (i < cantVagones && vagones.size() <= CANT_MAX_VAGONES) {
            vagones.add(new Vagon(vagones.size() + 1, tipoVagon));
            i++;
        }
    }

    public double cargarVagones(double cantToneladas) {
        double carga = cantToneladas;

        carga = cantToneladas + recorrerVagones();

        return carga;
    }

    public double recorrerVagones() {
        double cargaTotal = 0;
        for (Vagon vagon : vagones) {
            cargaTotal += vagon.cargaPorTipo();
        }
        return cargaTotal;
    }

    public boolean mismoFormacion(int numeroFormacion) {
        return this.numeroFormacion == numeroFormacion;
    }

}
