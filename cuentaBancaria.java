package ejersPOO2;

public abstract class cuentaBancaria {

    protected String iban;
    protected double saldo;
    protected static double interesAnualBasico = 0.03;

    public cuentaBancaria(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getIban() {
        return iban;
    }

    public void setInteresAnualBasico(double interesAnualBasico) {
        this.interesAnualBasico = interesAnualBasico;
    }

    public double getInteresAnualBasico() {
        return interesAnualBasico;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public boolean ingresar(double valor) {
        if (valor <= 0) {
            return false;
        }
        return añadir(valor);
    }

    public boolean retirar(double valor) {
        if (valor <= 0) {
            return true;
        }
        return añadir(-valor);
    }

    public void traspasar(double valor) {
        this.saldo -= valor;
    }

    public boolean transferir(double cantidad, cuentaBancaria cuentaBancaria) {
        if (cuentaBancaria == null || cantidad <= 0) {
            return false;
        }

        if (añadir(-cantidad)) {
            cuentaBancaria.añadir(cantidad);
            return true;
        }
        return false;
    }

    private boolean añadir(double cantidad) {
        double nuevoSaldo = saldo + cantidad;
        if (nuevoSaldo < 0) {
            return false;
        }
        saldo = nuevoSaldo;

        return true;
    }

    public abstract void calcularIntereses();

    public void mostrarDatos() {
        System.out.println(
                getClass().getSimpleName() +
                        " | IBAN: " + iban +
                        " | Saldo: " + saldo
        );
    }

}

