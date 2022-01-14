package de.dhbw.agilesoftwaredev;

import de.dhbw.agilesoftwaredev.exceptions.NotEnoughFoundsException;

/**
 * Account class.
 */
public class Account {

    /**
     * Holders balance.
     */
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    /**
     * Deposit a specific amount from this accounts balance.
     * @param amount the amount to deposit
     * @return {@code true} if the transaction is successful. {@code False} if amount is less than zero
     */
    public boolean deposit(double amount) {
        if(amount < 0) {
            return false;
        }
        balance = balance + amount;
        return true;
    }

    /**
     * Withdraw a specific amount from this accounts balance.
     * @param amount the amount to withdraw
     * @return {@code true} if the transaction is successful. {@code False} if the transaction fails. This is the case if:
     * <ul>
     *     <li>{@code amount} is less than zero. Or if</li>
     *     <li>The account is not enough covered</li>
     * </ul>
     * @throws NotEnoughFoundsException if the account is not enough covered
     */
    public boolean withdraw(double amount) {
        if(amount < 0) {
            return false;
        }
        if(balance - amount < 0) {
            double missing = amount - balance;
            throw new NotEnoughFoundsException("Account is missing " + missing);
        }
        balance = balance - amount;
        return true;
    }

    /**
     * Return this accounts balance.
     * @return the current balance
     */
    public double getBalance() {
        return this.balance;
    }

    /**
     * Set the current balance to the given amount.
     * @param amount to set the balance to
     */
    public void setBalance(double amount) {
        this.balance = amount;
    }
}
