package LinkedIn;

public class Test {
    public static void main(String[] args) {
        LinkedIn linkeIn = new LinkedIn("PIJAS");

        // Agregamos los usuarios a la aplicación
        System.out.println(linkeIn.agregarUsuario("binker"));
        System.out.println(linkeIn.agregarUsuario("espinosa"));
        System.out.println(linkeIn.agregarUsuario("espinosa"));
        System.out.println(linkeIn.agregarUsuario("contente"));
        System.out.println(linkeIn.agregarUsuario("rabinovich"));
        // Establecemos las relaciones de amistad
        System.out.println(linkeIn.agregarAmigo("binker", "espinosa"));
        System.out.println(linkeIn.agregarAmigo("espinosa", "contente"));
        // Comprobamos grados de amistad
        System.out.println(linkeIn.obteneGradoAmistad("binker", "espinosa"));
        System.out.println(linkeIn.obteneGradoAmistad("binker", "contente"));
        System.out.println(linkeIn.obteneGradoAmistad("binker", "rabinovich"));

    }
}
