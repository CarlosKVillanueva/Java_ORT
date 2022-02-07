package Pedidos;

public class Test {
    public static void main(String[] args) {
        Empresa empresa = new Empresa("LOS DILDOS DE FACU");

        System.out.println(empresa.agregarPedido(1, 1, 1, 100));
        System.out.println(empresa.agregarPedido(1, 1, 1, 100));
        System.out.println(empresa.agregarPedido(2, 2, 2, 200));
        System.out.println(empresa.agregarPedido(3, 3, 3, 300));
        System.out.println(empresa.agregarPedido(4, 4, 4, 400));
        System.out.println(empresa.agregarPedido(5, 5, 5, 500));
        System.out.println(empresa.agregarPedido(6, 6, 6, 500));

        empresa.entregar(3, 2);
        empresa.entregar(4, 4);

        empresa.mostrarPedidos();
        empresa.pedidoMasAlto();
    }

}
