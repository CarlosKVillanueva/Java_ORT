package Corredores;

public class Corredores_Test {
    public static void main(String[] args) {

        Empresa corredores = new Empresa("Corredores");

        corredores.agregarCarrera();
        corredores.agregarPiloto(10);
        corredores.agregarVueltas(10);

        System.out.println(corredores.calcularPromedio("6"));
        System.out.println(corredores.calcularPromedio("3"));
        System.out.println(corredores.calcularPromedio("tuvieja"));
        System.out.println(corredores.buscarPilotosPorDebajoDe(25));
        System.out.println("");
        corredores.mostrarMenorPromedio();
        System.out.println(corredores.pilotosPorCarrera());
    }
}
