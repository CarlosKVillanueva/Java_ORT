import java.util.ArrayList;

public class Persona {
    private int dni;
    private ArrayList<Vacuna> vacunasAplicadas;

    public Persona(int dni) {
        this.dni = dni;
        vacunasAplicadas = new ArrayList<Vacuna>();
    }

    public boolean mismaPersona(int dni) {
        return this.dni == dni;
    }

    public boolean getEsquemaCompleto() {
        return this.vacunasAplicadas.size() == 3;
    }

    public Marca obtenerPrimeraDosis() {
        return vacunasAplicadas.get(0).getMarca();
    }

    public Marca obtenerSegundaDosis() {
        return vacunasAplicadas.get(1).getMarca();
    }

    public Vacuna vacunarPrimeraDosis() {
        Vacuna primeraDosis = new Vacuna(Marca.PFIZER, 1);
        vacunasAplicadas.add(primeraDosis);
        return primeraDosis;
    }

    public Vacuna vacunarSegundaDosis() {
        Vacuna segundaDosis = new Vacuna(Marca.PFIZER, 2);
        vacunasAplicadas.add(segundaDosis);
        return segundaDosis;
    }

    public Vacuna vacunarTerceraDosis() {
        Vacuna terceraDosis = new Vacuna(Marca.ASTRASENECA, 3);
        vacunasAplicadas.add(terceraDosis);
        return terceraDosis;
    }

    public boolean noTieneDosis() {
        return this.vacunasAplicadas.isEmpty();
    }

}
