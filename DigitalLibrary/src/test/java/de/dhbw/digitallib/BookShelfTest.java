package de.dhbw.digitallib;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookShelfTest {

    private BookShelf shelf;
    private static Book dummyBook1;
    private static Book dummyBook2;

    @BeforeAll
    static void beforeAll() {
        dummyBook1 = new Book("Raoul-Gabriel Urma", "Modern Java in Action!", LocalDate.of(2018, 9,1));
        dummyBook2 = new Book("Morgan Bruce", "Microservices in Action!", LocalDate.of(2018, 10,1));
    }

    @BeforeEach
    void setUp() {
        shelf = new BookShelf();
    }

    @Test
    void shelfEmptyWhenNoBookAdded() {
        //GIVEN
        //WHEN
        List<Book> books = shelf.getBooks();
        //THEN
        assertTrue(books.isEmpty(), "BookShelf should be empty.");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksAdded() {
        //GIVEN
        long size = shelf.getBooks().size();
        //WHEN
        shelf.add(dummyBook1);
        shelf.add(dummyBook2);
        //THEN
        assertEquals(size + 2, shelf.getBooks().size(), "Bookshelf should have two books");
    }

    @Test
    void bookshelfContainsTwoBooksWhenTwoBooksSimultanouslyAdded() {
        //GIVEN
        long size = shelf.getBooks().size();
        //WHEN
        shelf.add(dummyBook1, dummyBook2);
        //THEN
        assertEquals(size + 2, shelf.getBooks().size(), "Bookshelf should have two books");
    }

    @Test
    void removeShouldRemoveBook() {
        //GIVEN
        shelf.add(dummyBook1, dummyBook2);
        long size = shelf.getBooks().size();
        //WHEN
        shelf.remove(dummyBook1);
        //THEN
        assertEquals(shelf.getBooks().size(), size - 1);
    }

    @Test
    void removeShouldDoNothingWhenBookNotInShelf() {
        //GIVEN
        shelf.add(dummyBook1);
        long size = shelf.getBooks().size();
        //WHEN
        shelf.remove(dummyBook2);
        //THEN
        assertEquals(shelf.getBooks().size(), size);
    }

    @Test
    void findByAuthor_Should_returnCorrectAmountOfBooks() {
        //GIVEN
        shelf.add(dummyBook1, dummyBook2);
        //WHEN
        List<Book> authorBooks = shelf.findByAuthor("Bruce");
        //THEN
        assertEquals(authorBooks.size(), 1);
        assertEquals(authorBooks.get(0), dummyBook2);
    }

    @Test
    void findByAuthor_should_returnNoBooksIfNoMatches() {
        //GIVEN
        shelf.add(dummyBook1, dummyBook2);
        //WHEN
        List<Book> authorBooks = shelf.findByAuthor("J.R.R Tolkien");
        //THEN
        assertEquals(authorBooks.size(), 0);
    }
}
