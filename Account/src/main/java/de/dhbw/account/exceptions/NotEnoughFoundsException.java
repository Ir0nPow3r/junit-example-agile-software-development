package de.dhbw.account.exceptions;

import de.dhbw.account.Account;

/**
 * Exception to be thrown when {@link Account} is not covered.
 */
public class NotEnoughFoundsException extends RuntimeException {

    public NotEnoughFoundsException(String message) {
        super(message);
    }
}