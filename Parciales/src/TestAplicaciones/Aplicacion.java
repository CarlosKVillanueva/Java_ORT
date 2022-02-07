package TestAplicaciones;

public class Aplicacion {
    private String nombre;
    private String version;
    private static int numeradorApp = 0;

    public Aplicacion() {
        this.nombre = genNombre();
        this.version = "1.0";
    }

    private String genNombre() {
        return "Aplicación_" + ++Aplicacion.numeradorApp;
    }

    @Override
    public String toString() {
        return "Aplicacion [nombre=" + nombre + ", version=" + version + "]";
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getVersion() {
        return this.version;
    }

}
