package PoderJudicial;

import java.util.ArrayList;

public class Escuela {
    private String nombre;
    private int cantMesas;
    private Domicilio domicilio;
    private ArrayList<Mesa> mesas;

    public Escuela(String nombre, int cantMesas, Domicilio domicilio) {
        this.nombre = nombre;
        this.cantMesas = cantMesas;
        this.domicilio = domicilio;
        mesas = new ArrayList<>();
    }

    private Mesa buscarMesa(int numeroMesa) {
        Mesa elementoBuscado = null;
        int i = 0, cantElementos = mesas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (mesas.get(i).mismaMesa(numeroMesa)) {
                elementoBuscado = mesas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean agregarMesa(int numeroMesa) {
        boolean agregada = false;

        if (numeroMesa > 0 && numeroMesa <= cantMesas) {
            Mesa mesaBuscada = buscarMesa(numeroMesa);

            if (mesaBuscada == null) {
                mesas.add(new Mesa(numeroMesa));
                agregada = true;
            }
        }
        return agregada;
    }

    public boolean agregarVotanteMesa(int numeroMesa, String dni, boolean presidente, String nombre, String apellido,
            String fechaNac, Genero tipoGenero) {

        boolean agregado = false;
        Mesa mesaVotante = buscarMesa(numeroMesa);

        if (mesaVotante != null) {
            agregado = mesaVotante.agregarVotante(dni, presidente, nombre, apellido, fechaNac, tipoGenero);
        }

        return agregado;
    }

    /* ----------------------- METODOS ---------------------- */

    public void asignarPresidente(int numeroMesa, String nombre) {
        int i = 0;
        Mesa mesaConPresidente = null;
        while (i < mesas.size() && mesaConPresidente == null) {
            if (mesas.get(i).tienePresidente() != null) {
                mesaConPresidente = mesas.get(i);
                
            } 
        }
    }

    public boolean mismaEscuela(String nombre) {
        return this.nombre.equals(nombre);
    }

    @Override
    public String toString() {
        return "Escuela [cantMesas=" + cantMesas + ", domicilio=" + domicilio + ", nombre=" + nombre + "]";
    }

}
