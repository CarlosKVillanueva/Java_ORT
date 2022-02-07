package EclipsePasion;

public class Log {
	private String nombre;
	private int version;
	private boolean compilo;
	private boolean ejecuto;
	// ENUM
	private Ejecucion ejecucion;

	// 1CONSTRUCTOR
	public Log(Proyecto proyecto, Ejecucion tipoEjecucion) {
		setNombre(proyecto.getNombre());
		setVersion(proyecto.getVersion());
		setCompilo(proyecto.isCompilado());
		setEjecuto(proyecto.enEjecucion());
		setEjecucion(tipoEjecucion);
	}

	// // SOBRECARGA
	// public Log(Proyecto proyecto, Ejecucion ejecucion) {
	// this(proyecto);
	// setEjecuto(proyecto.isEjecucion());
	// setEjecucion(ejecucion);
	// }

	/* ----------------------- SETTERS ---------------------- */

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	private void setVersion(int version) {
		this.version = version;
	}

	private void setCompilo(boolean compilo) {
		this.compilo = compilo;
	}

	private void setEjecuto(boolean ejecuto) {
		this.ejecuto = ejecuto;
	}

	private void setEjecucion(Ejecucion ejecucion) {
		this.ejecucion = ejecucion;
	}

	/* ---------------------- TO STRING ---------------------- */

	@Override
	public String toString() {
		return "Log: Nombre: " + nombre + " | Version: " + version + " | " + (compilo ? "Compilo" : "No Compilo")
				+ " | " + (ejecuto ? "En Ejecuion" : "Sin Ejecucion") + " | Historial: " + ejecucion;
	}

}
