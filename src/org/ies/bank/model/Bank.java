package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {

    private String name;
    private Account[] accounts;

    public void showAccounts() {
        for (Account account: accounts) {
            account.showInfo();
        }
    }

    public Account findAccount (String iban) {
        for  (Account account: accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public void ibanInfoAccount(String iban) {
        Account account = findAccount(iban);
        if (account != null) {
            account.showInfo();
        }
    }

    public void nifInfoAccount(String nif) {
        for (Account account: accounts) {
            if (account.getCutomer().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void depositAccount(String iban, double amount) {
        Account account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public int customerAccounts (String nif) {
        for(Account account: accounts) {
            if(account.getCutomer().equals(nif)) {
                return accounts.length;
            }
        }
        return 0;
    }

    public String customerData (String iban) {
        Account account = findAccount(iban);

        if (account != null) {
            return account.getCutomer();
        } else {
            return null;
        }
    }

    public Bank(String name, Account[] accounts) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}