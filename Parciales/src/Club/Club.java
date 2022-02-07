package Club;

import java.util.ArrayList;

public class Club {
    private String nombre;
    private static final int EDAD_SOCIO_MIN = 0, EDAD_SOCIO_MAX = 100;
    private ArrayList<Socio> socios;

    public Club(String nombre) {
        this.nombre = nombre;
        socios = new ArrayList<>();
    }

    /* -------------------------------- BUSQUEDA -------------------------------- */

    private Socio buscarSocio(String nombre) {
        Socio socioBuscado = null;
        int i = 0;

        while (i < socios.size() && socioBuscado == null) {
            if (socios.get(i).mismoNombre(nombre)) {
                socioBuscado = socios.get(i);
            } else {
                i++;
            }
        }
        return null;
    }

    /* --------------------------------- AGREGAR -------------------------------- */

    public Resultado agregarSocio(String nombre, int edad) {
        Resultado resultado = Resultado.ERROR;

        if (edad > EDAD_SOCIO_MIN && edad < EDAD_SOCIO_MAX && !nombre.isEmpty()) {
            socios.add(new Socio(nombre, edad));
            resultado = Resultado.OK;
        } else {
            resultado = Resultado.YA_EXISTE;
        }

        return resultado;
    }

    /* --------------------------- ESTABLECER AMISTAD --------------------------- */

    public Resultado establecerAmistad(String primerNombre, String segundoNombre) {
        Resultado resultado = Resultado.MISMA_PERSONA;

        if (!primerNombre.equals(segundoNombre)) {
            Socio primerSocio = buscarSocio(primerNombre);
            if (primerSocio != null) {
                Socio segundoSocio = buscarSocio(segundoNombre);
                if (segundoSocio != null) {
                    if (!primerSocio.esAmigo(segundoSocio)) {
                        primerSocio.establecerAmistad(segundoSocio);
                        segundoSocio.establecerAmistad(primerSocio);
                        resultado = Resultado.OK;
                    } else
                        resultado = Resultado.YA_SON_AMIGOS;
                } else
                    resultado = Resultado.NO_EXISTE;
            } else
                resultado = Resultado.NO_EXISTE;
        }
        return resultado;
    }

    public Resultado deshacerAmistad(String primerNombre, String segundoNombre) {
        Resultado resultado = Resultado.MISMA_PERSONA;

        if (!primerNombre.equals(segundoNombre)) {
            Socio primerSocio = buscarSocio(primerNombre);
            if (primerSocio != null) {
                Socio segundoSocio = buscarSocio(segundoNombre);
                if (segundoSocio != null) {
                    if (!primerSocio.esAmigo(segundoSocio)) {
                        primerSocio.deshacerAmistad(segundoSocio);
                        segundoSocio.deshacerAmistad(primerSocio);
                        resultado = Resultado.OK;
                    } else
                        resultado = Resultado.YA_SON_AMIGOS;
                } else
                    resultado = Resultado.NO_EXISTE;
            } else
                resultado = Resultado.NO_EXISTE;
        }
        return resultado;
    }

    @Override
    public String toString() {
        return "Club [Nombre: " + nombre + "]";
    }

}
