package de.dhbw.digitallib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {

    private final List<Book> books = new ArrayList<>();

    public List<Book> books() {
        return this.books;
    }

    public void add(Book... books) {
        this.books.addAll(Arrays.asList(books));
    }

    public void remove(Book bookToRemove) {
        this.books.remove(bookToRemove);
    }

    public List<Book> findByAuthor(String author) {
        return this.books.stream()
                .filter(book -> book.getAuthor().contains(author))
                .collect(Collectors.toList());
    }
}
