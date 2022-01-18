package de.dhbw.digitallib;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BookShelf {

    @Getter
    private final List<Book> books = new ArrayList<>();

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
