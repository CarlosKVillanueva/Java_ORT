package Bingo;

import java.util.ArrayList;

public class Carton {
    private final int CANTIDAD_NUMEROS = 15;

    private ArrayList<Integer> numeros;
    private int restantes;

    public Carton(ArrayList<Integer> numerosBolillero) {
        this.numeros = new ArrayList<>();
        this.restantes = CANTIDAD_NUMEROS;
    }

    public void asignarNumeros(ArrayList<Integer> numerosBolillero) {
        int i = 0;
        while (i < CANTIDAD_NUMEROS) {
            int random = (int) Math.floor(Math.random() * numerosBolillero.size());
            if (!estaRepetido(random)) {
                numeros.add(random);
                i++;
            }
        }

    }

    private boolean estaRepetido(int numero) {
        boolean estaRepetido = false;
        int i = 0, cantElementos = numeros.size();

        while (i < cantElementos && estaRepetido == false) {
            if (numeros.get(i) == numero) {
                estaRepetido = true;
            } else {
                i++;
            }
        }
        return estaRepetido;
    }

    public int chequearNumero(int numeroRonda) {

        if (estaRepetido(numeroRonda)) {
            restantes--;
        }
        return restantes;
    }

    @Override
    public String toString() {
        return "Carton [CANTIDAD_NUMEROS=" + CANTIDAD_NUMEROS + ", numeros=" + numeros + ", restantes=" + restantes
                + "]";
    }

}
