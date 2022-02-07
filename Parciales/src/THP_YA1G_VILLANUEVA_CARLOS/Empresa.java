package THP_YA1G_VILLANUEVA_CARLOS;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Formacion> formaciones;

    public Empresa(String nombre) {
        setNombre(nombre);
        formaciones = new ArrayList<>();
    }

    public void setNombre(String nombre) {
        if (!nombre.isEmpty()) {
            this.nombre = nombre;
        }
    }

    public int crearFormacion() {
        int numFormacionActual = 0;
        int cantElemFormaciones = formaciones.size();

        if (cantElemFormaciones == numFormacionActual) {
            Formacion formacionAgregada = new Formacion(1);
            formaciones.add(formacionAgregada);
            numFormacionActual++;

        } else {
            numFormacionActual = formaciones.get(cantElemFormaciones - 1).getNumeroFormacion();
            numFormacionActual++;

            Formacion formacionAgregada = new Formacion(numFormacionActual);

            formaciones.add(formacionAgregada);

        }
        return numFormacionActual;
    }

    public ResultadoAgregar agregarVagones(int numeroFormacion, int cantVagones, TipoVagon tipoVagon) {
        ResultadoAgregar resultado = ResultadoAgregar.NO_EXISTE_TREN;

        Formacion formacionBuscada = buscarFormacion(numeroFormacion);
        if (formacionBuscada != null) {
            if (formacionBuscada.validarCantidad(cantVagones)) {
                formacionBuscada.agregarVagones(cantVagones, tipoVagon);
                resultado = ResultadoAgregar.AGREGADO_OK;
            } else {
                resultado = ResultadoAgregar.CANT_VAGONES_INVALIDAD;
            }
        }

        return resultado;
    }

    private Formacion buscarFormacion(int numeroFormacion) {
        Formacion elementoBuscado = null;
        int i = 0, cantElementos = formaciones.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (formaciones.get(i).mismoFormacion(numeroFormacion)) {
                elementoBuscado = formaciones.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    // public double cargarTren(int numeroFormacion, double cantToneladas) {
    // double resultado = 0;
    // Formacion formacionBuscada = buscarFormacion(numeroFormacion);

    // if (formacionBuscada != null) {

    // resultado = formacionBuscada.cargarVagones(cantToneladas);
    // }

    // return resultado;
    // }

    @Override
    public String toString() {
        return "Empresa [nombre=" + nombre + "]";
    }

}