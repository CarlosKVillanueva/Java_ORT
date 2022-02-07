package Vuelo;

public class Test {

    public static void main(String[] args) {

        Vuelo vuelo = new Vuelo("AA3313", 180);

        // reservas buenas
        System.out.println(vuelo.asignarAsiento("11111111", "1234567890", Categoria.PRIMERA, "A", 1));
        System.out.println(vuelo.asignarAsiento("33333333", "1234567893", Categoria.TURISTA, "F", 6));

        // reserva contiguos
        System.out.println(vuelo.asignarAsiento("22222222", "1234567891", Categoria.PRIMERA, "A", 2));
        System.out.println(vuelo.asignarAsiento("44444444", "1234567894", Categoria.TURISTA, "F", 5));

        // reserva uno ya vendido
        System.out.println(vuelo.asignarAsiento("11111111", "1234567890", Categoria.PRIMERA, "A", 1));

        // mostrar monto recaudado por clase
        vuelo.mostrarMontoRecaudadoDeClase(Categoria.PRIMERA);
        vuelo.mostrarMontoRecaudadoDeClase(Categoria.BUSINESS);
        vuelo.mostrarMontoRecaudadoDeClase(Categoria.TURISTA);

    }
}