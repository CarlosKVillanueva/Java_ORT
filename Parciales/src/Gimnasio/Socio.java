package Gimnasio;

public class Socio {
    private static final int CATEGORIA_MIN = 1;
    private static final int CATEGORIA_MAX = 3;
    private int dni;
    private String nombre;
    private int categoria;
    private double deuda;
    private Estado estado;

    public Socio(int dni, String nombre, int categoria, double deuda) {
        this.dni = dni;
        this.nombre = nombre;
        setCategoria(categoria);
        this.deuda = deuda;
        this.estado = Estado.NORMAL;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        if (categoria < CATEGORIA_MIN) {
            this.categoria = CATEGORIA_MIN;
        } else if (categoria > CATEGORIA_MAX) {
            this.categoria = CATEGORIA_MAX;
        } else {
            this.categoria = categoria;
        }
    }

    public boolean mismoSocio(int dni) {
        return this.dni == dni;
    }

    public boolean esDeudor() {
        return this.deuda > 0;
    }

    public boolean controlDueda(double monto) {
        return this.deuda >= monto;
    }

    public boolean controCategoria(int categoria) {
        return this.categoria == categoria;
    }

    public boolean setEstado(Estado moroso) {
        boolean resultado = false;
        if (this.estado != moroso) {
            this.estado = moroso;
            resultado = true;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Categoria: " + categoria + " | Nombre: " + nombre + " | DNI: " + dni + " | Deuda: " + deuda
                + " | Estado Socio: " + estado;
    }

}
