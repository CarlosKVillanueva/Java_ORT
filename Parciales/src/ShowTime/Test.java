package ShowTime;

public class Test {

    public static void main(String[] args) {

        Empresa empresa = new Empresa("EL SHOW DE FACA");
        Fecha fecha = new Fecha(12, 12, 12);
        Hora hora = new Hora(12, 12);

        System.out.println(empresa.agregarEspectaculo("ANTO", TipoObra.RECITAL, fecha, hora));
        System.out.println(empresa.agregarEspectaculo("FACU", TipoObra.OBRA_TEATRAL, fecha, hora));
        System.out.println(empresa.agregarEspectaculo("KAIO", TipoObra.STANDUP, fecha, hora));

        System.out.println(empresa.agregarEspectadorEspectaculo("ANTO", "Juan", "Doe", "123456", 100));
        System.out.println(empresa.agregarEspectadorEspectaculo("ANTO", "Jane", "Doe", "654321", 100));
        System.out.println(empresa.agregarEspectadorEspectaculo("ANTO", "Nauj", "Doe", "741852", 100));
//        System.out.println(empresa.agregarEspectadorEspectaculo("ANTO", "Jane", "Doe", "654321", 900));

        System.out.println(empresa.agregarEspectadorEspectaculo("FACU", "Un", "Trolo", "696969", 200));
        System.out.println(empresa.agregarEspectadorEspectaculo("FACU", "Nauj", "Doe", "963258", 100));

        System.out.println(empresa.agregarEspectadorEspectaculo("KAIO", "Tuvi", "Eja", "789654", 100));

        System.out.println("");
        System.out.println(empresa.obtenerEspectaculos());
        System.out.println("BUSCAR");
        System.out.println(empresa.existeEspectador("123456"));
        System.out.println(empresa.existeEspectador("654321"));
        System.out.println(empresa.existeEspectador("741852"));
        System.out.println(empresa.existeEspectador("696969"));
        System.out.println(empresa.existeEspectador("963258"));
        System.out.println(empresa.existeEspectador("789654"));
        System.out.println(empresa.existeEspectador("7896544"));

    }
}
