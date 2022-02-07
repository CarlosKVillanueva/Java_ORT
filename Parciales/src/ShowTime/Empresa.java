package ShowTime;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Espectaculo> espectaculos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        espectaculos = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Espectaculo buscarEspectaculo(String titulo) {
        Espectaculo elementoBuscado = null;
        int i = 0, cantElementos = espectaculos.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (espectaculos.get(i).mismoEspectaculo(titulo)) {
                elementoBuscado = espectaculos.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarEspectaculo(String titulo, TipoObra tipo, Fecha fecha, Hora hora) {
        boolean agregado = false;
        Espectaculo espectaculoBuscado = buscarEspectaculo(titulo);

        if (espectaculoBuscado == null) {
            agregado = espectaculos.add(new Espectaculo(titulo, tipo, fecha, hora));
        }

        return agregado;
    }

    public boolean agregarEspectadorEspectaculo(String titulo, String nombre, String apellido, String dni,
            double valorEntrada) {
        boolean agregado = false;
        Espectaculo espectaculoBuscado = buscarEspectaculo(titulo);

        if (espectaculoBuscado != null) {
            agregado = espectaculoBuscado.agregarEspectador(nombre, apellido, dni, valorEntrada);
        }

        return agregado;
    }

    /* ----------------------- METODOS ---------------------- */

    public ArrayList<Espectaculo> obtenerEspectaculos() {
        ArrayList<Espectaculo> mayorRecaudacion = new ArrayList<>();
        double recaudaMax = Double.MIN_VALUE;

        for (Espectaculo espectaculo : espectaculos) {
            double valorActual = espectaculo.obtenerRecaudacion(); 

            if (valorActual > recaudaMax) {
                mayorRecaudacion.clear();
                recaudaMax = valorActual;
                mayorRecaudacion.add(espectaculo);
            } else if (valorActual == recaudaMax) {
                mayorRecaudacion.add(espectaculo);
            }
        }
        return mayorRecaudacion;
    }

    public boolean existeEspectador(String dni) {
        boolean existe = false;
        int i = 0;
        while (i < espectaculos.size() && !existe) {
            existe = espectaculos.get(i).buscarDni(dni);
            i++;
        }
        return existe;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }

}
