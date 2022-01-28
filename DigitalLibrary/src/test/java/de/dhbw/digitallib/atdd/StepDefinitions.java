package de.dhbw.digitallib.atdd;

import de.dhbw.digitallib.Book;
import de.dhbw.digitallib.BookShelf;
import io.cucumber.java8.En;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Step definitions
 */
public class StepDefinitions implements En {

    private final BookShelf bookShelf;
    private List<Book> bookList;

    public StepDefinitions() {
        this.bookList = new ArrayList<>();
        this.bookShelf = new BookShelf();
        this.bookShelf.add(
                new Book("Test", "Test-Titel", LocalDate.EPOCH),
                new Book("Peter", "Peters Buch", LocalDate.MIN)
        );

        Given("the bookshelf contains {int} books", (Integer amount) -> assertThat(bookShelf.getBooks()).hasSize(amount));
        When("the user searches the bookshelf by author {string}", (String name) -> bookList = bookShelf.findByAuthor(name));
        Then("the bookshelf should return a list of {int} book with the corresponding author", (Integer amount) -> assertThat(bookList).hasSize(amount));
    }
}
