package LinkedIn;

import java.util.ArrayList;

public class LinkedIn {
    private String nombre;
    private ArrayList<Usuario> usuarios;

    public LinkedIn(String nombre) {
        this.nombre = nombre;
        usuarios = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Usuario buscarUsuario(String nombre) {
        Usuario usuarioBuscado = null;
        int i = 0;
        int cantidadElementos = usuarios.size();

        while (i < cantidadElementos && usuarioBuscado == null) {
            if (usuarios.get(i).mismoUsuario(nombre)) {
                usuarioBuscado = usuarios.get(i);
            } else {
                i++;
            }
        }
        return usuarioBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarUsuario(String nombre) {
        boolean seAgrego = false;
        Usuario usarioAgregar = buscarUsuario(nombre);

        if (usarioAgregar == null) {
            usuarios.add(new Usuario(nombre));
            seAgrego = true;
        }
        return seAgrego;
    }

    /* -------------------- AGREGAR AMIGO ------------------- */

    public ResultadoAgregarAmigo agregarAmigo(String nombreUsuario, String nombreAmigo) {
        ResultadoAgregarAmigo resultado = ResultadoAgregarAmigo.ERROR_USUARIO_INEXISTENTE;

        Usuario usuario = buscarUsuario(nombreUsuario);

        if (usuario != null) {

            if (!nombreUsuario.equals(nombreAmigo)) {

                Usuario amigo = buscarUsuario(nombreAmigo);

                if (amigo != null) {

                    if (usuario.esAmigo(nombreAmigo)) {
                        usuario.agregarAmigo(nombreAmigo);
                        amigo.agregarAmigo(nombreUsuario);
                        resultado = ResultadoAgregarAmigo.AGREGAR_OK;
                    } else {
                        resultado = ResultadoAgregarAmigo.ERROR_YA_ERA_AMIGO;
                    }
                    // if (!usuarioBuscado.esAmigo(amigoBuscado)) {
                    // usuarioBuscado.agregarAmigo(nombreAmigo);
                    // amigoBuscado.agregarAmigo(nombreUsuario);
                    // resultado = ResultadoAgregarAmigo.AGREGAR_OK;
                    // } else {
                    // resultado = ResultadoAgregarAmigo.ERROR_YA_ERA_AMIGO;
                    // }
                } else {
                    resultado = ResultadoAgregarAmigo.ERROR_AMIGO_INEXISTENTE;
                }
            } else {
                resultado = ResultadoAgregarAmigo.ERROR_MISMO_USUARIO;
            }
        }

        return resultado;
    }

    public ResultadoGradoAmistad obteneGradoAmistad(String nombreUsuario, String nombreAmigo) {
        ResultadoGradoAmistad grado = ResultadoGradoAmistad.USUARIO_INEXISTENTE;
        Usuario usuario = buscarUsuario(nombreUsuario);

        if (usuario != null) {

            Usuario amigo = buscarUsuario(nombreAmigo);

            if (amigo != null) {

                if (!usuario.esAmigo(nombreAmigo)) {
                    grado = ResultadoGradoAmistad.GRADO_1;
                } else {
                    if (usuario.esAmigoDeAlguien(nombreAmigo) != null) {
                        grado = ResultadoGradoAmistad.GRADO_2;
                    } else {
                        grado = ResultadoGradoAmistad.GRADO_3;
                    }
                }
            }
        }
        return grado;
    }

    @Override
    public String toString() {
        return "LinkedIn [nombre=" + nombre + "]";
    }

}
