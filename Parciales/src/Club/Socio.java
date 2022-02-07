package Club;

import java.util.ArrayList;

public class Socio {
    private static final int EDAD_MIN = 0;
    private static final int EDAD_MAX = 100;
    private String nombre;
    private int edad;
    private ArrayList<Socio> amigos;

    public Socio(String nombre, int edad) {
        setEdad(edad);
        setNombre(nombre);
        amigos = new ArrayList<>();
    }

    private void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    private void setEdad(int edad) {
        if (edad < EDAD_MIN) {
            this.edad = EDAD_MIN;
        } else if (edad > EDAD_MAX) {
            this.edad = EDAD_MAX;
        } else {
            this.edad = edad;
        }
    }

    /* -------------------------------- BUSQUEDA -------------------------------- */

    private Socio buscarAmigo(Socio amigo) {
        Socio amigoBuscado = null;
        int i = 0;

        while (i < amigos.size() && amigoBuscado == null) {
            if (amigos.get(i).mismoAmigo(amigo)) {
                amigoBuscado = amigos.get(i);
            } else {
                i++;
            }
        }
        return amigoBuscado;
    }
    /* --------------------------------- METODOS -------------------------------- */

    public void establecerAmistad(Socio amigo) {
        amigos.add(amigo);
    }

    public void deshacerAmistad(Socio amigo) {
        amigos.remove(amigo);
    }

    private boolean mismoAmigo(Socio amigo) {
        return amigo == this;
    }

    public boolean mismoNombre(String nombre) {
        return this.nombre.equals(nombre);
    }

    public boolean esAmigo(Socio segundoSocio) {
        return buscarAmigo(segundoSocio) != null;
    }

    @Override
    public String toString() {
        return "Socio [Amigos: " + amigos + "| Edad: " + edad + "| Nombre: " + nombre + "]";
    }

}
