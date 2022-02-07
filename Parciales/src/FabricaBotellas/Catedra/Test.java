package FabricaBotellas.Catedra;

public class Test {

	public static void main(String[] args) {
		Fabrica kokicole = new Fabrica(50);
		
		fabricar(kokicole, 40);
		fabricar(kokicole, 10);

		enviarBotellas(kokicole);

		fabricar(kokicole, 40);
		fabricar(kokicole, 10);
		
		fabricar(kokicole, 10);
		fabricar(kokicole, 10);
		fabricar(kokicole, 10);

	}
	
	static void fabricar(Fabrica fabrica, int cantidad) {
		System.out.println("Se fabricaron : " + fabrica.fabricar(cantidad));
	}
	
	static void enviarBotellas(Fabrica fabrica) {
		System.out.println("Se enviaron : " + fabrica.enviarBotellas());
	}

}
