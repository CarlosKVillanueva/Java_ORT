package Votacion;

import java.util.ArrayList;

/**
 * @author Carlos K. Villanueva
 *
 *         7 nov 2021
 */
public class Camara {
	@SuppressWarnings("unused")
	private String nombreCamara;
	private int cantidadMiembros;
	private ArrayList<Votante> votantes;

	public Camara(String nombreCamara, int cantidadMiembros) {
		this.nombreCamara = nombreCamara;
		this.cantidadMiembros = cantidadMiembros;
		votantes = new ArrayList<>();
	}

	private Votante buscarVotante(int dni) {
		int i = 0, cantidadElem = votantes.size();
		Votante votanteBuscado = null;

		while (i < cantidadElem && votanteBuscado == null) {
			if (votantes.get(i).mismoDni(dni)) {
				votanteBuscado = votantes.get(i);
			} else {
				i++;
			}
		}
		return votanteBuscado;
	}

	public boolean agregarVotante(int dni, String nombre) {
		boolean seAgrego = false;

		if (votantes.size() < cantidadMiembros) {
			Votante votanteBuscado = buscarVotante(dni);

			if (votanteBuscado == null) {
				votantes.add(new Votante(dni, nombre));
				seAgrego = true;
				System.out.println(Mensajes.AGREGADO_AL_RECINTO);
			} else
				System.out.println(Mensajes.YA_EXISTE_EN_RECINTO);
		} else
			System.out.println(Mensajes.RECINTO_COMPLETO);

		return seAgrego;
	}

	public void votar(int dni, String nombre, ValorVoto voto) {
		
		Votante votante = buscarVotante(dni);
		
		if (votante != null) {

			if (votante.getVoto() == null) {
				votante.votar(voto);
				System.out.println(Mensajes.VOTO_ACTUALIZADO);

			} else {
				System.out.println(Mensajes.YA_VOTO);
			}

		} else
			System.out.println(Mensajes.NO_EXISTE_EN_RECINTO);
	}

	public void resultadoVotacion() {
		int positivos = 0;
		int negativos = 0;
		int abstencion = 0;
		int novoto = 0;

		for (Votante votante : votantes) {
			if (votante.getVoto()==ValorVoto.ABSTENCION) 
			{
				abstencion++;
			}
			else 
			{
				if(votante.getVoto()==ValorVoto.NEGATIVO) 
				{
					negativos++;
				}
				else 
				{
					if(votante.getVoto()==ValorVoto.POSITIVO) 
					{
						positivos++;
					}
					else
					{
						novoto++;
					}
					
				}
			}
		}

		int cantidadVotantes = votantes.size();
		System.out.println("Los votos positivos fueron: " + positivos);
		System.out.println("Porcentaje de Positivos: " + porcentajeVoto(cantidadVotantes, positivos) + "%");
		System.out.println("Los votos negativos fueron: " + negativos);
		System.out.println("Porcentaje de Positivos: " + porcentajeVoto(cantidadVotantes, negativos) + "%");
		System.out.println("Los abstencions fueron: " + abstencion);
		System.out.println("Porcentaje de Positivos: " + porcentajeVoto(cantidadVotantes, abstencion) + "%");
		System.out.println("Los que no votar fueron: " + novoto);
		System.out.println("Porcentaje de Positivos: " + porcentajeVoto(cantidadVotantes, novoto) + "%");

	}

	private double porcentajeVoto(int totalVotantes, int votos) {
		double total = 0;

		if (votos > 0) {
			total = (double) votos / totalVotantes * 100;
		}
		return total;
	}

}
