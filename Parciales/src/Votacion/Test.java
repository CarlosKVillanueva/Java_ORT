package Votacion;

public class Test {

	public static void main(String[] args) {
		Camara camara = new Camara("DiPuTa2", 10);
		
		
		System.out.println("*** AGREGAR ***");
		
		camara.agregarVotante(123, "Kaio");
		camara.agregarVotante(123, "Kaio");
		camara.agregarVotante(456, "Pablo");
		camara.agregarVotante(789, "Noe");
		camara.agregarVotante(147, "Marta");
		camara.agregarVotante(258, "Colo");
		camara.agregarVotante(369, "Anto");
		camara.agregarVotante(741, "Facu");
		camara.agregarVotante(852, "Maxi");
		camara.agregarVotante(963, "Juan");
		camara.agregarVotante(159, "Kaio");
		camara.agregarVotante(123, "Kaio");
		
		
		System.out.println("*** VOTACION ***");
		
		camara.votar(123, "Kaio",ValorVoto.POSITIVO);
		camara.votar(123, "Kaio",ValorVoto.POSITIVO);
		camara.votar(456, "Pablo",ValorVoto.POSITIVO);
		camara.votar(147, "Marta",ValorVoto.POSITIVO);
		camara.votar(258, "Colo",ValorVoto.NEGATIVO);
		camara.votar(369, "Anto",ValorVoto.ABSTENCION);
		camara.votar(741, "Facu",ValorVoto.POSITIVO);
		camara.votar(852, "Maxi",ValorVoto.ABSTENCION);
		
		camara.votar(753, "Tuvi", ValorVoto.POSITIVO);
		
		
		camara.resultadoVotacion();
		
		
	}
	

}
