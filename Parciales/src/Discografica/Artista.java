package Discografica;

public class Artista {
    private String nombre;
    private Instrumento instrumento;
    private Rol rol;

    public Artista(String nombre, Instrumento instrumento) {
        this.nombre = nombre;
        this.instrumento = instrumento;
    }

    public Artista(String nombre, Rol rol) {
        this.nombre = nombre;
        this.rol = rol;
    }

    /* ----------------------- METODOS ---------------------- */

    public String getNombre() {
        return nombre;
    }

    public boolean mismoAutor(String nombre) {
        return this.nombre.equals(nombre);
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    public Rol getRol() {
        return rol;
    }

    @Override
    public String toString() {
        return "Artista [instrumento=" + instrumento + ", nombre=" + nombre + "]";
    }

}
