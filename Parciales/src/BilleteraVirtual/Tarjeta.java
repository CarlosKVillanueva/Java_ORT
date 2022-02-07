package BilleteraVirtual;

public class Tarjeta {
    private String numeroTarjeta;
    private NombreTarjeta nombreTarjeta;
    private double saldo;

    public Tarjeta(String numeroTarjeta, NombreTarjeta nombreTarjeta, double saldo) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTarjeta = nombreTarjeta;
        setSaldo(saldo);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo < 0) {
            this.saldo = 0;
        } else {
            this.saldo = saldo;
        }
    }

    public boolean mismoTarjeta(String numeroTarjeta) {
        return this.numeroTarjeta.equals(numeroTarjeta);
    }

    @Override
    public String toString() {
        return "Tarjeta [nombreTarjeta=" + nombreTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", saldo=" + saldo
                + "]";
    }

    public void descontarSaldo(double monto) {
        this.saldo -= monto;

    }

}
