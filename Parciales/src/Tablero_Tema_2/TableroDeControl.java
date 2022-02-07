package Tablero_Tema_2;

import java.util.ArrayList;

public class TableroDeControl {

	private static int LUCES_MINIMO = 3;
	private static int LUCES_MAXIMO = 32;
	private int cantidadMaximaLuces;
	private int encendidas;
	private Telon telon;

	private ArrayList<Lampara> luces;
	private ArrayList<HistoricoLuz> historicoLuces;

	public TableroDeControl(int cantidadMaximaLuces) {
		setCantidadMaximaLuces(cantidadMaximaLuces);
		luces = new ArrayList<>();
		historicoLuces = new ArrayList<>();
		telon = new Telon();
		encendidas = 0;
	}

	public boolean agregarLampara(int numero, SectorLuz sector, ColorLuz color) {
		boolean pudoCrear = false;
		if (cantidadMaximaLuces > cantidadLuces() && buscarLampara(numero) == null) {
			Lampara lampara = new Lampara(numero, sector, color);
			luces.add(lampara);
			historicoLuces.add(new HistoricoLuz(Accion.AGREGAR, lampara));
			pudoCrear = true;
		}
		return pudoCrear;
	}

	private void apagar(Lampara lampara) {
		lampara.apagar();
		historicoLuces.add(new HistoricoLuz(Accion.APAGAR, lampara));
		encendidas--;
	}

	private int apagarTodasLasLuces() {
		for (Lampara luz : this.luces) {
			if (luz.estaPrendida()) {
				apagar(luz);
			}
		}
		return encendidas;
	}

	public void apagaryCerrarTodo() {
		if (telonAbierto()) {
			telon.bajar();
		}
		apagarTodasLasLuces();
	}

	private Lampara buscarLampara(int numero) {
		Lampara luz = null;
		int index = 0;
		while (index < cantidadLuces() && luces.get(index).getNumero() != numero) {
			index++;
		}
		if (index < cantidadLuces()) {
			luz = luces.get(index);
		}
		return luz;
	}

	public int cambiarColor(ColorLuz colorActual, ColorLuz colorNuevo) {
		int cambiadas = 0;
		for (Lampara luz : luces) {
			if (luz.getColor().equals(colorActual)) {
				cambiarColor(luz, colorNuevo);
				cambiadas++;
			}
		}
		return cambiadas;
	}

	private void cambiarColor(Lampara luz, ColorLuz colorNuevo) {
		luz.setColor(colorNuevo);
		historicoLuces.add(new HistoricoLuz(Accion.CAMBIAR, luz));
	}

	public int cantidadLuces() {
		return this.luces.size();
	}

	public void mostrarEstadoLuces() {
		int operativas = cantidadLuces();
		System.out.println("Total de Luces Operativas: " + operativas);
		System.out.println("Porcentaje encendido: " + encendidas + " (" + (encendidas * 100 / operativas) + "%)");
	}

	public int mostrarHistoricoDeLuces() {
		for (HistoricoLuz luz : this.historicoLuces) {
			System.out.println(luz);
		}
		return this.historicoLuces.size();
	}

	private void prender(Lampara luz) {
		luz.prender();
		historicoLuces.add(new HistoricoLuz(Accion.PRENDER, luz));
		encendidas++;
	}

	public int prenderLuces(SectorLuz sector) {
		int prendidas = 0;
		for (Lampara luz : luces) {
			if (!luz.estaPrendida() && luz.getSector().equals(sector)) {
				prender(luz);
				prendidas++;
			}
		}
		return prendidas;
	}

	public boolean prenderLuz(int numero) {
		boolean pudoPrender = false;
		Lampara luz = this.buscarLampara(numero);
		if (luz != null && !luz.estaPrendida()) {
			prender(luz);
			pudoPrender = true;
		}
		return pudoPrender;
	}

	private void setCantidadMaximaLuces(int cantidadMaximaLuces) {
		if (cantidadMaximaLuces < LUCES_MINIMO) {
			cantidadMaximaLuces = LUCES_MINIMO;
		} else if (cantidadMaximaLuces > LUCES_MAXIMO) {
			cantidadMaximaLuces = LUCES_MAXIMO;
		}
		this.cantidadMaximaLuces = cantidadMaximaLuces;
	}

	public boolean subirTelon() {
		boolean pudoSubir = false;
		if (!telon.estaAbierto() && cantidadLuces() >= LUCES_MINIMO) {
			telon.subir();
			pudoSubir = true;
		}
		return pudoSubir;
	}

	private boolean telonAbierto() {
		return telon.estaAbierto();
	}

}