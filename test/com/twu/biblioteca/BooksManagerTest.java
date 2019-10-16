package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class BooksManagerTest {

    public List<String> listOfBooks;
    public BooksManager booksManager;


    @Before
    public void createBooksManager() {
        listOfBooks = new ArrayList<String>();
        listOfBooks.add("Refactoring,Kent Beck and Martin Fowler,1999");
        listOfBooks.add("Agile samurai,Jonathan Rasmusson,2010");
        booksManager = new BooksManager(new ArrayList<String>(listOfBooks));
    }

    @Test
    public void shouldReturnAllBooks() {
        assertEquals(listOfBooks, booksManager.getBooksList());
    }

    @Test
    public void shouldRemoveCheckedOutBookFromListOfBooks() {
        listOfBooks.remove("Refactoring,Kent Beck and Martin Fowler,1999");
        booksManager.checkOutBook("Refactoring");
        assertEquals(listOfBooks, booksManager.getBooksList());
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckOutComplete() {
        boolean resultTrue = booksManager.checkOutBook("Refactoring");
        assertTrue(resultTrue);
    }

    @Test
    public void shouldReturnUnSuccessMessageOnCheckOutFail() {
        boolean resultFalse = booksManager.checkOutBook("UnSuccess");
        assertFalse(resultFalse);
    }

    @Test
    public void shouldReturnUnSuccessMessageOnBookReturnFail() {
        boolean resultFalse = booksManager.returnBook("ReturnFail");
        assertFalse(resultFalse);
    }

    @Test
    public void shouldHaveReturnedBookInlistOfBooks() {
        booksManager.checkOutBook("Refactoring");
        booksManager.returnBook("Refactoring");
        assertEquals(true, booksManager.getBooksList().contains("Refactoring,Kent Beck and Martin Fowler,1999"));
    }

    @Test
    public void shouldReturnSuccessMessageOnBookReturnComplete() {
        booksManager.checkOutBook("Refactoring");
        boolean resultTrue = booksManager.returnBook("Refactoring");
        assertTrue(resultTrue);
    }

}
