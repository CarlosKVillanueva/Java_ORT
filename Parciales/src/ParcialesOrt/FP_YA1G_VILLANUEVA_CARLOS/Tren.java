package FP_YA1G_VILLANUEVA_CARLOS;

import java.util.ArrayList;

public class Tren {
    private String destino;
    private Maquinista maquinista;
    private ArrayList<Vagon> formacionCompleta;

    /*
     * public Tren(String destino, Maquinista maquinista) { this.destino = destino;
     * this.maquinista = maquinista; }
     */

    public Tren(String destino, Maquinista maquinista, ArrayList<Vagon> formacionCompleta) {
        this.destino = destino;
        this.maquinista = maquinista;
        this.formacionCompleta = formacionCompleta;
    }

    public void mostrarVagones() {
        for (Vagon vagon : formacionCompleta) {

            System.out.println(vagon);
        }
    }

    @Override
    public String toString() {
        return "Tren => Destino: " + destino + " Maquinista: " + maquinista + "\nFormacion: " + formacionCompleta;
    }

}
