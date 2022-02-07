package Discografica;

import java.util.ArrayList;

public class Discografica {
    private String razonSocial;
    private ArrayList<Disco> discos;

    /* --------------------- CONSTRUCTOR -------------------- */

    public Discografica(String razonSocial) {
        this.razonSocial = razonSocial;
        discos = new ArrayList<>();
    }

    /* ---------------------- AGREGADO ---------------------- */

    public void agregarArtista(int discoPos, int cancionPos, String nombre,
            Instrumento instrumento,
            Lista listaAgregar) {
        discos.get(discoPos).agregarArtistaTema(cancionPos, nombre, instrumento, listaAgregar);
    }

    public void agregarArtista(String nombre, Rol rol, Lista listaAgregar) {
        for (Disco disco : discos) {
            disco.agregarArtistaTema(nombre, rol, listaAgregar);
        }
    }

    public void agregarDisco(String nombreDisco, String nombreBanda, boolean discontinuado, Genero genero) {
        discos.add(new Disco(nombreDisco, nombreBanda, discontinuado, genero));
    }

    public void agregarTemaDisco(String nombre, int duracion) {
        discos.get(0).agregarTema(nombre, duracion);
    }

    /* ----------------------- METODOS ---------------------- */

    /* ----------------------- TEMA 1 ----------------------- */
    public Informe quitarTema(String nombreTema, String nombreAutor) {
        Informe informeRetonar = null;
        Tema temaEncontrado = null;
        ArrayList<Disco> discoDondeSeElimino = new ArrayList<>();

        for (Disco disco : discos) {

            temaEncontrado = disco.buscarTema(nombreTema);

            if (temaEncontrado != null) {

                Artista autorBuscado = temaEncontrado.buscarAutor(nombreAutor);

                if (autorBuscado != null) {
                    discoDondeSeElimino.add(disco);
                    disco.borrarTema(temaEncontrado);
                }
            }

        }
        informeRetonar = new Informe(temaEncontrado, discoDondeSeElimino);
        return informeRetonar;
    }

    /* ----------------------- TEMA 2 ----------------------- */

    public Informe eliminarTema(String nombreTema, String nombreAutor) {
        Informe informeRetornar = null;
        Tema temaEncontrado = null;

        ArrayList<Disco> discoDondeSeElimino = new ArrayList<>();

        for (Disco disco : discos) {
            temaEncontrado = disco.buscarTema(nombreTema, nombreAutor);

            if (temaEncontrado != null) {
                discoDondeSeElimino.add(disco);
                disco.borrarTema(temaEncontrado);
            }
        }
        informeRetornar = new Informe(temaEncontrado, discoDondeSeElimino);
        return informeRetornar;
    }

    public void mostrarDiscosDiscontinuados() {

        for (Disco disco : discos) {

            if (disco.estaDiscontinuado()) {

                System.out.println(
                        "\nDisco: " + "\"" + disco.getNombreDisco() + "\"" + " - Banda: " + disco.getNombreBanda());
                System.out.println("\nDuracion Total: " + disco.getDuracionDisco() + " segundos.");
                disco.mostrarTemas();
                System.out.println("*** Fin Disco ***");
            }
        }
    }

    public void mostrarDiscosPorGenero(Genero genero) {
        for (Disco disco : discos) {
            if (disco.getGenero().equals(genero)) {
                System.out.println("\nBanda: " + "\"" + disco.getNombreBanda() + "\"");
                System.out.println("Disco: " + "\"" + disco.getNombreDisco() + "\"");
                System.out.println("Duración Total: " + disco.getDuracionDisco() + " segundos");
                System.out.println("Temas:");
                disco.mostrarTemasGrunge();
                System.out.println("");
                System.out.println("*** Fin Disco ***");
            }
        }
    }

    @Override
    public String toString() {
        return "Discografica [razonSocial=" + razonSocial + "]";
    }

}
