package de.dhbw.digitallib;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * Book entity.
 */
@Data
@AllArgsConstructor
public class Book {
    private String author;
    private String title;
    private LocalDate publishDate;
}
