package ejersPOO2;

public class cuentaCorriente extends cuentaBancaria {

    public cuentaCorriente(String iban, double saldo) {
        super(iban, saldo);
    }

    @Override
    public void calcularIntereses() {
        double interes = saldo * interesAnualBasico;
        saldo += interes;
    }
}
