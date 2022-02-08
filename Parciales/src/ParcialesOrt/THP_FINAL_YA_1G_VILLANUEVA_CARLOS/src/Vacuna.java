public class Vacuna {
    private int nroSerie;
    private Marca marca;

    public Vacuna(Marca marca, int nroSerie) {
        this.nroSerie = nroSerie;
        this.marca = marca;
    }

    public Marca getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Vacuna [marca=" + marca + ", nroSerie=" + nroSerie + "]";
    }

}
