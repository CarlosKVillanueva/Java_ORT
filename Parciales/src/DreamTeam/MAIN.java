package DreamTeam;

public class MAIN {

	public static void main(String[] args) {
		Liga liga = new Liga("NBA");
		
		liga.agregarEquipo("LA Lakers");
		liga.agregarEquipo("Miami Heat");
		
		liga.agregarJugAEquipo("LA Lakers", 23, "James", "Lebron", Posicion.ALERO, 99);
		liga.agregarJugAEquipo("LA Lakers", 1, "Caldwell Pope", "Kentavious", Posicion.ESCOLTA, 86);
		liga.agregarJugAEquipo("LA Lakers", 9, "Rondo", "Rajon", Posicion.BASE, 90);
		liga.agregarJugAEquipo("LA Lakers", 4, "Caruso", "Alex", Posicion.ESCOLTA, 82);
		liga.agregarJugAEquipo("LA Lakers", 3, "Davis", "Anthony", Posicion.ALA_PIVOT, 95);
		liga.agregarJugAEquipo("LA Lakers", 39, "Howard", "Dwight", Posicion.PIVOT, 84);
		
		liga.agregarJugAEquipo("Miami Heat", 7, "Dragic", "Goran", Posicion.BASE, 87);
		liga.agregarJugAEquipo("Miami Heat", 14, "Herro", "Tyler", Posicion.ESCOLTA, 84);
		liga.agregarJugAEquipo("Miami Heat", 28, "Iguodala", "Andre", Posicion.ESCOLTA, 88);
		liga.agregarJugAEquipo("Miami Heat", 99, "Crowder", "Jae", Posicion.ALERO, 83);
		liga.agregarJugAEquipo("Miami Heat", 22, "Butler", "Jimmy", Posicion.ALA_PIVOT, 97);
		liga.agregarJugAEquipo("Miami Heat", 13, "Adebayo", "Bam", Posicion.PIVOT, 91);
		
		
		System.out.println("GANADOR: " + liga.competir("LA Lakers", "Miami Heat"));
		System.out.println("");
		
		liga.mostrarAllStar();
	}

}
