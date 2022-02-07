package FabricaBotellas;

import java.util.ArrayList;

public class Embotelladora {
    private String nombre;
    private Deposito deposito;
    private Maquina maquina;

    public Embotelladora(String nombre, int capacidadMaxBotellas) {
        this.nombre = nombre;
        this.deposito = new Deposito(capacidadMaxBotellas);
        this.maquina = new Maquina();
    }

    public int fabricar(int cantidadBotellasFabricar) {
        ArrayList<Botella> botellasCorrectas = new ArrayList<>();

        if (deposito.puedeAlmacenar(cantidadBotellasFabricar)) {
            botellasCorrectas = maquina.fabricar(cantidadBotellasFabricar);
        } else {
            System.out.println("No hay mas capacidad en el deposito");
        }

        deposito.guardar(botellasCorrectas);

        return botellasCorrectas.size();
    }

    public int enviarBotellas() {
        return deposito.enviar();
    }

	@Override
	public String toString() {
		return "Embotelladora [nombre=" + nombre + "]";
	}

}
