package ejersPOO2;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<cuentaBancaria> cuentas = new ArrayList<>();

    public static void main(String[] args) {

        int opcion;

        do {
            mostrarMenu();
            opcion = sc.nextInt();

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> ingresar();
                case 3 -> retirar();
                case 4 -> transferir();
                case 5 -> mostrarCuentas();
                case 6 -> aplicarIntereses();
            }

        } while (opcion != 0);

        System.out.println("Programa finalizado");
    }

    // ---------------- MENÚ ----------------

    static void mostrarMenu() {
        System.out.println("""
                ===== BANCO =====
                1. Crear cuenta
                2. Ingresar dinero
                3. Retirar dinero
                4. Transferir
                5. Ver cuentas
                6. Aplicar intereses
                0. Salir
                """);
    }

    // ---------------- CREAR ----------------

    static void crearCuenta() {

        System.out.println("1 Corriente | 2 Ahorro");
        int tipo = sc.nextInt();

        System.out.print("IBAN: ");
        String iban = sc.next();

        System.out.print("Saldo inicial: ");
        double saldo = sc.nextDouble();

        if (tipo == 1)
            cuentas.add(new cuentaCorriente(iban, saldo));
        else
            cuentas.add(new cuentaAhorro(iban, saldo));

        System.out.println("Cuenta creada correctamente");
    }

    // ---------------- ELEGIR CUENTA ----------------

    static cuentaBancaria elegirCuenta() {

        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas");
            return null;
        }

        for (int i = 0; i < cuentas.size(); i++)
            System.out.println(i + " -> " + cuentas.get(i).getIban());

        System.out.print("Selecciona cuenta: ");
        int i = sc.nextInt();

        if (i < 0 || i >= cuentas.size())
            return null;

        return cuentas.get(i);
    }

    // ---------------- INGRESAR ----------------

    static void ingresar() {
        cuentaBancaria c = elegirCuenta();
        if (c == null) return;

        System.out.print("Cantidad: ");
        double cantidad = sc.nextDouble();

        if (!c.ingresar(cantidad))
            System.out.println("No se pudo ingresar");
    }

    // ---------------- RETIRAR ----------------

    static void retirar() {
        cuentaBancaria c = elegirCuenta();
        if (c == null) return;

        System.out.print("Cantidad: ");
        double cantidad = sc.nextDouble();

        if (!c.retirar(cantidad))
            System.out.println("Saldo insuficiente");
    }

    // ---------------- TRANSFERIR ----------------

    static void transferir() {

        System.out.println("Cuenta origen:");
        cuentaBancaria origen = elegirCuenta();
        if (origen == null) return;

        System.out.println("Cuenta destino:");
        cuentaBancaria destino = elegirCuenta();
        if (destino == null) return;

        System.out.print("Cantidad: ");
        double cantidad = sc.nextDouble();

        if (!origen.transferir(cantidad, destino))
            System.out.println("Transferencia fallida");
    }

    // ---------------- MOSTRAR ----------------

    static void mostrarCuentas() {
        for (cuentaBancaria c : cuentas)
            c.mostrarDatos();
    }

    // ---------------- INTERESES ----------------

    static void aplicarIntereses() {
        for (cuentaBancaria c : cuentas)
            c.calcularIntereses();

        System.out.println("Intereses aplicados");
    }
}