package Pedidos;

import java.util.ArrayList;

public class Empresa {
    private String nombre;
    private ArrayList<Pedido> pedidos;

    public Empresa(String nombre) {
        this.nombre = nombre;
        this.pedidos = new ArrayList<Pedido>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Pedido buscarPedido(int numPedido) {
        Pedido elementoBuscado = null;
        int i = 0;

        while (i < pedidos.size() && elementoBuscado == null) {
            if (pedidos.get(i).mismoPedido(numPedido)) {
                elementoBuscado = pedidos.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ----------------------- AGREGAR ---------------------- */

    public boolean agregarPedido(int numPedido, int codigo, int cantidadPedida, double importe) {
        boolean agregado = false;

        if (buscarPedido(numPedido) == null) {
            pedidos.add(new Pedido(numPedido, codigo, cantidadPedida, importe));
            agregado = true;
        }

        return agregado;
    }

    /* ------------------- PEDIDO MAS ALTO ------------------ */

    public void pedidoMasAlto() {
        ArrayList<Pedido> masAltos = new ArrayList<>();
        double importeMax = Double.MIN_VALUE;

        for (Pedido pedido : pedidos) {
            double importe = pedido.getImporte();

            if (importe > importeMax) {
                masAltos.clear();
                importeMax = importe;
                masAltos.add(pedido);
            } else if (importe == importeMax) {
                masAltos.add(pedido);
            }
        }

        System.out.println("*** PEDIDOS MAS ALTOS ***");
        for (Pedido pedido : masAltos) {
            System.out.println(pedido);
        }

    }

    /* ---------------------- ENTREGAR ---------------------- */

    public void entregar(int numPedido, int cantidadEntregar) {
        Pedido pedidoBuscado = buscarPedido(numPedido);

        if (pedidoBuscado != null && (pedidoBuscado.getPendiente() > cantidadEntregar)) {

            pedidoBuscado.entregaParcial(cantidadEntregar);

        } else if (pedidoBuscado.getPendiente() == cantidadEntregar) {
            pedidoBuscado.setEstado(Estado.ENTREGADO);
            pedidoBuscado.entregaParcial(cantidadEntregar);
        }
    }

    public void mostrarPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido);
        }
    }

    @Override
    public String toString() {
        return "\nEmpresa [nombre=" + nombre + ", pedidos=" + pedidos + "]";
    }

}
