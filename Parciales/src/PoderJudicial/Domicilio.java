package PoderJudicial;

public class Domicilio {
    private String calle;
    private String codigoPostal;
    private Provincia provincia;

    public Domicilio(String calle, String codigoPostal, Provincia provincia) {
        this.calle = calle;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Domicilio [calle=" + calle + ", codigoPostal=" + codigoPostal + ", provincia=" + provincia + "]";
    }

}
