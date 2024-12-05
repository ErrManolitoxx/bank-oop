package org.ies.bank.components;

import org.ies.bank.model.Customer;

import java.util.Scanner;

public class CustomerReader {

    private final Scanner scanner;

    public CustomerReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Customer read () {
        System.out.println("Por favor, introduzca los datos del cliente: ");

        System.out.println("Introduzca el NIF del cliente: ");
        String nif = scanner.nextLine();

        System.out.println("Introduzca el nombre: ");
        String name = scanner.nextLine();

        System.out.println("Introduzca sus apellidos: ");
        String surname = scanner.nextLine();

        return new Customer(nif, name, surname);
    }
}
