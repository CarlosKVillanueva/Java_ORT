package PoderJudicial;

public class Votante {
    private String dni;
    private boolean presidente;
    private String nombre;
    private String apellido;
    private String fechaNac;
    private Genero tipoGenero;

    public Votante(String dni, boolean presidente, String nombre, String apellido, String fechaNac, Genero tipoGenero) {
        this.dni = dni;
        this.presidente = presidente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
        this.tipoGenero = tipoGenero;
    }

    public boolean isPresidente() {
        return presidente;
    }

    public void setPresidente(boolean presidente) {
        this.presidente = presidente;
    }

    public boolean mismoVotante(String dni) {
        return this.dni.equals(dni);
    }

    @Override
    public String toString() {
        return "Votante [apellido=" + apellido + ", dni=" + dni + ", fechaNac=" + fechaNac + ", dni=" + nombre
                + ", presidente=" + presidente + ", tipoGenero=" + tipoGenero + "]";
    }

}
