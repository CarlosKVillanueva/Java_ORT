package TindORT;

import java.util.ArrayList;

public class App {
	private String nombre;
	private ArrayList<Usuario> usuarios;
	
	
	public App(String nombre) {
		this.nombre = nombre;
		usuarios = new ArrayList<>();
	}


	//BUSQUEDA
	
	private Usuario buscarUsuario(String nombre, String mail) {
		Usuario usuarioADevolver = null;
		int i = 0, cantidadElem = usuarios.size();
		
		while (i < cantidadElem && usuarioADevolver == null) {
			if (usuarios.get(i).mismoUsuario(nombre, mail)) {
				usuarioADevolver = usuarios.get(i);
			}else {
				i++;
			}
		}
		return usuarioADevolver;
	}
	private Usuario buscarUsuario(String mail) {
		Usuario usuarioADevolver = null;
		int i = 0, cantidadElem = usuarios.size();
		
		while (i < cantidadElem && usuarioADevolver == null) {
			if (usuarios.get(i).mismoMail(mail)) {
				usuarioADevolver = usuarios.get(i);
			}else {
				i++;
			}
		}
		return usuarioADevolver;
	}
	
	
	//AGREGAR
	
	public boolean agregarUsuario(String nombre, String mail, int edad, Genero genero, Genero generoDeseado, int edadMinDeseada,
			int edadMaxDeseada) {
		boolean pudeAgregar = false;
		
		if (buscarUsuario(nombre, mail) == null) {
			usuarios.add(new Usuario(nombre, mail, edad, genero, generoDeseado, edadMinDeseada, edadMaxDeseada));
			pudeAgregar = true;
		}
		return pudeAgregar;
	}
	
	
	//METODOS
	
	
	private boolean verificarCoincidenciaParcial(Usuario usuario1, Usuario usuario2) {
		boolean coincidenciaParcial = false;

		if (usuario1.getGenero() == usuario2.getGeneroDeseado()) {
			if (usuario1.getEdadMinDeseada() <= usuario2.getEdad() && usuario1.getEdadMaxDeseada() >= usuario2.getEdad() ) {
				coincidenciaParcial = true;
			}
		}
		return coincidenciaParcial;
	}
	
	
	private boolean verificarCoincidenciaTotal(Usuario usuario1, Usuario usuario2) {
		return verificarCoincidenciaParcial(usuario1, usuario2) && verificarCoincidenciaParcial(usuario2, usuario1);
	
	}
	
	
	
	
	public ArrayList<Usuario> mostrarListado(String mail) {
		ArrayList<Usuario> listaADevolver = new ArrayList<>();
		
		Usuario usuarioQueBusca = buscarUsuario(mail);
		for (Usuario usuario : usuarios) {
			if (usuarioQueBusca != usuario) {
				if (verificarCoincidenciaTotal(usuarioQueBusca, usuario)) {
					listaADevolver.add(usuario);
				}
			}
		}
		return listaADevolver;
		
	}
	
	
	
	
	
	
	@Override
	public String toString() {
		return "App [nombre: " + nombre + " | usuarios: " + usuarios + "]";
	}
	
	
	
}
