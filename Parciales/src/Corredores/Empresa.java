package Corredores;

import java.util.ArrayList;

public class Empresa {
    private String razonSocial;
    private ArrayList<Carrera> carreras;

    public Empresa(String razonSocial) {
        this.razonSocial = razonSocial;
        carreras = new ArrayList<>();
    }

    /* --------------------- CONSTRUCTOR -------------------- */

    /* ----------------------- GETTERS ---------------------- */

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */

    public void agregarCarrera() {
        carreras.add(new Carrera("Hoy", "YA", Dificultad.AS_DEL_VOLANTE));
    }

    public void agregarPiloto(int cantidad) {
        carreras.get(0).agregarPiloto(cantidad);
    }

    public void agregarVueltas(int cantVueltas) {
        carreras.get(0).agregarVueltas(cantVueltas);
    }

    public double calcularPromedio(String dni) {
        double promedio = 0;
        int i = 0;
        boolean encontrePiloto = false;

        while (i < carreras.size() && !encontrePiloto) {
            encontrePiloto = carreras.get(i).encontrePiloto(dni);
            if (encontrePiloto) {
                promedio = carreras.get(i).calcularPromedio(dni);
            } else {
                i++;
            }
        }

        // if (!encontrePiloto) {
        // System.out.println("El piloto no se encontro");
        // } else {
        // System.out.println("El piloto no termino la carrera");
        // }
        return promedio;
    }

    // public void listarPromedios(double promedio) {
    // for (Carrera carrera : carreras) {
    // System.out.println(carrera.buscarPilotosPorDebajoDe(promedio));
    // }
    // }

    public ArrayList<Piloto> listarPromedios(double promedio) {
        ArrayList<Piloto> pilotosADevolver = new ArrayList<>();

        for (Carrera carrera : carreras) {
            pilotosADevolver.addAll(carrera.buscarPilotosPorDebajoDe(promedio));
        }
        return pilotosADevolver;
    }

    public ArrayList<Integer> pilotosPorCarrera() {
        ArrayList<Integer> cantPilotos = new ArrayList<>();

        for (Carrera carrera : carreras) {
            cantPilotos.add(carrera.cantPilotos());
        }

        return cantPilotos;

    }

    public ArrayList<Piloto> buscarPilotosPorDebajoDe(double promedio) {
        ArrayList<Piloto> porDebajo = new ArrayList<>();

        porDebajo.addAll(carreras.get(0).buscarPilotosPorDebajoDe(promedio));

        return porDebajo;
    }

    public void mostrarMenorPromedio() {
        carreras.get(0).mostrarMenorPromedio();
    }

    /* ---------------------- TO STRING --------------------- */
    @Override
    public String toString() {
        return "Empresa [razonSocial=" + razonSocial + "]";
    }

}
