package Pedidos;

public class Pedido {
    private static final int CODIGO_MIN = 1;
    private static final int CODIGO_MAX = 10;
    private static final double IMPORTE_MIN = 0;
    private int numPedido;
    private int codigo;
    private int cantidadPedida;
    private double importe;
    private int pendiente;
    private Estado estado;

    public Pedido(int numPedido, int codigo, int cantidadPedida, double importe) {
        setNumPedido(numPedido);
        setCodigo(codigo);
        setCantidadPedida(cantidadPedida);
        setImporte(importe);
        this.pendiente = getCantidadPedida();
        setEstado(Estado.PENDIENTE);
    }

    public int getCantidadPedida() {
        return cantidadPedida;
    }

    public double getImporte() {
        return importe;
    }

    public int getPendiente() {
        return pendiente;
    }

    private void setCantidadPedida(int cantidadPedida) {
        if (cantidadPedida > 0) {
            this.cantidadPedida = cantidadPedida;
        }
    }

    public void setNumPedido(int numPedido) {
        if (numPedido > 0) {
            this.numPedido = numPedido;
        }
    }

    public void setCodigo(int codigo) {
        if (codigo <= CODIGO_MIN) {
            this.codigo = CODIGO_MIN;
        } else if (codigo >= CODIGO_MAX) {
            this.codigo = CODIGO_MAX;
        } else
            this.codigo = codigo;
    }

    public void setImporte(double importe) {
        if (importe > IMPORTE_MIN) {
            this.importe = importe;
        }
    }

    public void setPendiente(int pendiente) {
        this.pendiente = pendiente;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean mismoPedido(int numPedido) {
        return this.numPedido == numPedido;
    }

    @Override
    public String toString() {
        return "Pedido [cantidadPedida=" + cantidadPedida + ", codigo=" + codigo + ", estado=" + estado + ", importe="
                + importe + ", numPedido=" + numPedido + ", pendiente=" + pendiente + "]";
    }

    public void entregaParcial(int cantidadEntregar) {
        this.pendiente = pendiente - cantidadEntregar;
    }

}
