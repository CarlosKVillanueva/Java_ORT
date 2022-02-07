package LinkedIn;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private ArrayList<Usuario> amigos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        amigos = new ArrayList<Usuario>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    public Usuario buscarAmigo(String nombre) {

        Usuario amigoADevolver = null;
        int i = 0;
        while (i < amigos.size() && amigoADevolver == null) {
            if (amigos.get(i).mismoUsuario(nombre)) {
                amigoADevolver = amigos.get(i);
            }
            i++;
        }

        return amigoADevolver;
    }

    public Usuario buscarAmigoUsuario(String nombre) {
        return buscarAmigoDeAmigo(nombre, amigos);
    }
    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarAmigo(String nombre) {
        boolean seAgrego = false;
        Usuario amigoAgregar = buscarAmigo(nombre);

        if (amigoAgregar == null) {
            amigos.add(new Usuario(nombre));
            seAgrego = true;
        }
        return seAgrego;
    }

    /* ----------------------- METODOS ---------------------- */

    public boolean mismoUsuario(String nombre) {
        return nombre.equalsIgnoreCase(this.nombre);
    }

    public boolean esAmigo(String amigoBuscado) {
        return buscarAmigo(amigoBuscado) == null;
    }

    public Usuario esAmigoDeAlguien(String nombreAmigo) {

        Usuario amigoEnComun = null;
        int i = 0;

        while (i < amigos.size() && buscarAmigoDeAmigo(nombreAmigo, amigos.get(i).amigos) == null) {
            i++;
        }
        if (i < amigos.size()) {
            amigoEnComun = amigos.get(i);
        }

        return amigoEnComun;
    }

    private Usuario buscarAmigoDeAmigo(String nombre, ArrayList<Usuario> amigosDeAmigo) {
        Usuario amigo = null;
        int i = 0;
        while (i < amigosDeAmigo.size() && amigo == null) {
            if (amigos.get(i).mismoUsuario(nombre)) {
                amigo = amigosDeAmigo.get(i);
            }
            i++;
        }

        return amigo;

    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Usuario [nombre=" + nombre + "]";
    }

}
