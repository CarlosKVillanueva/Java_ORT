package ShowTime;

import java.util.ArrayList;

public class Espectaculo {
    private String titulo;
    private TipoObra tipo;
    private Fecha fecha;
    private Hora hora;
    private ArrayList<Espectador> espectadores;

    public Espectaculo(String titulo, TipoObra tipo, Fecha fecha, Hora hora) {
        this.titulo = titulo;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.espectadores = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Espectador buscarEspectador(String dni) {
        Espectador elementoBuscado = null;
        int i = 0, cantElementos = espectadores.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (espectadores.get(i).mismoEspectador(dni)) {
                elementoBuscado = espectadores.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarEspectador(String nombre, String apellido, String dni, double valorEntrada) {
        boolean agregado = false;

        if (buscarEspectador(dni) == null) {
            espectadores.add(new Espectador(nombre, apellido, dni, valorEntrada));
            agregado = true;
        }

        return agregado;
    }

    /* ----------------------- METODOS ---------------------- */

    public boolean mismoEspectaculo(String titulo) {
        return this.titulo.equals(titulo);
    }

    public double obtenerRecaudacion() {
        double acumEntradas = 0;

        for (Espectador espectador : espectadores) {
            acumEntradas += espectador.getValorEntrada();
        }

        return acumEntradas;
    }

    @Override
    public String toString() {
        return "Espectaculo [fecha=" + fecha + ", hora=" + hora + ", tipo=" + tipo + ", titulo=" + titulo + "]";
    }

    public boolean buscarDni(String dni) {
        return buscarEspectador(dni) != null;
    }

}
