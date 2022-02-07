package TestAplicaciones;

import java.util.ArrayList;

public class Prueba {
    private boolean stopper;
    private ArrayList<Accion> acciones;

    public Prueba() {
        this.stopper = randBoolean();
        this.acciones = new ArrayList<Accion>();
    }

    private boolean randBoolean() {
        return Math.random() >= 0.5 ? true : false;
    }

    public boolean ejecutar(Aplicacion aplicacion) {
        int i = 0;
        boolean accionOk = true;
        Accion accionActual;

        while ((i < acciones.size()) && accionOk) {
            accionActual = acciones.get(i);
            accionOk = accionActual.ejecutar(aplicacion) == ResultadoAccion.OK;
            i++;
        }
        return accionOk;
    }

    public boolean esStopper() {
        return this.stopper;
    }
}
