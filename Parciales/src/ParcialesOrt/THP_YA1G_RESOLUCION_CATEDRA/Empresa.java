package THP_YA1G_RESOLUCION_CATEDRA;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private int ultimoNro;
    private ArrayList<Tren> trenes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.ultimoNro = 0;
        trenes = new ArrayList<>();

    }

    public int crearFormacion() {
        ultimoNro++;

        trenes.add(new Tren(ultimoNro));
        // trenes.add(new Tren(++nroTren)); Suma antes de usar la variable
        return ultimoNro;
    }

    public Resultado agregarVagones(int nroTren, int cantVagones, TipoVagon tipo) {
        Resultado resultado = Resultado.NO_EXISTE_TREN;
        Tren trenBuscado = buscarTren(nroTren);

        if (trenBuscado != null) {
            resultado = trenBuscado.agregarVagones(cantVagones, tipo);
        }

        return resultado;
    }

    private Tren buscarTren(int nroTren) {
        Tren elementoBuscado = null;
        int i = 0, cantElementos = trenes.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (trenes.get(i).mismoTren(nroTren)) {
                elementoBuscado = trenes.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public double cargarTren(int nroTren, double cantidadCarga) {
        double sobrante = 0;

        Tren tren = buscarTren(nroTren);
        if (tren != null && cantidadCarga > 0) {
            // && tren.capacidadTrenLibre() >= cantidadCarga
            sobrante = tren.cargarVagones(cantidadCarga);
        }

        return sobrante;
    }

    public int sacarVagonesVacios(int nroTren) {
        int vagonesEliminados = -1;
        Tren tren = buscarTren(nroTren);
        if (tren != null) {
            vagonesEliminados = tren.eliminarVagonesVacios();
        }

        return vagonesEliminados;
    }

    public void listarCapacidadTrenes() {
        if (trenes.size() > 0) {

            System.out.println("Listado de Trenes con Espacio Libre:");
            for (Tren tren : trenes) {
                double procentaje = 100 * tren.capacidadTrenLibre() / tren.capacidadTren();
                System.out.println("Tren" + tren.getNroTren() + " Espacio Libre: " + procentaje + "%");
            }
        } else
            System.out.println("No hay trenes");
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }

}
