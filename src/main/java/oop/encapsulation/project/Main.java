package oop.encapsulation.project;

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount("ACC-123", 1000);

        account.deposit(500);
        account.withdraw(300);

        System.out.println("Account: " + account.getAccountNumber());
        System.out.println("Balance: " + account.getBalance());
    }
}
