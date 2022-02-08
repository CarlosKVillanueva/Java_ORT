import java.util.ArrayList;

public class Vacunatorio {
    private static int ultimoNumSerie;
    private String nombre;
    private ArrayList<Vacuna> vacunasDisponibles;
    private Marca marca;

    public Vacunatorio(String nombre, Marca marca, int cantidad) {

        this.nombre = nombre;

        this.marca = marca;

        this.vacunasDisponibles = new ArrayList<>();

        agregarLote(cantidad);

    }

    public void agregarLote(int cantidad) {

        for (int i = 0; i < cantidad; i++) {

            vacunasDisponibles.add(new Vacuna(marca, ultimoNumSerie++));

        }

    }

    public Vacuna buscarVacuna(Marca marca) {
        Vacuna elementoBuscado = null;
        int i = 0, cantElementos = vacunasDisponibles.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (vacunasDisponibles.get(i).getMarca() == marca) {
                elementoBuscado = vacunasDisponibles.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean mismoVacunatorio(String nombre) {
        return this.nombre.equals(nombre);
    }

    public ArrayList<Vacuna> getVacunasDisponibles() {
        return this.vacunasDisponibles;
    }
}
