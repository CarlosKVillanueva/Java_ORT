package Bingo;

import java.util.ArrayList;

public class Bolillero {
    private final int CANTIDAD_NUMEROS = 90;
    private ArrayList<Integer> numeros;

    public Bolillero() {
        this.numeros = new ArrayList<>();
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void agregarNumeros() {
        int i = 0;
        while (i < CANTIDAD_NUMEROS) {
            int random = (int) Math.floor(Math.random() * CANTIDAD_NUMEROS);

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

    public int sacarNumero() {
        int numeroRonda = 0;

        numeroRonda = numeros.get(0);
        numeros.remove(numeros.get(0));

        return numeroRonda;
    }

    public String mostrarNumeros() {
        String resultado = "";
        System.out.println("*** Numeros Bolillero ***");
        for (Integer numero : numeros) {
            resultado += numero + ", ";
        }
        return resultado;
    }

    public int getNumerosEmitidos() {
        return CANTIDAD_NUMEROS - numeros.size();
    }

    @Override
    public String toString() {
        return "Bolillero [numeros=" + numeros + "]";
    }

}
