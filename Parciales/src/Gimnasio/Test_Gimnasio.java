package Gimnasio;

public class Test_Gimnasio {
    
	public static void main(String[] args) {
		Gimnasio gym = new Gimnasio("TROLORT");

        System.out.println("\nAgregado Socios\n");
        System.out.println(gym.agregarSocio(123, "Kaio", 1, 0));
        System.out.println(gym.agregarSocio(456, "Facu", 2, 0));
        System.out.println(gym.agregarSocio(789, "Juan", 3, 100));
        System.out.println(gym.agregarSocio(987, "Mariano", 1, 0));
        System.out.println(gym.agregarSocio(654, "Maxi", 3, 100));
        System.out.println(gym.agregarSocio(423, "Naty", 3, 0));
        System.out.println(gym.agregarSocio(657, "QL", 1, 80));
        System.out.println(gym.agregarSocio(657, "QL", 1, 80));

        gym.listarSocios();

        System.out.println("\n*** Cambiar Estado Socios ***");
        gym.ponerMoroso(657);
        gym.ponerMoroso(789);
        gym.ponerMoroso(654);
        gym.ponerMoroso(654);

        gym.listarSocios();

        gym.listarDeudoresCategoria(80, 1);
        gym.listarDeudoresCategoria(80, 3);
    }
}
