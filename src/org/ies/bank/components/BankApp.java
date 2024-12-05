package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {

    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }
    
    public void run() {

        Bank bank = bankReader.read();
        
        int option;
        
        do {
            option = chooseOption();
            
            if(option == 1) {
                // Mostrar cuentas
                bank.showAccounts();
            } else if (option == 2) {
                //Mostrar por iban
                System.out.println("Introduce un IBAN.");
                String iban = scanner.nextLine();
                bank.ibanInfoAccount(iban);
            } else if (option == 3) {
                //Mostrar por nif
                System.out.println("Introduce un NIF.");
                String nif = scanner.nextLine();
                bank.nifInfoAccount(nif);
            } else if (option == 4) {
                //Ingreso por IBAN
                System.out.println("Introduce un IBAN.");
                String iban = scanner.nextLine();
                System.out.println("Ahora, introduzca la cantidad de dinero que desea depositar.");
                double amount = askAmount();
                scanner.nextLine();
                bank.depositAccount(iban, amount);
            } else if (option == 5) {
                //Sacar dinero por IBAN
                System.out.println("Introduce un IBAN.");
                String iban = scanner.nextLine();
                System.out.println("Ahora, introduzca la cantidad que desea sacar.");
                double amount = askAmount();
                scanner.nextLine();
                bank.depositAccount(iban, -amount);
            } else if (option == 6) {
                System.out.println("Saliendo...");
            } else {
                System.out.println("Opción incorrecta, inténtalo de nuevo.");
            }

        }while (option != 6);
        
    }

    private double askAmount() {
        double amount;

        do {
            amount = scanner.nextDouble();
            scanner.nextLine();
            if (amount < 0) {
                System.out.println("cantidad no valida, introduzca otra.");

            }
        }while (amount < 0);
        return amount;
    }
    
    private int chooseOption() {
        System.out.println("1.Mostrar las cuentas del banco.");
        System.out.println("2.Mostrar datos de una cuenta.");
        System.out.println("3.Mostrar los datos de las cuentas de un cliente.");
        System.out.println("4.Ingresar dinero en cuenta.");
        System.out.println("5.Sacar dinero de una cuenta.");
        System.out.println("6.Salir");
        int option = scanner.nextInt();
        scanner.nextLine();
        return option;
    }
}
