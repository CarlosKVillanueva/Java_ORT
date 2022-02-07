package Discografica;

public class Recuperatorio {
    public static void main(String[] args) {
        Discografica discografica = new Discografica("GRUNGE FOREVER DISCOS");

        /* ----------------------- TEMA 1 ----------------------- */

        discografica.agregarDisco("Jazz in Rio", "Garota Jazz Quinteto", true,
                Genero.JAZZ);
        discografica.agregarTemaDisco("Paco", 180);
        discografica.agregarTemaDisco("Rio de sangre", 235);

        discografica.agregarArtista(0, 0, "Mariano Morel", null, Lista.AUTOR);
        discografica.agregarArtista(0, 0, "Ana do Prado", Instrumento.VOZ,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 0, "Claudio Peres", Instrumento.TECLADOS,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 0, "Mariano Morel", Instrumento.PERCUSION,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 0, "Paula Marcucci", Instrumento.VIENTOS,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 0, "Mario Santos", Instrumento.OTROS,
                Lista.INTERPRETE);

        discografica.agregarArtista(0, 1, "Claudio Peres", null, Lista.AUTOR);
        discografica.agregarArtista(0, 1, "Ana do Prado", null, Lista.AUTOR);
        discografica.agregarArtista(0, 1, "Ana do Prado", Instrumento.TECLADOS,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 1, "Claudio Peres", Instrumento.VOZ,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 1, "Mariano Morel", Instrumento.PERCUSION,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 1, "Paula Marcucci", Instrumento.VIENTOS,
                Lista.INTERPRETE);
        discografica.agregarArtista(0, 1, "Mario Santos", Instrumento.CUERDAS,
                Lista.INTERPRETE);

        System.out.println("\n*** Quitar Tema ***\n");
        System.out.println(discografica.quitarTema("Paco", "Mariano Morel"));
        System.out.println("\n*** Mostrar Discos Discontinuados\n ***");
        discografica.mostrarDiscosDiscontinuados();

        /* ----------------------- TEMA 2 ----------------------- */
        // discografica.agregarDisco("Greatest Hits", "Foo Fighters", false,
        // Genero.GRUNGE);
        // discografica.agregarTemaDisco("The Pretender", 269);
        // discografica.agregarTemaDisco("Long Road to Ruin", 224);
        // discografica.agregarTemaDisco("The Pretender", 269);
        // discografica.agregarTemaDisco("Times like these", 270);

        // discografica.agregarArtista("Dave Grohl", Rol.CANTANTE, Lista.AUTOR);
        // discografica.agregarArtista("Pat Smear", Rol.GUITARRISTA, Lista.INTERPRETE);
        // discografica.agregarArtista("Nate Mendel", Rol.BAJISTA, Lista.INTERPRETE);
        // discografica.agregarArtista("Taylor Hawkins", Rol.BATERISTA,
        // Lista.INTERPRETE);
        // discografica.agregarArtista("Chris Shiflett", Rol.GUITARRISTA,
        // Lista.INTERPRETE);
        // discografica.agregarArtista("Rami Jaffee", Rol.TECLADISTA, Lista.INTERPRETE);

        // discografica.mostrarDiscosPorGenero(Genero.GRUNGE);
    }
}
