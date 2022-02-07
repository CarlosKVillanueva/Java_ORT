package Tablero_Tema_1;

import java.util.ArrayList;

public class TableroDeControl {

	private static int LUCES_MINIMO = 3;
	private static int LUCES_MAXIMO = 20;
	private int cantidadMaximaLuces;
	private Telon telon;

	private ArrayList<Lampara> luces;
	private ArrayList<HistoricoLuz> historicoLuces;

	public TableroDeControl(int cantidadMaximaLuces) {
		setCantidadMaximaLuces(cantidadMaximaLuces);
		luces = new ArrayList<>();
		historicoLuces = new ArrayList<>();
		telon = new Telon();
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
		if (telonAbierto()) {
			telon.bajar();
			System.out.println("Se bajo el telon");
		}
		int lucesApagadas = apagarTodasLasLuces();
		System.out.println("Se apagaron " + lucesApagadas + " luces");
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

	private void cambiarColor(Lampara luz, ColorLuz colorNuevo) {
		luz.setColor(colorNuevo);
		historicoLuces.add(new HistoricoLuz(Accion.CAMBIAR, luz));
	}

	public int cambiarColor(ColorLuz colorActual, ColorLuz colorNuevo) {
		int cambiadas = 0;
		if (!colorActual.equals(colorNuevo)) {
			for (Lampara luz : luces) {
				if (luz.getColor().equals(colorActual)) {
					cambiarColor(luz, colorNuevo);
					cambiadas++;
				}
			}
		}
		return cambiadas;
	}

	public int cantidadLuces() {
		return this.luces.size();
	}

	public int mostrarHistoricoDeLuces() {
		for (HistoricoLuz luz : this.historicoLuces) {
			System.out.println(luz);
		}
		return this.historicoLuces.size();
	}

	public void mostrarOperatividad() {
		int operativas = cantidadLuces();
		System.out.println("Total de Luces: " + cantidadMaximaLuces);
		System.out.println("Operativas: " + operativas + " (" + (operativas * 100 / cantidadMaximaLuces) + "%)");
	}

	private void prender(Lampara luz) {
		luz.prender();
		historicoLuces.add(new HistoricoLuz(Accion.PRENDER, luz));
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