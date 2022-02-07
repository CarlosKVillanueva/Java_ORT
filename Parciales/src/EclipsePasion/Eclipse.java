package EclipsePasion;

import java.util.ArrayList;

public class Eclipse {
	private int cantMaxBytes;
	private ArrayList<Proyecto> proyectos;
	private ArrayList<Log> logHistorico;

	public Eclipse(int cantMaxBytes) {
		this.cantMaxBytes = cantMaxBytes;
		proyectos = new ArrayList<>();
		logHistorico = new ArrayList<>();
	}

	/* ---------------------- BUSQUEDA ---------------------- */

	private Proyecto buscarProyecto(String nombre) {
		Proyecto elementoBuscado = null;
		int i = 0, cantElementos = proyectos.size();

		while (i < cantElementos && elementoBuscado == null) {
			if (proyectos.get(i).mismoProyecto(nombre)) {
				elementoBuscado = proyectos.get(i);
			} else {
				i++;
			}
		}
		return elementoBuscado;
	}

	/* ---------------------- AGREGADO ---------------------- */

	public boolean agregarProyecto(String nombre) {
		boolean seAgrego = false;
		Proyecto proyectoBuscado = buscarProyecto(nombre);

		if (proyectoBuscado == null) {
			proyectos.add(new Proyecto(nombre));
			seAgrego = true;
		}

		return seAgrego;
	}

	public boolean agregarMetodoProyecto(String nombre, String nombreMetodo, int cantInst) {
		boolean seAgrego = false;

		Proyecto proyectoBuscado = buscarProyecto(nombre);

		if (proyectoBuscado != null) {

			seAgrego = proyectoBuscado.agregarMetodo(nombreMetodo, cantInst);

		}

		return seAgrego;
	}

	/* ----------------------- METODOS ---------------------- */

	public boolean compilar(String nombre) {
		boolean seCompilo = false;

		Proyecto proyectoCompilar = buscarProyecto(nombre);

		if (proyectoCompilar != null) {
			seCompilo = proyectoCompilar.compilar();
			if (seCompilo) {
				logHistorico.add(new Log(proyectoCompilar, Ejecucion.COMPILA_OK));
			} else
				logHistorico.add(new Log(proyectoCompilar, Ejecucion.ERROR_NO_COMPILA));
		}

		return seCompilo;
	}

	public Ejecucion ejecutarProyecto(String nombre) {
		Ejecucion resultado = Ejecucion.ERROR_INEXISTENTE;

		Proyecto proyectoEjecutar = buscarProyecto(nombre);

		if (proyectoEjecutar != null) {
			if (proyectoEjecutar.compilar()) {
				if (proyectoEjecutar.buscarMain()) {
					if (cantMaxBytes > ramEnUso()) {
						if (!proyectoEjecutar.enEjecucion()) {
							proyectoEjecutar.setEjecucion(true);
							resultado = Ejecucion.EJECUTAR_OK;
							logHistorico.add(new Log(proyectoEjecutar, Ejecucion.EJECUTAR_OK));
						} else {
							resultado = Ejecucion.ERROR_EN_EJECUCION;
							logHistorico.add(new Log(proyectoEjecutar, Ejecucion.ERROR_EN_EJECUCION));
						}
					} else {
						resultado = Ejecucion.ERROR_NO_HAY_RAM;
						logHistorico.add(new Log(proyectoEjecutar, Ejecucion.ERROR_NO_HAY_RAM));
					}
				} else {
					resultado = Ejecucion.ERROR_NO_HAY_MAIN;
					logHistorico.add(new Log(proyectoEjecutar, Ejecucion.ERROR_NO_HAY_MAIN));
				}
			} else {
				resultado = Ejecucion.ERROR_NO_COMPILA;
			}
		}
		return resultado;
	}

	private int ramEnUso() {
		int ramEnUso = 0;
		for (Proyecto proyecto : proyectos) {

			if (proyecto.enEjecucion()) {
				ramEnUso += proyecto.ramEnUso();
			}
		}
		return ramEnUso;
	}

	public boolean detenerProyecto(String nombre) {
		boolean seDetuvo = false;

		Proyecto proyectoBuscado = buscarProyecto(nombre);

		if (proyectoBuscado != null && proyectoBuscado.enEjecucion()) {
			proyectoBuscado.setEjecucion(false);
			seDetuvo = true;
		}

		return seDetuvo;
	}

	public void borrarProyecto(String nombre) {
		Proyecto proyectoBuscado = buscarProyecto(nombre);

		if (proyectoBuscado != null && !proyectoBuscado.enEjecucion()) {
			proyectos.remove(proyectoBuscado);
		}
	}

	public void mostrarEnEjecucion() {
		for (Proyecto proyecto : proyectos) {
			if (proyecto.enEjecucion()) {
				System.out.println(proyecto.getNombre());
			}
		}
	}

	public ArrayList<Proyecto> obtenerMinCapacidad() {
		ArrayList<Proyecto> minimos = new ArrayList<>();
		int minRam = Integer.MAX_VALUE;

		for (Proyecto proyecto : proyectos) {

			if (proyecto.ramEnUso() < minRam) {
				minimos.clear();
				minRam = proyecto.ramEnUso();
				minimos.add(proyecto);
			} else if (proyecto.ramEnUso() == minRam) {
				minimos.add(proyecto);
			}
		}

		return minimos;
	}

	public ArrayList<Proyecto> obtenerMaxMetodos() {
		ArrayList<Proyecto> maxMetodos = new ArrayList<>();

		int maxCantMet = Integer.MIN_VALUE;

		for (Proyecto p : proyectos) {

			if (p.contadorMetodos() > maxCantMet) {
				maxMetodos.clear();
				maxCantMet = p.contadorMetodos();
				maxMetodos.add(p);
			} else if (p.contadorMetodos() == maxCantMet) {
				maxMetodos.add(p);
			}

		}

		return maxMetodos;

	}

	/* ----------------- MOSTRAR EJECUTABLES ---------------- */

	public void mostrarEjecutables() {

		for (Proyecto proyecto : proyectos) {
			if (proyecto.isCompilado() && ((cantMaxBytes - ramEnUso()) >= ramParaCompilar())) {
				System.out.println(proyecto.getNombre());
			}
		}

	}

	private int ramParaCompilar() {
		int acumRam = 0;

		for (Proyecto proyecto : proyectos) {
			if (proyecto.isCompilado() && !proyecto.enEjecucion()) {
				acumRam += proyecto.ramEnUso();
			}
		}

		return acumRam;
	}

	/* ----------------- MOSTRAR POR VERSION ---------------- */
	public void mostrarPorVersion(int version) {

		for (Proyecto proyecto : proyectos) {
			if (version == proyecto.getVersion()) {
				System.out.println(proyecto.getNombre());
			}
		}

	}

	/* --------------------- MOSTRAR LOG -------------------- */

	public void mostrarLog() {

		for (Log log : logHistorico) {
			System.out.println(log);
		}

	}

	/* ---------------------- TO STRING --------------------- */

	@Override
	public String toString() {
		return "Eclipse cantMaxBytes: " + cantMaxBytes + " | proyectos: " + proyectos;
	}

}
