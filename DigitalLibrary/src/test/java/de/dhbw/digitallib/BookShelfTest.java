package de.dhbw.digitallib;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookShelfTest {

    private BookShelf shelf;

    @BeforeEach
    void setUp() {
        shelf = new BookShelf();
    }

    @Test
    void shelfEmptyWhenNoBookAdded() {
        List<String> books = shelf.books();
        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        shelf.add("JUnit 5");
        shelf.add("Clean Code");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), "Bookshelf should have two books");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksSimultanouslyAdded() {
        shelf.add("JUnit 5", "Clean Code");
        List<String> books = shelf.books();
        assertEquals(2, books.size(), "Bookshelf should have two books");
    }

    @Test
    void removeShouldRemoveBook() {
        shelf.add("Junit 5", "Clean Code");
        long size = shelf.books().size();
        shelf.remove("Clean Code");
        List<String> books = shelf.books();
        assertEquals(books.size(), size - 1);
    }

    @Test
    void removeShouldDoNothingWhenBookNotInShelf() {
        shelf.add("Junit 5", "Clean Code");
        long size = shelf.books().size();
        shelf.remove("Spring in Action!");
        List<String> books = shelf.books();
        assertEquals(books.size(), size);
    }
}
