package Tablero_Tema_3;

import java.util.ArrayList;

public class TableroDeControl {

	private static int LUCES_MINIMO = 10;
	private static int LUCES_MAXIMO = 100;
	private int cantidadMaximaLuces;
	private Telon telon;

	private ArrayList<Lampara> luces;
	private ArrayList<HistoricoLuz> historicoLuces;
	private int encendidas;

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
		encendidas--;
		historicoLuces.add(new HistoricoLuz(Accion.APAGAR, lampara));
	}

	private int apagarTodasLasLuces() {
		int cantidad = 0;
		for (Lampara luz : this.luces) {
			if (luz.estaPrendida()) {
				apagar(luz);
				cantidad++;
			}
		}
		return cantidad;
	}

	public void apagaryCerrarTodo() {
		if (telon.estaAbierto()) {
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

	public int cambiarColor(ColorLuz colorActual, ColorLuz colorNuevo, boolean encendidas) {
		int cambiadas = 0;
		for (Lampara luz : luces) {
			if (luz.getColor().equals(colorActual) && luz.estaPrendida() == encendidas) {
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

	public void mostrarEstadoGeneralLuces() {
		System.out.println("Total de Luces: " + cantidadMaximaLuces);
		System.out.println("Encendidas: " + encendidas + " (" + (encendidas * 100 / cantidadMaximaLuces) + "%)");
	}

	public int mostrarHistoricoDeLuces() {
		for (HistoricoLuz luz : this.historicoLuces) {
			System.out.println(luz);
		}
		return this.historicoLuces.size();
	}

	private void prender(Lampara luz) {
		luz.prender();
		encendidas++;
		historicoLuces.add(new HistoricoLuz(Accion.PRENDER, luz));
	}

	public int prenderLuces(ColorLuz color) {
		int prendidas = 0;
		for (Lampara luz : luces) {
			if (!luz.estaPrendida() && luz.getColor().equals(color)) {
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

}