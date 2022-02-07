package TestAplicaciones;

public class Historico {
    private String nombre;
    private String version;
    private Resultado resultado;

    public Historico(String nombre, String version, Resultado resultado) {
        this.nombre = nombre;
        this.version = version;
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Log =>  Nombre: " + nombre + " | Resultado Prueba: " + resultado + " | Version App: " + version;
    }

}
