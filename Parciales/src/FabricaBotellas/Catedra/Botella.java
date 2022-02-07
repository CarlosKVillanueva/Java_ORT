package FabricaBotellas.Catedra;

public class Botella {

	private static final double ALTURA_VALIDA = 0.5;
	private static int idActual = 0;
	private int id;
	private double altura;
	private Estado estado;
	
	public Botella(double altura) {
		id = ++idActual;
		setAltura(altura);
		setEstadoSegunAltura();
	}
	
	private void setAltura(double altura) {
		this.altura = altura;
	}
	
	public boolean correcta() {
		return estado == Estado.CORRECTA;
	}
	
	private void setEstadoSegunAltura() {
		estado = (altura != ALTURA_VALIDA ? Estado.DEFECTUOSA : Estado.CORRECTA);
	}

	@Override
	public String toString() {
		return "Botella [id=" + id + ", altura=" + altura + ", estado=" + estado + "]";
	}
	
	
}
