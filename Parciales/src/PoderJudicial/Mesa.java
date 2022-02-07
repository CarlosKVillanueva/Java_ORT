package PoderJudicial;

import java.util.ArrayList;

public class Mesa {
    private int numeroMesa;
    private Votante presidente;
    private ArrayList<Votante> votantes;

    public Mesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
        this.votantes = new ArrayList<>();
    }

    public Mesa() {
        this.presidente = tienePresidente();
    }

    public void setPresidente(Votante presidente) {
        this.presidente = presidente;
    }

    public Votante getPresidente() {
        return presidente;
    }

    public Votante tienePresidente() {

        int i = 0;

        Votante esPresidente = null;

        while (i < votantes.size() && !votantes.get(i).isPresidente()) {
            esPresidente = votantes.get(i);
            i++;
        }

        return esPresidente;
    }

    private Votante buscarVotante(String dni) {
        Votante elementoBuscado = null;
        int i = 0, cantElementos = votantes.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (votantes.get(i).mismoVotante(dni)) {
                elementoBuscado = votantes.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean agregarVotante(String dni, boolean presidente, String nombre, String apellido, String fechaNac,
            Genero tipoGenero) {

        boolean agregado = false;

        if (dni != null) {

            if (buscarVotante(dni) == null) {
                votantes.add(new Votante(dni, presidente, nombre, apellido, fechaNac, tipoGenero));
                agregado = true;
            }
        }

        return agregado;
    }

    /* ----------------------- METODOS ---------------------- */

    public boolean mismaMesa(int numeroMesa) {
        return this.numeroMesa == numeroMesa;
    }

    @Override
    public String toString() {
        return "Mesa [numeroMesa=" + numeroMesa + "]";
    }

}
