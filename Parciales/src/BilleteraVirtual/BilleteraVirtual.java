package BilleteraVirtual;

import java.util.ArrayList;

public class BilleteraVirtual {
    private String nombre;
    private ArrayList<Cliente> clientes;

    public BilleteraVirtual(String nombre) {
        this.nombre = nombre;
        clientes = new ArrayList<>();
    }

    /* ---------------------- BUSQUEDA ---------------------- */

    private Cliente buscarCliente(String dni) {
        Cliente elementoBuscado = null;
        int i = 0, cantElementos = clientes.size();

        while (i < cantElementos && elementoBuscado == null) {
            if (clientes.get(i).mismoCliente(dni)) {
                elementoBuscado = clientes.get(i);
            } else {
                i++;
            }
        }
        return elementoBuscado;
    }

    /* ---------------------- AGREGADO ---------------------- */

    public boolean agregarCliente(String dni) {
        boolean seAgrego = false;
        Cliente cliente = buscarCliente(dni);

        if (cliente == null) {
            clientes.add(new Cliente(dni));
            seAgrego = true;
        }

        return seAgrego;
    }

    public boolean registrarTarjeta(String dni, String numeroTarjeta, NombreTarjeta nombreTarjeta, double saldo) {
        boolean seAgrego = false;
        Cliente cliente = buscarCliente(dni);
        if (cliente != null) {
            seAgrego = cliente.registrarTarjeta(numeroTarjeta, nombreTarjeta, saldo);
        }

        return seAgrego;
    }

    public ResultadoCompra realizarCompra(String dni, double monto, int cuotas) {
        ResultadoCompra resultado = ResultadoCompra.ERROR;
        Cliente cliente = buscarCliente(dni);

        if (monto > 0 && cuotas > 0) {

            if (cliente != null) {
                boolean tieneTarjeta = cliente.controlarSaldo(monto).size() > 0;

                if (tieneTarjeta) {
                    Tarjeta tarjetaParaPagar = cliente.tarjetaConMasSaldo();
                    resultado = ResultadoCompra.TRANSACCION_OK;
                    tarjetaParaPagar.descontarSaldo(monto);
                    cliente.sumarCompra();
                    System.out.println(monto / cuotas + " total x cuotas(pobre)");
                } else {
                    resultado = ResultadoCompra.SIN_TARJETA_PARA_COMPRAR;
                }
            } else {
                resultado = ResultadoCompra.USUARIO_INEXISTENTE;
            }
        }
        return resultado;
    }

    public ArrayList<Informe> obtenerCompras() {
        ArrayList<Informe> informe = new ArrayList<>();

        for (Cliente cliente : clientes) {
            informe.add(new Informe(cliente.getDni(), cliente.getCantCompras()));
        }

        return informe;
    }

    public void mostrarTarjetasPuedenComprar(String dni, double monto) {
        Cliente cliente = buscarCliente(dni);

        if (cliente != null && cliente.controlarSaldo(monto).size() > 0) {
            System.out.println(cliente.controlarSaldo(monto));
        } else {
            System.out.println("No hay tarjetas con Saldo");
        }
    }

    public void mostrarTarjetasConSaldo() {
        for (Cliente cliente : clientes) {
            System.out.println(cliente.controlarSaldo(1));
        }
    }

    @Override
    public String toString() {
        return "BilleteraVirtual [nombre=" + nombre + "]";
    }

}
