package components;

import model.Account;

import java.util.Scanner;

public class Accountreader {

    private final Scanner scanner;
    private BankReader bankReader;
    private CustomerReader customerReader;

    public Accountreader(Scanner scanner, BankReader bankReader, CustomerReader customerReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
        this.customerReader = customerReader;
    }

    public Account read () {
        System.out.println("Introduzca los datos de la cuenta: ");

        System.out.println("Introduzca el IBAN de la cuenta: ");
        String iban = scanner.nextLine();

        System.out.println("Introduzca el saldo disponible en la cuenta:");
        double saldo = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Introduzca el  NIF del cliente de la cuenta: ");
        String customer = scanner.nextLine();

        return new Account(iban, saldo, customer);
    }
}
