package Garage;

import java.util.ArrayList;

public class Empresa {
    private String razonSocial;
    private ArrayList<Garage> garages;

    /* --------------------- CONSTRUCTOR -------------------- */

    public Empresa(String razonSocial) {
        this.razonSocial = razonSocial;
        garages = new ArrayList<>();
    }

    /* ----------------------- METODOS ---------------------- */

    public ArrayList<Informe> obtenerInromeEstadoGarages() {
        ArrayList<Informe> informeGarage = new ArrayList<>();

        for (Garage garage : garages) {
            informeGarage.add(new Informe(garage.getCodigo(), garage.getCantVehiculosEstacionados()));
        }

        return informeGarage;
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Empresa [razonSocial=" + razonSocial + "]";
    }
}
