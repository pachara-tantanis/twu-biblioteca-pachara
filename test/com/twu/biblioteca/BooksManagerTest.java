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
        String successMessage = booksManager.checkOutBook("Refactoring");
        assertEquals("Thank you! Enjoy the book", successMessage);
    }

    @Test
    public void shouldReturnUnSuccessMessageOnCheckOutFail() {
        String unSuccessMessage = booksManager.checkOutBook("UnSuccess");
        assertEquals("Sorry, that book is not available", unSuccessMessage);
    }
//
//    @Test
//    public void shouldReturnUnSuccessMessageOnBookReturnFail() {
//        String message
//    }

}
