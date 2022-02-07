package TestAplicaciones;

public class Accion {
    private String codigo;

    public Accion() {
        this.codigo = "Codigo Accion: " + (Math.random() * 100);
    }

    public ResultadoAccion ejecutar(Aplicacion aplicacion) {
        ResultadoAccion resultado = ResultadoAccion.OK;
        double random = Math.random();
        if (random <= 0.3) {
            resultado = ResultadoAccion.FALLO;
        } else if (random >= 0.7) {
            resultado = ResultadoAccion.TIMEOUT;
        }

        return resultado;
    }

    @Override
    public String toString() {
        return "Accion [codigo=" + codigo + "]";
    }

}
