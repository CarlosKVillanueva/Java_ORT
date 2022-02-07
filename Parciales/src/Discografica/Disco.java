package Discografica;

import java.util.ArrayList;

public class Disco {
    private String nombreDisco;
    private String nombreBanda;
    private boolean discontinuado;
    private Genero genero;
    private ArrayList<Tema> temas;

    public Disco(String nombreDisco, String nombreBanda, boolean discontinuado, Genero genero) {
        this.nombreDisco = nombreDisco;
        this.nombreBanda = nombreBanda;
        this.discontinuado = discontinuado;
        this.genero = genero;
        temas = new ArrayList<>();
    }

    /* ---------------------- AGREGADO ---------------------- */

    public void agregarArtistaTema(int pos, String nombre, Instrumento instrumento, Lista listaAgregar) {

        temas.get(pos).agregarArtistaTema(nombre, instrumento, listaAgregar);
    }

    public void agregarArtistaTema(String nombre, Rol rol, Lista listaAgregar) {
        for (Tema tema : temas) {
            tema.agregarArtistaTema(nombre, rol, listaAgregar);
        }

    }

    public void agregarTema(String nombre, int duracion) {
        temas.add(new Tema(nombre, duracion));
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    public Tema buscarTema(String nombre) {
        Tema elementoBuscado = null;
        int i = 0, cantElementos = temas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (temas.get(i).mismoTema(nombre)) {
                elementoBuscado = temas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public Tema buscarTema(String tema, String autor) {
        Tema elementoBuscado = null;
        int i = 0, cantElementos = temas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (temas.get(i).mismoTemaAutor(tema, autor)) {
                elementoBuscado = temas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- METODOS ---------------------- */

    public void borrarTema(Tema temaBuscado) {
        temas.remove(temaBuscado);
    }

    public boolean estaDiscontinuado() {
        return discontinuado;
    }

    public Genero getGenero() {
        return genero;
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public int getDuracionDisco() {
        int acumSegundos = 0;

        for (Tema tema : temas) {
            acumSegundos += tema.getDuracion();
        }

        return acumSegundos;
    }

    public void mostrarTemas() {
        int cont = 0;

        for (Tema tema : temas) {
            System.out.println(
                    "Tema " + ++cont + " " + "\"" + tema.getNombre() + "\"" + " (Autor/es: " + tema.getAutores() + ")");
            System.out.println("Duracion: " + tema.getDuracion() + " seg.");
            System.out.println("");
            System.out.println("Interpretes: " + tema.mostrarInterpretes() + "\n");
        }
    }

    public void mostrarTemasGrunge() {
        for (Tema tema : temas) {
            System.out.println("\tNombre del Tema: " + "\"" + tema.getNombre() + "\"");
            System.out.println("\tDuración: " + tema.getDuracion() + " segundos");
            System.out.println("\tCompositor: " + tema.getAutoresGrunge());
            System.out.println("\tArtistas:");
            tema.mostrarInterpretesGrunge();
        }
    }

    @Override
    public String toString() {
        return nombreDisco;
    }

}
