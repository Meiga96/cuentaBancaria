package ejersPOO2;

public class cuentaAhorro extends cuentaBancaria {

    private static final double saldoMinimo = 10;

    public cuentaAhorro(String iban, double saldo) {
        super(iban, saldo);
    }

    public double getSaldoMinimo() {
        return saldoMinimo;
    }

    @Override
    public void calcularIntereses() {
        double interesAplicado;

        if (saldo < saldoMinimo)
            interesAplicado = interesAnualBasico / 2;
        else
            interesAplicado = interesAnualBasico * 2;

        saldo += saldo * interesAplicado;
    }
}

