package TindORT;

public class Usuario {
	private String nombre;
	private String mail;
	private int edad;
	private Genero genero;
	private Genero generoDeseado;
	private int edadMinDeseada;
	private int edadMaxDeseada;
	

	public Usuario(String nombre, String mail, int edad, Genero genero, Genero generoDeseado, int edadMinDeseada,
			int edadMaxDeseada) {
		this.nombre = nombre;
		this.mail = mail;
		this.edad = edad;
		this.genero = genero;
		this.generoDeseado = generoDeseado;
		this.edadMinDeseada = edadMinDeseada;
		this.edadMaxDeseada = edadMaxDeseada;
	}
	

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public int getEdad() {
		return edad;
	}

	public Genero getGenero() {
		return genero;
	}

	public Genero getGeneroDeseado() {
		return generoDeseado;
	}

	public int getEdadMinDeseada() {
		return edadMinDeseada;
	}

	public int getEdadMaxDeseada() {
		return edadMaxDeseada;
	}

	public boolean mismoUsuario(String nombre, String mail) {
		return this.nombre.equals(nombre) && this.mail.equals(mail);
	}
	public boolean mismoMail(String mail) {
		return this.mail.equals(mail);
	}


	@Override
	public String toString() {
		return "Usuario nombre: " + nombre + " | mail: " + mail + " | edad: " + edad + " | genero: " + genero
				+ " | generoDeseado: " + generoDeseado + " | edadMinDeseada: " + edadMinDeseada + " | edadMaxDeseada: "
				+ edadMaxDeseada;
	}

	
	

	
	
	
}
