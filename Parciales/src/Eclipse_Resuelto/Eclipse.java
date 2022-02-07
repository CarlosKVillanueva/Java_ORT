package Eclipse_Resuelto;

import java.util.ArrayList;

public class Eclipse {

	private ArrayList<Proyecto> proyectos;
	private ArrayList<Historial> log;
	@SuppressWarnings("unused")
	private int cantidadMaxBytes;
	private int cantidadBytesDisponibles;

	public Eclipse(int cantidadMaxBytes) {
		proyectos = new ArrayList<>();
		log = new ArrayList<>();
		setCantidadMaxBytes(cantidadMaxBytes);
		cantidadBytesDisponibles = cantidadMaxBytes;
	}

	private void setCantidadMaxBytes(int cantidadMaxBytes) {
		this.cantidadMaxBytes = cantidadMaxBytes;
	}

	private Proyecto buscarProyecto(String nombre) {
		Proyecto proyecto = null;
		int i = 0;

		while (i < proyectos.size() && proyecto == null) {
			if (proyectos.get(i).mismoProyecto(nombre)) {
				proyecto = proyectos.get(i);
			} else {
				i++;
			}
		}

		return proyecto;
	}

	public boolean agregarProyecto(String nombre) {
		boolean pudeAgregar = false;

		if (buscarProyecto(nombre) == null) {
			proyectos.add(new Proyecto(nombre));
			pudeAgregar = true;
		}

		return pudeAgregar;
	}

	public boolean agregarMetodo(String nombreProyecto, String nombreMetodo, int cantidadInstrucciones) {
		boolean pudeAgregar = false;

		Proyecto proyecto = buscarProyecto(nombreProyecto);

		if (proyecto != null) {
			pudeAgregar = proyecto.agregarMetodo(nombreMetodo, cantidadInstrucciones);
		}
		return pudeAgregar;
	}

	public boolean compilarProyecto(String nombre) {
		boolean pudeCompilar = false;

		Proyecto proyecto = buscarProyecto(nombre);

		if (proyecto != null) {
			pudeCompilar = proyecto.compilar();
			log.add(new Historial(Accion.COMPILAR, nombre, proyecto.getVersionActual(),pudeCompilar));
		}

		return pudeCompilar;
	}

	private boolean puedeEjecutarse(int bytes) {
		return bytes <= cantidadBytesDisponibles;
	}

	public ResultadoEjecutar ejecutarProyecto(String nombre) {
		ResultadoEjecutar resultado = ResultadoEjecutar.ERROR_INEXISTENTE;

		Proyecto proyecto = buscarProyecto(nombre);
		if (proyecto != null) {
			if (!proyecto.isEjecucion()) {
				if (proyecto.isCompilado() || proyecto.compilar()) {
					if (proyecto.tieneMain()) {
						if (puedeEjecutarse(proyecto.getCantidadBytes())) {
							proyecto.ejecutar();
							cantidadBytesDisponibles -= proyecto.getCantidadBytes();
							resultado = ResultadoEjecutar.EJECUTAR_OK;
						} else {
							resultado = ResultadoEjecutar.ERROR_NO_HAY_RAM;
						}
					} else {
						resultado = ResultadoEjecutar.ERROR_NO_HAY_MAIN;
					}
				} else {
					resultado = ResultadoEjecutar.ERROR_NO_COMPILA;
				}
			} else {
				resultado = ResultadoEjecutar.ERROR_EN_EJECUCION;
			}
			log.add(new Historial(Accion.EJECUTAR, nombre, proyecto.getVersionActual(), resultado == ResultadoEjecutar.EJECUTAR_OK, resultado));
		}
		return resultado;
	}

	public boolean detenerProyecto(String nombre) {
		boolean pudeDetener = false;
		Proyecto proyecto = buscarProyecto(nombre);

		if (proyecto != null && proyecto.isEjecucion()) {
			proyecto.detener();
			cantidadBytesDisponibles += proyecto.getCantidadBytes();

			pudeDetener = true;
		}

		return pudeDetener;
	}

	public boolean borrarProyecto(String nombre) {
		boolean pudeBorrar = false;
		Proyecto proyecto = buscarProyecto(nombre);

		if (proyecto != null && !proyecto.isEjecucion()) {
			proyectos.remove(proyecto);
			pudeBorrar = true;
		}

		return pudeBorrar;
	}

	public void mostrarEnEjecucion() {
		if (proyectos.size() > 0) {
			System.out.println("*** Proyectos en ejecucion en el Eclipse ***");
			for (Proyecto proyecto : proyectos) {
				if (proyecto.isEjecucion()) {
					System.out.println(proyecto.getNombre());
				}
			}
		} else {
			System.out.println("No hay proyectos en el Eclipse");
		}
	}

	public ArrayList<Proyecto> obtenerMinCapacidad() {
		ArrayList<Proyecto> minCapacidad = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		if (proyectos.size() > 0) {
			for (Proyecto proyecto : proyectos) {
				if (proyecto.getCantidadBytes() < min) {
					minCapacidad.clear();
					minCapacidad.add(proyecto);
					min = proyecto.getCantidadBytes();
				} else if (proyecto.getCantidadBytes() == min) {
					minCapacidad.add(proyecto);
				}
			}
		} else {
			System.out.println("No hay proyectos en el Eclipse");
		}

		return minCapacidad;
	}

	public ArrayList<Proyecto> obtenerMaxMetodos() {
		ArrayList<Proyecto> maxMetodos = new ArrayList<>();
		int max = 0;

		if (proyectos.size() > 0) {
			for (Proyecto proyecto : proyectos) {
				if (proyecto.getCantidadMetodos() > max) {
					maxMetodos.clear();
					maxMetodos.add(proyecto);
					max = proyecto.getCantidadMetodos();
				} else if (proyecto.getCantidadMetodos() == max) {
					maxMetodos.add(proyecto);
				}
			}
		} else {
			System.out.println("No hay proyectos en el Eclipse");
		}

		return maxMetodos;
	}

	public void mostrarEjecutables() {
		if (proyectos.size() > 0) {
			System.out.println("*** Proyectos que pueden ser ejecutados ***");
			for (Proyecto proyecto : proyectos) {
				if (puedeEjecutarse(proyecto.getCantidadBytes()) && proyecto.isCompilado()) {
					System.out.println(proyecto.getNombre());
				}
			}
		} else {
			System.out.println("No hay proyectos en el Eclipse");
		}
	}

	public void mostrarPorVersion(int version) {
		if (proyectos.size() > 0) {
			System.out.println("*** Proyectos que estan en version " + version + " ***");
			for (Proyecto proyecto : proyectos) {
				if (proyecto.getVersionActual() == version) {
					System.out.println(proyecto.getNombre());
				}
			}
		} else {
			System.out.println("No hay proyectos en el Eclipse");
		}
	}
	
	public void mostrarLog() {
		for (Historial historial : log) {
			System.out.println(historial);
		}
	}

}
