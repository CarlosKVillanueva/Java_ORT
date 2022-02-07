package Eclipse_Resuelto;

public class Historial {

	private Accion accion;
	private String nombreProyecto;
	private int version;
	private boolean correcto;
	private ResultadoEjecutar resultado;

	public Historial(Accion accion, String nombreProyecto, int version, boolean correcto) {
		this.accion = accion;
		this.nombreProyecto = nombreProyecto;
		this.version = version;
		this.correcto = correcto;
	}

	public Historial(Accion accion, String nombreProyecto, int version, boolean correcto, ResultadoEjecutar resultado) {
		this(accion, nombreProyecto, version, correcto);
		this.resultado = resultado;
	}

	@Override
	public String toString() {
		return "Historial [accion=" + accion + ", nombreProyecto=" + nombreProyecto + ", version=" + version
				+ ", correcto=" + correcto + (resultado != null ? ", resultado=" + resultado : "") + "]";
	}
}
