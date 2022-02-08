package FP_YA1G_VILLANUEVA_CARLOS;

import java.util.ArrayList;

public class Empresa {
    private static final int LOCOMOTORA_MIN = 1;
    private String nombre;
    private ArrayList<Tren> trenesCompletos;
    private ArrayList<Maquinista> maquinistas;
    private ArrayList<Vagon> vagones;

    public Empresa(String nombre) {
        this.nombre = nombre;
        trenesCompletos = new ArrayList<>();
        maquinistas = new ArrayList<>();
        vagones = new ArrayList<>();

    }

    private Maquinista buscarMaquinista(String dni) {
        Maquinista elementoBuscado = null;
        int i = 0, cantElementos = maquinistas.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (maquinistas.get(i).mismoDni(dni)) {
                elementoBuscado = maquinistas.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public boolean agregarMaquinista(String nombre, String dni) {
        boolean agregado = false;

        Maquinista maquinista = buscarMaquinista(dni);

        if (maquinista == null) {
            maquinistas.add(new Maquinista(nombre, dni));
            agregado = true;
        }

        System.out.println(agregado ? "Se Agrego Maquinista" : "No se Agrego");
        return agregado;
    }

    /*
     * private Vagon buscarVagones(String numeroSerie) { Vagon elementoBuscado =
     * null; int i = 0, cantElementos = vagones.size();
     * 
     * while (i < cantElementos && elementoBuscado == null) { if
     * (vagones.get(i).mismoVagon(numeroSerie)) { elementoBuscado = vagones.get(i);
     * } else { i++; } } return elementoBuscado; }
     */
    public void agregarVagones(int cantidadVagones, TipoVagon tipo) {

        int i = 0;

        for (i = 0; i < cantidadVagones; i++) {
            vagones.add(new Vagon(Vagon.numeroVagon(), tipo, false));
        }

        System.out.println(vagones.size() != 0 ? "Se Agregaron " + cantidadVagones + " Vagones. Tipo " + tipo
                : "No se agregaron Vagones");

    }

    public Tren armarTren(int vagonesPasajeros, int vagonesCarga, String destino, String dni) {
        Maquinista maquinista = buscarMaquinista(dni);
        ArrayList<Vagon> locomotora = new ArrayList<>();
        ArrayList<Vagon> pasajeros = new ArrayList<>();
        ArrayList<Vagon> cargueros = new ArrayList<>();
        ArrayList<Vagon> formacionNueva = new ArrayList<>();
        Tren formacionCompleta = null;

        boolean cantLocoOK = cantidadVagones(TipoVagon.LOCOMOTARA) >= LOCOMOTORA_MIN;
        boolean cantCargaOK = cantidadVagones(TipoVagon.CARGA) >= vagonesCarga;
        boolean cantPasaOK = cantidadVagones(TipoVagon.PASAJEROS) >= vagonesPasajeros;

        if (maquinista != null && maquinista.getTren() == null && cantLocoOK && cantCargaOK && cantPasaOK) {

            locomotora = moverVagonesOk(TipoVagon.LOCOMOTARA, LOCOMOTORA_MIN);
            pasajeros = moverVagonesOk(TipoVagon.PASAJEROS, vagonesPasajeros);
            cargueros = moverVagonesOk(TipoVagon.CARGA, vagonesCarga);

            formacionNueva = unirVagones(locomotora, pasajeros, cargueros);

            formacionCompleta = new Tren(destino, maquinista, formacionNueva);
        }

        trenesCompletos.add(formacionCompleta);
        return formacionCompleta;
    }

    public void mostrarTrenes() {
        for (Tren tren : trenesCompletos) {
            System.out.println("*** Tren ***");
            tren.mostrarVagones();
        }
    }

    private ArrayList<Vagon> unirVagones(ArrayList<Vagon> locomotora, ArrayList<Vagon> pasajeros,
            ArrayList<Vagon> cargueros) {

        for (Vagon vagon : pasajeros) {
            locomotora.add(vagon);
        }
        for (Vagon vagon : cargueros) {
            locomotora.add(vagon);
        }

        return locomotora;
    }

    public ArrayList<Vagon> moverVagonesOk(TipoVagon tipo, int cantVagones) {

        ArrayList<Vagon> vagonesMover = new ArrayList<>();
        int i = 0, contador = 0;

        while (i < vagones.size() && contador < cantVagones) {

            if (vagones.get(i).controlarTipo(tipo) && !vagones.get(i).enRepacion()) {

                vagonesMover.add(vagones.get(i));
                vagones.remove(i);
                contador++;

            } else {
                i++;
            }
        }

        return vagonesMover;
    }

    public int cantidadVagones(TipoVagon tipo) {
        int cantVagones = 0;

        for (Vagon vagon : vagones) {

            if (vagon.controlarTipo(tipo) && !vagon.enRepacion()) {
                cantVagones++;
            }
        }
        return cantVagones;
    }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }
}
