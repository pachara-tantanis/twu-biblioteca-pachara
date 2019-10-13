package com.twu.biblioteca;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;



public class BooksManagerTest {

    public List<String> listOfBooks;
    public BooksManager booksManager;


    @Before
    public void createBooksManager() {
        listOfBooks = new ArrayList<String>();
        listOfBooks.add("Refactoring");
        listOfBooks.add("Agile samurai");
        booksManager = new BooksManager(listOfBooks);
    }

    @Test
    public void shouldReturnAllBooks() {
        assertEquals(listOfBooks, booksManager.getBooksList());
    }
}
