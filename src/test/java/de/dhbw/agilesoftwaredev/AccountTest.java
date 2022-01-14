package de.dhbw.agilesoftwaredev;

import de.dhbw.agilesoftwaredev.exceptions.NotEnoughFoundsException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit Tests for {@link Account} class.
 */
public class AccountTest {

    private static Account account;
    private static final double INITIAL_ACCOUNT_BALANCE = 5000d;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Create account.");
        account = new Account(INITIAL_ACCOUNT_BALANCE);
    }

    @BeforeEach
    void setUp() {
        account.setBalance(INITIAL_ACCOUNT_BALANCE);
    }

    @Test
    @DisplayName("Abfrage des Kontostands liefert den richtigen Betrag")
    void testAccountBalance() {
        double balanceBefore = account.getBalance();
        account.deposit(0);
        assertEquals(balanceBefore, account.getBalance());
    }

    @Test
    @DisplayName("Zwei Einzahlungen werden als Summe gebucht")
    void depositTest() {
        account.deposit(500);
        account.deposit(200);
        assertEquals((INITIAL_ACCOUNT_BALANCE + 500 + 200), account.getBalance());
    }

    @Test
    @DisplayName("Einzahlung von 0 ändert nicht den Kontostand")
    void depositZeroTest() {
        double balanceBefore = account.getBalance();
        account.deposit(0);
        assertEquals(balanceBefore, account.getBalance());
    }

    @Test
    @DisplayName("Abheben von negativen Werten schlägt fehl")
    void depositNegativeTest() {
        double balanceBefore = account.getBalance();
        boolean success = account.deposit(-100);
        assertFalse(success);
        assertEquals(balanceBefore, account.getBalance());
    }

    @Test
    @DisplayName("Abhebung über Limit sollte Exception auslösen")
    void withdrawUncovered_should_throwException() {
        assertThrows(NotEnoughFoundsException.class,
                () -> account.withdraw(INITIAL_ACCOUNT_BALANCE + 1));
    }

    @Test
    @DisplayName("Auszahlung von 0 ändert nicht den Kontostand")
    void withdrawZeroTest() {
        double balanceBefore = account.getBalance();
        account.withdraw(0);
        assertEquals(balanceBefore, account.getBalance());
    }

    @Test
    @DisplayName("Zwei Abhebungen werden als Summe abgebucht")
    void withdrawTest() {
        account.withdraw(500);
        account.withdraw(200);
        assertEquals((INITIAL_ACCOUNT_BALANCE - 500 -200), account.getBalance());
    }

    @Test
    @DisplayName("Auszahlung von negativen Werten schlägt fehl")
    void withdrawNegativeTest() {
        double balanceBefore = account.getBalance();
        boolean success = account.withdraw(-100);
        assertFalse(success);
        assertEquals(balanceBefore, account.getBalance());
    }
}
