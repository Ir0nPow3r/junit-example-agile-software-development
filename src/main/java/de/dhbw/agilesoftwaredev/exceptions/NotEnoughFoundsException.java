package de.dhbw.agilesoftwaredev.exceptions;

/**
 * Exception to be thrown when {@link de.dhbw.agilesoftwaredev.Account} is not covered.
 */
public class NotEnoughFoundsException extends RuntimeException {

    public NotEnoughFoundsException(String message) {
        super(message);
    }
}