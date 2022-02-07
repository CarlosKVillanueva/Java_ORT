package FabricaBotellas;

import java.util.ArrayList;

public class Maquina {

    private final double ALTURA_VALIDA = 20;
    private final double PROBABILIDAD_CORRECTA = 0.8;

    public ArrayList<Botella> fabricar(int cantidadBotellasFabricar) {
        ArrayList<Botella> botellas = new ArrayList<>();

        for (int i = 0; i < cantidadBotellasFabricar; i++) {
            Botella botella = fabricarUnaBotella();
            if (botella.correcta()) {
                botellas.add(botella);
            } else {
                System.out.println("Desechada: " + botella);
            }
        }

        System.out.println("Se fabricaron: " + botellas.size());

        return botellas;
    }

    private Botella fabricarUnaBotella() {
        double altura;
        Calidad calidad = null;
        double random = Math.random();

        if (random <= PROBABILIDAD_CORRECTA) {
            altura = ALTURA_VALIDA;
            calidad = Calidad.CORRECTA;
        } else {
            altura = Math.floor(random * ALTURA_VALIDA);
            calidad = Calidad.DEFECTUOSA;
        }
        Botella botella = new Botella(Botella.generarID(), altura, calidad);

        return botella;
    }

}
