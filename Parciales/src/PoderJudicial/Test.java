package PoderJudicial;

public class Test {
    public static void main(String[] args) {
        Provincia provincia = new Provincia("CABA");
        Domicilio domicilio = new Domicilio("Yatay 240", "1426", provincia);
        Domicilio domicilio2 = new Domicilio("Olmos 180", "1832", provincia);
        Domicilio domicilio3 = new Domicilio("Tuvo 42", "1426", provincia);

        Padron padron = new Padron();

        System.out.println(padron.agregarEscuela("Media1", 3, domicilio));
        System.out.println(padron.agregarEscuela("Media2", 3, domicilio2));
        System.out.println(padron.agregarEscuela("Media3", 3, domicilio3));

        System.out.println(padron.agregarMesaEscuela("Media1", 1));
        System.out.println(padron.agregarMesaEscuela("Media1", 2));
        System.out.println(padron.agregarMesaEscuela("Media1", 3));
        System.out.println(padron.agregarMesaEscuela("Media1", 4));

        System.out.println(padron.agregarMesaEscuela("Media2", 1));
        System.out.println(padron.agregarMesaEscuela("Media2", 2));
        System.out.println(padron.agregarMesaEscuela("Media2", 3));

        System.out.println(padron.agregarMesaEscuela("Media3", 1));
        System.out.println(padron.agregarMesaEscuela("Media3", 2));
        System.out.println(padron.agregarMesaEscuela("Media3", 3));

        System.out.println("\nAgregar Vot");

        System.out.println(
                padron.agregarVotanteMesa("Media1", 1, "123", true, "Kaio", "Villa", "20/04", Genero.MASCULINO));
        System.out.println(
                padron.agregarVotanteMesa("Media1", 1, "456", false, "Anto", "Mico", "20/04", Genero.FEMENINO));
        System.out.println(
                padron.agregarVotanteMesa("Media1", 1, "789", false, "Facu", "Aliverti", "20/04", Genero.OTRO));

        System.out.println(
                padron.agregarVotanteMesa("Media1", 2, "987", false, "Kaio2", "Villa", "20/04", Genero.MASCULINO));
        System.out.println(
                padron.agregarVotanteMesa("Media1", 2, "654", false, "Anto2", "Mico", "20/04", Genero.FEMENINO));
        System.out.println(
                padron.agregarVotanteMesa("Media1", 2, "789", false, "Facu2", "Aliverti", "20/04", Genero.OTRO));

    }
}
