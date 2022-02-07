package TestAplicaciones;

import java.util.ArrayList;

public class Tester {
    private ArrayList<Historico> registro;

    public Tester() {
        registro = new ArrayList<Historico>();
    }

    /* ----------------------- METODOS ----------------------- */

    public Resultado realizarTest(ArrayList<Prueba> pruebas, Aplicacion aplicacion) {
        int i = 0;
        boolean continuar = true;
        boolean pruebaOk;
        boolean huboFallas = false;
        Prueba pruebaActual;
        Resultado resultado;

        while (i < pruebas.size() && continuar) {
            pruebaActual = pruebas.get(i);
            // pruebaOk = pruebaActual.ejecutar(aplicacion);
            pruebaOk = false;
            if (!pruebaOk) {
                huboFallas = true;
            }
            continuar = chequearResultadoPrueba(pruebaOk, pruebaActual);
            i++;
        }
        resultado = calcularResultado(continuar, huboFallas);
        agregarHistorico(resultado, aplicacion);
        return resultado;
    }

    private void agregarHistorico(Resultado resultado, Aplicacion aplicacion) {
        registro.add(new Historico(aplicacion.getNombre(), aplicacion.getVersion(), resultado));
    }

    private Resultado calcularResultado(boolean hizoTodas, boolean huboFallas) {
        Resultado resultado = Resultado.PRUEBA_NO_SUPERADA;
        if (hizoTodas) {
            if (huboFallas) {
                resultado = Resultado.PRUEBA_SUPERADA_CON_FALLOS;
            } else {
                resultado = Resultado.PRUEBA_SUPERADA;
            }
        }
        return resultado;
    }

    private boolean chequearResultadoPrueba(boolean pruebaOk, Prueba pruebaActual) {
        boolean esStopper = pruebaActual.esStopper();
        /*
         * V
         * F
         */
        return !esStopper || esStopper && pruebaOk;
        /*
         * F V V ==> V
         * F V F ==> F
         * V F V ==> V
         * V F F ==> V
         */
    }

    public void mostrarResultado() {
        for (Historico historico : registro) {
            System.out.println(historico);
        }
    }

}
