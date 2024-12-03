package model;

import java.util.Objects;

public class Account {

    private String iban;
    private double saldo;
    private String cutomer;

    public Account(String iban, double saldo, String cutomer) {
        this.iban = iban;
        this.saldo = saldo;
        this.cutomer = cutomer;
    }

    public void showInfo() {
        System.out.println("IBAN: " + iban + " Saldo: " + saldo + " NIF: " + cutomer);
    }

    public void deposit(double amount) {
        saldo += amount;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getCutomer() {
        return cutomer;
    }

    public void setCutomer(String cutomer) {
        this.cutomer = cutomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(saldo, account.saldo) == 0 && Objects.equals(iban, account.iban) && Objects.equals(cutomer, account.cutomer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, saldo, cutomer);
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", saldo=" + saldo +
                ", cutomer='" + cutomer + '\'' +
                '}';
    }
}
