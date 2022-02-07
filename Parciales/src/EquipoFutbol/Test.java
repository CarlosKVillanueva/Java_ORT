package EquipoFutbol;

public class Test {
    public static void main(String[] args) {
        Partido clasico = new Partido("10/02/20");

        clasico.agregarEquipo("Racing");
        clasico.agregarEquipo("Indesingente");

        System.out.println(clasico.agregarJugadorEquipo("Racing", 22, "Milito", 3));
        System.out.println(clasico.agregarJugadorEquipo("Racing", 22, "Milito", 3));
        System.out.println(clasico.agregarJugadorEquipo("Racing", 15, "Licha", 2));
        System.out.println(clasico.agregarJugadorEquipo("Racing", 21, "Chelo", 1));

        System.out.println(clasico.agregarJugadorEquipo("Indesingente", 3, "Rosa", 0));
        System.out.println(clasico.agregarJugadorEquipo("Indesingente", 2, "Re", 0));
        System.out.println(clasico.agregarJugadorEquipo("Indesingente", 1, "Poto", 0));
        System.out.println("");
        System.out.println("*** Resultado Partido ***");
        System.out.println(clasico.jugar("Racing", "Indesingente"));

        System.out.println("");
        clasico.mostrarGoles("Racing", 22);
    }

}
