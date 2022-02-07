package THP_YA1G_RESOLUCION_CATEDRA;

import java.util.ArrayList;

public class Tren {
    private static final int VAGONES_MAX = 30;
    private int nroTren;
    private ArrayList<Vagon> vagones;

    public Tren(int nroTren) {
        this.nroTren = nroTren;
        vagones = new ArrayList<>();
    }

    public int getNroTren() {
        return nroTren;
    }

    public double capacidadTren() {
        double capacidad = 0;

        for (Vagon vagon : vagones) {
            capacidad += vagon.capacidadVagon();
        }
        return capacidad;
    }

    public double capacidadTrenLibre() {
        double capacidad = 0;

        for (Vagon vagon : vagones) {
            capacidad += vagon.capacidadLibre();
        }
        return capacidad;
    }

    public Resultado agregarVagones(int cant, TipoVagon tipo) {
        Resultado resultado = Resultado.CANT_VAGONES_INVALIDA;

        int cantDisponible = VAGONES_MAX - vagones.size();

        if (cant > 0 && cant <= cantDisponible) {
            for (int i = 0; i < cant; i++) {
                vagones.add(new Vagon(tipo));
            }
            resultado = Resultado.AGREGADO_OK;
        }

        return resultado;
    }

    public int eliminarVagonesVacios() {
        int vagonesEliminados = 0;
        int i = 0;
        while (i < vagones.size()) {
            if (vagones.get(i).estaVacio()) {
                vagones.remove(i);
                vagonesEliminados++;
            } else
                i++;
        }

        return vagonesEliminados;
    }

    public double cargarVagones(double cantCarga) {

        int i = 0;

        while (i < vagones.size() && cantCarga > 0) {
            Vagon vagon = vagones.get(i);
            if (!vagon.estaLleno()) {
                double aCargar;

                if (cantCarga < vagon.capacidadLibre()) {
                    aCargar = cantCarga;
                } else {
                    aCargar = vagon.capacidadLibre();
                }

                vagon.cargarVagon(aCargar);
                cantCarga -= aCargar;

            }
            i++;
        }

        return cantCarga;
    }

    public boolean mismoTren(int nroTren) {
        return this.nroTren == nroTren;
    }
}
