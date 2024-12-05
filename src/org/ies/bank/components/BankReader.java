package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankReader {

    private final Scanner scanner;
    private Accountreader accountreader;

    public BankReader(Scanner scanner, Accountreader accountreader) {
        this.scanner = scanner;
        this.accountreader = accountreader;
    }

    public Bank read (){
        System.out.println("Introduzca los datos del banco: ");

        System.out.println("Introduzca el nombre del banco: ");
        String name = scanner.nextLine();

        System.out.println("Ahora, introduzca la cantidad de cuentas que quiere consultar: ");
        int size = scanner.nextInt();
        scanner.nextLine();

        Account[] accounts = new Account[size];

        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountreader.read();
        }
        return new Bank(name, accounts);
    }
}