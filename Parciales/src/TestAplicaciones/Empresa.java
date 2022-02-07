package TestAplicaciones;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Prueba> pruebas;
    private ArrayList<Aplicacion> aplicaciones;

    public Empresa(String nombre) {
        this.nombre = nombre;
        pruebas = generarPruebas();
        aplicaciones = generarAplicaciones();
    }

    private ArrayList<Aplicacion> generarAplicaciones() {
        aplicaciones = new ArrayList<Aplicacion>();

        for (int i = 0; i < 5; i++) {
            aplicaciones.add(new Aplicacion());
        }

        return aplicaciones;
    }

    private ArrayList<Prueba> generarPruebas() {
        pruebas = new ArrayList<Prueba>();
        for (int i = 0; i < 5; i++) {
            pruebas.add(new Prueba());
        }
        return pruebas;
    }

    public void realizarTest(Tester tester) {
        tester.realizarTest(pruebas, aplicaciones.get(0));
    }

    public void mostrarLog(Tester tester) {
        tester.mostrarResultado();
    }

    @Override
    public String toString() {
        return "Empresa [aplicaciones=" + aplicaciones + ", nombre=" + nombre + ", pruebas=" + pruebas + "]";
    }

}
