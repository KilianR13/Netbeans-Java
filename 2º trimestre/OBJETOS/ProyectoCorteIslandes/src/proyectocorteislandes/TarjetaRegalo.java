package proyectocorteislandes;

public class TarjetaRegalo {

    private double saldo;
    private int codigo;

    public TarjetaRegalo(double saldo) {
        if (!parametroPositivo(saldo)) {
            throw new IllegalArgumentException("El saldo de la tarjeta debe ser positivo");
        }
        this.saldo = saldo;
        this.codigo = generarCodigo();

    }

    public void gasta(double dinero) {
        if (!parametroPositivo(dinero)) {
            System.err.println("No se puede gastar dinero positivo");
        } else if (dinero > this.saldo) {
            System.err.println("No tiene suficiente saldo para gastar " + dinero + " €");
        } else {
            this.saldo -= dinero;
        }
    }

    public TarjetaRegalo fusionaCon(TarjetaRegalo tarjeta) {
        TarjetaRegalo nueva = new TarjetaRegalo(this.saldo + tarjeta.saldo);
        this.saldo = tarjeta.saldo = 0;

        return nueva;
    }

    @Override
    public String toString() {
        return "Tarjeta nº " + this.codigo +" - Saldo " + this.saldo + "€";
    }

    private int generarCodigo() {
        return 0;
    }

    private boolean parametroPositivo(double valor) {
        return valor > 0;
    }
}
