package de.dhbw.digitallib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookShelf {

    private final List<String> books = new ArrayList<>();

    public List<String> books() {
        return this.books;
    }

    public void add(String... books) {
        this.books.addAll(Arrays.asList(books));
    }

    public void remove(String bookToRemove) {
        this.books.remove(bookToRemove);
    }
}
