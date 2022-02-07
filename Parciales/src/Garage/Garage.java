package Garage;

import java.util.ArrayList;

public class Garage {
    private String codigo;
    private Deuda deuda;
    private ArrayList<Vehiculo> vehiculos;

    /* --------------------- CONSTRUCTOR -------------------- */
    public Garage(String codigo, Deuda deuda) {
        this.codigo = codigo;
        this.deuda = deuda;
        vehiculos = new ArrayList<>();
    }

    /* ----------------------- GETTERS ---------------------- */
    public String getCodigo() {
        return codigo;
    }

    /* ----------------------- SETTERS ---------------------- */

    /* ----------------------- METODOS ---------------------- */
    private Vehiculo buscarVehiculo(String patente) {
        Vehiculo elementoBuscado = null;
        int i = 0, cantElementos = vehiculos.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (vehiculos.get(i).mismoVehiculo(patente)) {
                elementoBuscado = vehiculos.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public ResultadoEstacionar estacionarVehiculo(String patente) {
        ResultadoEstacionar resultado = ResultadoEstacionar.VEHICULO_NO_HABILITADO;
        Vehiculo vehiculo = buscarVehiculo(patente);

        if (vehiculo != null) {
            if (!vehiculo.estaEstacionado()) {
                if (!vehiculo.tieneDeudaMax()) {

                    resultado = ResultadoEstacionar.INGRESO_OK;
                    vehiculo.estacionar();
                    // vehiculos.add(vehiculo);
                } else {
                    resultado = ResultadoEstacionar.NO_ESTACIONA_ADEDUA;
                }
            } else {
                resultado = ResultadoEstacionar.VEHICULO_YA_ESTACIONADO;
            }
        }

        return resultado;
    }

    public boolean esPersonaAutorizada(String dni) {
        boolean estaAutorizada = false;
        int i = 0, cantVehiculos = vehiculos.size();

        while (i < cantVehiculos && !estaAutorizada) {
            estaAutorizada = vehiculos.get(i).estaAtutorizada(dni);
            i++;
        }

        return estaAutorizada;
    }

    public ArrayList<Deuda> obtenerInformeVehiculoConDeudas() {
        ArrayList<Deuda> informeVehiculos = new ArrayList<>();

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.tieneDeuda()) {
                informeVehiculos.add(new Deuda(vehiculo.getPatente(), vehiculo.getMesesDeuda()));
            }
        }

        return informeVehiculos;
    }

    public ResultadoEstacionar retirarVehiculo(String patente, String dni) {
        ResultadoEstacionar resultado = ResultadoEstacionar.VEHICULO_NO_HABILITADO;
        Vehiculo vehiculo = buscarVehiculo(patente);

        if (vehiculo != null) {
            if (vehiculo.estaEstacionado()) {
                if (vehiculo.estaAtutorizada(dni)) {
                    resultado = ResultadoEstacionar.RETIRO_OK;
                    vehiculo.retirar();
                    // vehiculos.remove(vehiculo);
                } else {
                    resultado = ResultadoEstacionar.NO_AUTORIZADO;
                }
            } else {
                resultado = ResultadoEstacionar.VEHICULO_YA_RETIRADO;
            }
        }

        return resultado;
    }

    public int getCantVehiculosEstacionados() {
        int contVehiculos = 0;

        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.estaEstacionado()) {
                contVehiculos++;
            }
        }

        return contVehiculos;
    }
    /* ---------------------- TO STRING --------------------- */

    @Override
    public String toString() {
        return "Garage [codigo=" + codigo + ", deuda=" + deuda + "]";
    }

}
