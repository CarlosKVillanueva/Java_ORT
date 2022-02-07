/**
 * 
 */
package Votacion;

/**
 * @author Carlos K. Villanueva
 *
 *         7 nov 2021
 */
public enum Mensajes {
	NO_EXISTE_EN_RECINTO {
		public String toString() {
			return "No existe en el recinto";
		}
	},
	YA_EXISTE_EN_RECINTO{
		public String toString() {
			return "Ya existe en el recinto";
		}
	}, YA_VOTO{
		public String toString() {
			return "Ya votó";
		}
	}, AGREGADO_AL_RECINTO{
		public String toString() {
			return "Agregado al Recinto";
		}
	}, RECINTO_COMPLETO{
		public String toString() {
			return "Recinto Completo";
		}
	}, VOTO_ACTUALIZADO {
		public String toString() {
			return "Se actualizo el voto correctamente";
		}
	}
	
}
