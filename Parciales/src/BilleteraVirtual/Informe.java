package BilleteraVirtual;

public class Informe {
    private String dni;
    private int cantCompras;

    public Informe(String dni, int cantCompras) {
        this.dni = dni;
        this.cantCompras = cantCompras;
    }

    @Override
    public String toString() {
        return "Informe: " + dni + " | " + cantCompras + " compras.";
    }

}
