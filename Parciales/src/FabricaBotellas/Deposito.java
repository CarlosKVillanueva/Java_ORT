package FabricaBotellas;

import java.util.ArrayList;

public class Deposito {

    private int capacidadMaxBotellas;
    private int ocupacionActual = 0;

    public Deposito(int capacidadMaxBotellas) {
        setCapacidadMaxBotellas(capacidadMaxBotellas);
    }

    public int getCapacidadMaxBotellas() {
        return capacidadMaxBotellas;
    }

    public void setCapacidadMaxBotellas(int capacidadMaxBotellas) {
        if (capacidadMaxBotellas > 0) {
            this.capacidadMaxBotellas = capacidadMaxBotellas;
        } else
            this.capacidadMaxBotellas = 1;

    }

    public boolean puedeAlmacenar(int cantidadBotellasFabricar) {
        return cantidadBotellasFabricar <= (capacidadMaxBotellas - ocupacionActual);
    }

    @Override
    public String toString() {
        return "Deposito [capacidadMaxBotellas=" + capacidadMaxBotellas + "]";
    }

    public void guardar(ArrayList<Botella> botellasCorrectas) {
        this.ocupacionActual += botellasCorrectas.size();
    }

    public int enviar() {
        int botellasEnviadas = this.ocupacionActual;

        this.ocupacionActual = 0;

        return botellasEnviadas;
    }

}
