package EclipsePasion;

public class Test {
    public static void main(String[] args) {

        Eclipse eclipse = new Eclipse(32);

        System.out.println(eclipse.agregarProyecto("Actividad1"));
        System.out.println(eclipse.agregarProyecto("Actividad2"));
        System.out.println(eclipse.agregarProyecto("Actividad3"));
        System.out.println(eclipse.agregarProyecto("Actividad4"));
        System.out.println(eclipse.agregarProyecto("Actividad4"));

        System.out.println(eclipse.agregarMetodoProyecto("Actividad1", "Metodo1", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad1", "Metodo2", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad1", "Metodo3", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad1", "Metodo3", 1));// FASLE

        System.out.println(eclipse.agregarMetodoProyecto("Actividad2", "Metodo1", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad2", "Main", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad2", "Metodo3", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad2", "Metodo4", 2));

        System.out.println(eclipse.agregarMetodoProyecto("Actividad3", "Metodo1", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad3", "Main", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad3", "Metodo5", 1));

        System.out.println(eclipse.agregarMetodoProyecto("Actividad4", "Metodo1", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad4", "Metodo2", 1));
        System.out.println(eclipse.agregarMetodoProyecto("Actividad4", "Main", 1));

        System.out.println("\nCOMPILAR");
        System.out.println(eclipse.compilar("Actividad1"));
        System.out.println(eclipse.compilar("Actividad1"));

        System.out.println("\n SIN MAIN");
        System.out.println(eclipse.ejecutarProyecto("Actividad1"));

        System.out.println("\n CON MAIN");
        System.out.println(eclipse.agregarMetodoProyecto("Actividad1", "Main", 1));

        System.out.println("\nMEMORIA");
        System.out.println(eclipse.ejecutarProyecto("Actividad1"));
        System.out.println("\nEJECUTAR EL EJECUTADO");
        System.out.println(eclipse.ejecutarProyecto("Actividad1"));

        System.out.println("\nRAM");
        System.out.println(eclipse.ejecutarProyecto("Actividad8"));
        System.out.println(eclipse.ejecutarProyecto("Actividad2"));
        System.out.println(eclipse.ejecutarProyecto("Actividad3"));
        System.out.println(eclipse.ejecutarProyecto("Actividad4"));

        eclipse.mostrarEnEjecucion();
        eclipse.mostrarLog();
        System.out.println(eclipse.obtenerMinCapacidad());
        System.out.println(eclipse.obtenerMaxMetodos());

    }

}
