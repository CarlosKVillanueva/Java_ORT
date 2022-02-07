package BancOrt;

import java.util.ArrayList;

public class Resultado {

    private Estado estado;
    private ArrayList<Billete> falsos;
    private ArrayList<Billete> entregados;

    public Resultado(Estado estado, ArrayList<Billete> falsos) {
        this.estado = estado;
        this.falsos = falsos;
    }

    public Resultado(ArrayList<Billete> entregados, Estado estado) {
        this.entregados = entregados;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public ArrayList<Billete> getFalsos() {
        return falsos;
    }

    public void mostrarResultadoDeposito() {
        System.out.println("\nResultado Deposito: " + estado);
        System.out.println("\n*** Billetes Falsos ***");
        for (Billete billete : falsos) {
            System.out.println(billete);
        }
    }

    public void mostrarResultadoExtraccion() {
        System.out.println("\nResultado Deposito: " + estado);
        System.out.println("\n*** Billetes Entregados ***");
        for (Billete billete : entregados) {
            System.out.println(billete);
        }
    }

    @Override
    public String toString() {
        return "Resultado => Estado:" + estado + " | Falsos: " + falsos + "]";
    }

}
