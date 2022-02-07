package Tablero_Tema_1;




public class Recuperatorio1 {
	public static TableroDeControl tablero;

	public static void main(String[] args) {
		tablero = new TableroDeControl(40);
		for (ColorLuz color : ColorLuz.values()) {
			agregarLamparasATablero(tablero, color);
		}
		tablero.mostrarOperatividad();
		prenderLuz(5);
		prenderLuz(5);
		prenderLuz(50);
		subirTelon();
		subirTelon();
		prenderLucesDeUnSector(SectorLuz.CENTRO);
		cambiarColor(ColorLuz.AMARILLO, ColorLuz.AZUL);
		tablero.apagaryCerrarTodo();
		tablero.mostrarHistoricoDeLuces();
	}

	private static void prenderLucesDeUnSector(SectorLuz sector) {
		int prendidas = tablero.prenderLuces(sector);
		if (prendidas == 0) {
			System.out.println("No se encontraron luces en el sector" + sector);
		} else {
			System.out.println("Se prendieron " + prendidas + " luces en el sector " + sector);
		}
	}

	private static void prenderLuz(int id) {
		boolean ok = tablero.prenderLuz(id);
		if (ok) {
			System.out.println("Se prendio la luz con id " + id);
		} else {
			System.out.println("No se pudo prender la luz con id " + id);
		}
	}

	private static void cambiarColor(ColorLuz colorAReemplazar, ColorLuz colorFinal) {
		int cambiadas = tablero.cambiarColor(colorAReemplazar, colorFinal);
		if (cambiadas == 0) {
			System.out.println("No se encontraron luces de color " + colorAReemplazar);
		} else {
			System.out.println("Se cambiaron " + cambiadas + " luces de " + colorAReemplazar + " a " + colorFinal);
		}
	}

	private static void subirTelon() {
		if (tablero.subirTelon()) {
			System.out.println("Arriba el telon!");
		} else {
			System.out.println("El telon ya se ha subido!");
		}
	}

	private static void agregarLamparasATablero(TableroDeControl tablero, ColorLuz color) {
		for (SectorLuz sector : SectorLuz.values()) {
			tablero.agregarLampara(tablero.cantidadLuces() + 1, sector, color);
		}
	}

}