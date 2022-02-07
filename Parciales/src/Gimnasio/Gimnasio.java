package Gimnasio;

import java.util.ArrayList;

public class Gimnasio {
    private String razonSocial;
    private int cantSocios;
    private ArrayList<Socio> socios;

    public Gimnasio(String razonSocial) {
        this.razonSocial = razonSocial;
        this.cantSocios = 0;
        this.socios = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Socio buscarSocio(int dni) {
        Socio elementoBuscado = null;
        int i = 0, cantElementos = socios.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (socios.get(i).mismoSocio(dni)) {
                elementoBuscado = socios.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    public Resultado agregarSocio(int dni, String nombre, int categoria, double deuda) {
        Resultado resultado = Resultado.EL_SOCIO_YA_EXISTE;
        if (buscarSocio(dni) == null) {
            socios.add(new Socio(dni, nombre, categoria, deuda));
            cantSocios++;
            resultado = Resultado.SOCIO_AGREGADO_CON_EXITO;
        }

        return resultado;
    }

    public Resultado quitarSocio(int dni) {
        Resultado resultado = Resultado.NO_EXISTE_EL_SOCIO;
        Socio socio = buscarSocio(dni);

        if (socio != null) {
            if (!socio.esDeudor()) {
                socios.remove(socio);
                this.cantSocios--;
                resultado = Resultado.SOCIO_DADO_DE_BAJA;
            } else {
                resultado = Resultado.EL_SOCIO_TIENE_DEUDA;
            }
        }

        return resultado;
    }

    public void listarDeudoresCategoria(double monto, int categoria) {
        System.out.println("\n*** LISTADO DEUDORES ***");
        System.out.println("Categoria: " + categoria + " | Monto: $" + monto);
        for (Socio socio : socios) {

            if (socio.controlDueda(monto) && socio.controCategoria(categoria)) {
                System.out.println(socio);
            }
        }
    }

    public void listarSocios() {
        System.out.println("\n*** LISTADO SOCIOS ***");

        for (Socio socio : socios) {

            System.out.println(socio);

        }
    }

    public void ponerMoroso(int dni) {
        Socio socio = buscarSocio(dni);
        if (socio.esDeudor() && socio != null && socio.setEstado(Estado.MOROSO)) {
            System.out.println(Resultado.CAMBIO_DE_ESTADO_EN_SOCIO);
        } else {
            System.out.println(Resultado.NO_SE_CAMBIO_EL_ESTADO);
        }
    }

    @Override
    public String toString() {
        return "Gimnasio [cantSocios=" + cantSocios + ", razonSocial=" + razonSocial + "]";
    }

}
