package TindORT;

public class Main {

	public static void main(String[] args) {
		App app = new App("Tindort");
		
		
		app.agregarUsuario("Juan", "juan@mail.com",30, Genero.MASCULINO,Genero.FEMENINO,25,35);
		app.agregarUsuario("Carlos", "carlos@mail.com",45, Genero.MASCULINO,Genero.FEMENINO,30,50);
		app.agregarUsuario("Carlos", "carlos@mail.com",45, Genero.MASCULINO,Genero.FEMENINO,30,50);
		app.agregarUsuario("Maria", "maria@mail.com",28, Genero.FEMENINO,Genero.MASCULINO,30,40);
		app.agregarUsuario("Ana", "ana@mail.com",32, Genero.FEMENINO,Genero.MASCULINO,28,42);
		app.agregarUsuario("Eva", "eva@mail.com",32, Genero.FEMENINO,Genero.MASCULINO,40,50);
		
		
		/*
		Usuario usuario1 = new Usuario("Juan", "juan@mail.com",30, Genero.MASCULINO,Genero.FEMENINO,25,35);
		Usuario usuario2 = new Usuario("Ana", "ana@mail.com",36, Genero.FEMENINO,Genero.MASCULINO,28,42);
		
		System.out.println(app.verificarCoincidenciaParcial(usuario1, usuario2));
		System.out.println(app.verificarCoincidenciaTotal(usuario1, usuario2));
		
		*/
		System.out.println("COINCIDENCIAS DE JUAN");
		System.out.println(app.mostrarListado("juan@mail.com"));
		System.out.println("COINCIDENCIAS DE CARLOS");
		System.out.println(app.mostrarListado("carlos@mail.com"));
	}

}
