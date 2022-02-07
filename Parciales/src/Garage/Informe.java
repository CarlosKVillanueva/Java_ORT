package Garage;

public class Informe {
    private String codigoGarage;
    private int cantVehiculos;

    public Informe(String codigoGarage, int cantVehiculos) {
        this.codigoGarage = codigoGarage;
        this.cantVehiculos = cantVehiculos;
    }

    @Override
    public String toString() {
        return "Informe [cantVehiculos=" + cantVehiculos + ", codigoGarage=" + codigoGarage + "]";
    }

}
