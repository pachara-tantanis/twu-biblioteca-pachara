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
        listOfBooks.add("Refactoring,Kent Beck and Martin Fowler,1999");
        listOfBooks.add("Agile samurai,Jonathan Rasmusson,2010");
        booksManager = new BooksManager(listOfBooks);
    }

    @Test
    public void shouldReturnAllBooks() {
        assertEquals(listOfBooks, booksManager.getBooksList());
    }
}
