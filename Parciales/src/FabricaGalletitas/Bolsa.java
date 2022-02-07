package FabricaGalletitas;

import java.util.ArrayList;

public class Bolsa {
    private double pesoEstimado;
    private double pesoNeto;
    private ArrayList<Galletita> galletitas;

    public Bolsa(int pesoEstimado) {
        this.pesoEstimado = pesoEstimado;
        this.pesoNeto = 0;
        galletitas = new ArrayList<>();
    }

    public double getPesoEstimado() {
        return pesoEstimado;
    }

    public void setPesoEstimado(double pesoEstimado) {
        this.pesoEstimado = pesoEstimado;
    }

    public double getPesoNeto() {
        return pesoNeto;
    }

    public void setPesoNeto(double pesoNeto) {
        this.pesoNeto = pesoNeto;
    }

    public void agregar(Galletita galletita) {
        galletitas.add(galletita);
        this.pesoNeto += galletita.getGramos();
    }

    public Galletita extraer() {
        Galletita galletita = galletitas.remove(0);
        pesoNeto += galletita.getGramos();
        return galletita;
    }

    public boolean estaLlena() {
        return this.pesoNeto >= this.pesoEstimado;
    }

    public boolean estaVacia() {
        return galletitas.isEmpty();
    }

}
