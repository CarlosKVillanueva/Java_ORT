package Bingo;

import java.util.ArrayList;

public class Participante {
    private int id = 0;
    private Carton carton;

    public Participante(int id, ArrayList<Integer> numerosBolillero) {
        this.id = id;
        this.carton = crearCarton(numerosBolillero);
    }

    public int getId() {
    	return id;
    }
    
    private Carton crearCarton(ArrayList<Integer> numerosBolillero) {
        Carton carton = new Carton(numerosBolillero);

        carton.asignarNumeros(numerosBolillero);

        return carton;

    }

    public int chequearNumero(int numeroRonda) {
        return carton.chequearNumero(numeroRonda);
    }

    @Override
    public String toString() {
        return "" + carton;
    }

}
