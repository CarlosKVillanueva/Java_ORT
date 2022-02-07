package Discografica;

import java.util.ArrayList;

public class Informe {
    private Tema tema;
    private ArrayList<Disco> discosDondeSeElimino;

    public Informe(Tema tema, ArrayList<Disco> discosDondeSeElimino) {
        this.tema = tema;
        this.discosDondeSeElimino = discosDondeSeElimino;
    }

    @Override
    public String toString() {
        return "El tema " + tema + ", se eliminó de los discos: " + discosDondeSeElimino + " ";
    }

}
