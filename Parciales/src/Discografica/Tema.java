package Discografica;

import java.util.ArrayList;

public class Tema {
    private String nombre;
    private int duracion;
    private ArrayList<Artista> autores;
    private ArrayList<Artista> interpretes;

    public Tema(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
        autores = new ArrayList<>();
        interpretes = new ArrayList<>();
    }

    /* ---------------------- AGREGADO ---------------------- */

    public void agregarArtistaTema(String nombre, Instrumento instrumento, Lista listaAgregar) {

        switch (listaAgregar) {
            case AUTOR:
                autores.add(new Artista(nombre, instrumento));
                break;
            case INTERPRETE:
                interpretes.add(new Artista(nombre, instrumento));
                break;
        }
    }

    public void agregarArtistaTema(String nombre, Rol rol, Lista listaAgregar) {

        switch (listaAgregar) {
            case AUTOR:
                autores.add(new Artista(nombre, rol));
                break;
            case INTERPRETE:
                interpretes.add(new Artista(nombre, rol));
                break;
        }
    }
    /* ---------------------- BUSQUEDA ---------------------- */

    public Artista buscarAutor(String nombre) {
        Artista elementoBuscado = null;
        int i = 0, cantElementos = autores.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (autores.get(i).mismoAutor(nombre)) {
                elementoBuscado = autores.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- METODOS ---------------------- */

    public boolean mismoTema(String nombre) {
        return this.nombre.equals(nombre);
    }

    public boolean mismoTemaAutor(String nombre, String autor) {
        return this.nombre.equals(nombre) && buscarAutor(autor) != null;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutores() {
        String cadenaAutores = "";

        for (Artista artista : autores) {

            cadenaAutores += artista.getNombre() + ((autores.lastIndexOf(artista) == autores.size() - 1) ? "" : ", ");
        }
        return cadenaAutores;
    }

    public String getAutoresGrunge() {
        String cadenaAutores = "";
        for (Artista artista : autores) {
            cadenaAutores = artista.getNombre() + ", " + artista.getRol();
        }

        return cadenaAutores;
    }

    public String mostrarInterpretes() {
        String cadenaInterpretes = "";

        for (Artista artista : interpretes) {

            cadenaInterpretes += artista.getNombre() + " (" + artista.getInstrumento()
                    + ((interpretes.lastIndexOf(artista) == interpretes.size() - 1) ? ")" : "),");
        }

        return cadenaInterpretes;
    }

    public void mostrarInterpretesGrunge() {
        for (Artista artista : interpretes) {
            System.out.println("\t\t" + artista.getNombre() + ", " + artista.getRol());
        }
        System.out.println("");
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return nombre;
    }

}
