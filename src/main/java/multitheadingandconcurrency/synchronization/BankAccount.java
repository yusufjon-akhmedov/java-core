package multitheadingandconcurrency.synchronization;

import java.util.Objects;

public class BankAccount {

    private double balance;
    private String name;


    private final Object lockName = new Object();
    private final Object lockBalance = new Object();


    // constructor for balance variable
    public BankAccount(String name, double balance) {
        this.balance = balance;
        this.name = name;
    }

    //getter for name
    public String getName() {
        return name;
    }

    //setter for name
    public synchronized void setName(String name) {

        synchronized (lockName) {
            this.name = name;
            System.out.println("Updated name = " + this.name);
        }
    }

    // getter for balance variable
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        try {
            System.out.println("Deposit - Talking to the teller at the bank...");
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        synchronized (lockBalance) {
            double originalBalance = balance;
            balance += amount;
            System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f)" + " : NEW BALANCE = %.0f%n", originalBalance, amount, balance);
            addPromoDollars(amount);
        }

    }

    private void addPromoDollars(double amount) {

        if (amount >= 500) {
            synchronized (lockBalance) {
                System.out.println("Congratulations, you earned a promotional deposit. ");
                balance += 25;
            }
        }
    }

    public synchronized void withdraw(double amount) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        double originalBalance = balance;
        if (amount <= balance) {
            balance -= amount;
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" + " : NEW BALANCE = %.0f%n", originalBalance, amount, balance);
        } else {
            System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f)" + "INSUFFICIENT FUNDS!", originalBalance, amount);
        }
    }
}
