package EclipsePasion;

import java.util.ArrayList;

public class Proyecto {
	private String nombre;
	private boolean compilado;
	private boolean ejecucion;
	private int version;
	private ArrayList<Metodo> metodos;

	public Proyecto(String nombre) {
		this.nombre = nombre;
		this.compilado = false;
		this.ejecucion = false;
		this.version = 0;
		metodos = new ArrayList<>();
	}

	/* ---------------------- BUSQUEDA ---------------------- */

	private Metodo buscarMetodo(String nombre) {
		Metodo metodoABuscar = null;
		int i = 0, cantidadElem = metodos.size();

		while (i < cantidadElem && metodoABuscar == null) {
			if (metodos.get(i).mismoMetodo(nombre)) {
				metodoABuscar = metodos.get(i);
			} else {
				i++;
			}
		}
		return metodoABuscar;
	}

	/* ----------------------- AGREGAR ---------------------- */

	public boolean agregarMetodo(String nombre, int cantInst) {
		boolean seAgrego = false;
		Metodo metodoBuscado = buscarMetodo(nombre);

		if (metodoBuscado == null) {
			compilado = false;
			metodos.add(new Metodo(nombre, cantInst));
			seAgrego = true;
		}

		return seAgrego;
	}

	/* ----------------------- METODOS ---------------------- */

	public boolean buscarMain() {
		return buscarMetodo("Main") != null;
	}

	public boolean compilar() {
		boolean seCompilo = false;

		if (metodos.size() > 0) {
			seCompilo = true;
			version++;
			compilado = true;
		}

		return seCompilo;
	}

	public int contadorMetodos() {
		return metodos.size();
	}

	public int ramEnUso() {
		int acumRam = 0;
		for (Metodo metodo : metodos) {
			acumRam += (metodo.getCantInstrucciones() * 4);
		}
		return acumRam;
	}

	public boolean mismoProyecto(String nombre) {

		return this.nombre.equals(nombre);
	}

	/* ----------------------- GETTERS ---------------------- */

	public String getNombre() {
		return nombre;
	}

	public int getVersion() {
		return version;
	}

	public boolean isCompilado() {
		return compilado;
	}

	public boolean enEjecucion() {
		return ejecucion;
	}

	/* ----------------------- SETTERS ---------------------- */

	public void setEjecucion(boolean ejecucion) {
		this.ejecucion = ejecucion;
	}

	/* ---------------------- TO STRING ---------------------- */

	@Override
	public String toString() {
		return "Proyecto nombre: " + nombre + " | compilado: " + compilado + " | enEjecucion: " + ejecucion
				+ " | version: " + version;
	}

}
