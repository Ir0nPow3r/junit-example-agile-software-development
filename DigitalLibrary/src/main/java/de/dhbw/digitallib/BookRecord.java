package de.dhbw.digitallib;

import java.time.LocalDate;

/**
 * {@link Book} class as record.
 */
public record BookRecord(String author, String title, LocalDate publishDate) {}
