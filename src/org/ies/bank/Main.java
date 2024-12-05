package org.ies.bank;

import org.ies.bank.components.Accountreader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerReader customerReader = new CustomerReader(scanner);
        Accountreader accountreader = new Accountreader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner, accountreader);
        BankApp bankApp = new BankApp(scanner, bankReader);

        bankApp.run();
    }
}