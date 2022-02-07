package Eclipse_Resuelto;

public class Test {
	
	public static void main(String[] args) {
		
		//Creamos el proceso de Eclipse
		Eclipse eclipse = new Eclipse(50);
		
		//Creamos proyecto "HolaMundo" y "THP_TP1"
		System.out.println(eclipse.agregarProyecto("HolaMundo"));
		System.out.println(eclipse.agregarProyecto("THP_TP1"));

		//Probamos compilar uno, debe dar error
		System.out.println(eclipse.compilarProyecto("HolaMundo"));
				
		//Agregamos metodos
		System.out.println(eclipse.agregarMetodo("HolaMundo", "ingresarNumero", 2));
		System.out.println(eclipse.agregarMetodo("THP_TP1", "main", 30));

		//Probamos compilar, debe poder compilar
		System.out.println(eclipse.compilarProyecto("HolaMundo"));
		
		//Probamos ejecutarlo, debe tirar ERROR_NO_HAY_MAIN
		System.out.println(eclipse.ejecutarProyecto("HolaMundo"));
		
		//Creamos metodo main en el proyecto
		System.out.println(eclipse.agregarMetodo("HolaMundo", "main", 3));

		//Probamos ejecutarlo, debe tirar EJECUTAR_OK
		System.out.println(eclipse.ejecutarProyecto("HolaMundo"));
		
		//Probamos ejecutarlo nuevamente, debe tirar ERROR_EN_EJECUCION
		System.out.println(eclipse.ejecutarProyecto("HolaMundo"));
		
		//Comprobamos proyectos en ejecucion
		eclipse.mostrarEnEjecucion();
		
		//Detenemos la ejecucion del proyecto
		System.out.println(eclipse.detenerProyecto("HolaMundo"));

		//Mostramos el listado de proyectos que pueden ser ejecutados
		eclipse.mostrarEjecutables();
		
		//Proyectos con menor capacidad en bytes
		System.out.println("*** Proyectos con menor capacidad en bytes ***");
		for(Proyecto p : eclipse.obtenerMinCapacidad()){
			System.out.println(p.getNombre());
		}

		//Proyectos con mayor cantidad de metodos
		System.out.println("*** Proyectos con mayor cantidad de metodos ***");
		for(Proyecto p : eclipse.obtenerMaxMetodos()){
			System.out.println(p.getNombre());
		}
		
		eclipse.mostrarPorVersion(0);
		eclipse.mostrarPorVersion(1);
		eclipse.mostrarPorVersion(2);
				
		//Probamos ejecutar el proyecto de THP_TP1, debe dar error por falta de RAM
		System.out.println(eclipse.ejecutarProyecto("THP_TP1"));
		
		eclipse.mostrarLog();

	}
}
