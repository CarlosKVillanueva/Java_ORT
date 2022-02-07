package FabricaBotellas;

public class Test {
    public static void main(String[] args) {
        Embotelladora tuvieja = new Embotelladora("Tu Vieja Embotella", 50);

        tuvieja.fabricar(50);
        tuvieja.fabricar(10);
        System.out.println("Se enviaron: " + tuvieja.enviarBotellas());
        tuvieja.fabricar(50);
        tuvieja.fabricar(10);
        tuvieja.fabricar(10);
        tuvieja.fabricar(10);
    }
}
