package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class RentalManagerTest {

    public List<String> listOfBooks;
    public RentalManager rentalManager;


    @Before
    public void createBooksManager() {
        listOfBooks = new ArrayList<String>();
        listOfBooks.add("Refactoring,Kent Beck and Martin Fowler,1999");
        listOfBooks.add("Agile samurai,Jonathan Rasmusson,2010");
        rentalManager = new RentalManager(new ArrayList<String>(listOfBooks));
    }

    @Test
    public void shouldReturnAllBooks() {
        assertEquals(listOfBooks, rentalManager.getBooksList());
    }

    @Test
    public void shouldRemoveCheckedOutBookFromListOfBooks() {
        listOfBooks.remove("Refactoring,Kent Beck and Martin Fowler,1999");
        rentalManager.checkOutBook("Refactoring");
        assertEquals(listOfBooks, rentalManager.getBooksList());
    }

    @Test
    public void shouldReturnSuccessMessageOnCheckOutComplete() {
        boolean resultTrue = rentalManager.checkOutBook("Refactoring");
        assertTrue(resultTrue);
    }

    @Test
    public void shouldReturnUnSuccessMessageOnCheckOutFail() {
        boolean resultFalse = rentalManager.checkOutBook("UnSuccess");
        assertFalse(resultFalse);
    }

    @Test
    public void shouldReturnUnSuccessMessageOnBookReturnFail() {
        boolean resultFalse = rentalManager.returnBook("ReturnFail");
        assertFalse(resultFalse);
    }

    @Test
    public void shouldHaveReturnedBookInlistOfBooks() {
        rentalManager.checkOutBook("Refactoring");
        rentalManager.returnBook("Refactoring");
        assertEquals(true, rentalManager.getBooksList().contains("Refactoring,Kent Beck and Martin Fowler,1999"));
    }

    @Test
    public void shouldReturnSuccessMessageOnBookReturnComplete() {
        rentalManager.checkOutBook("Refactoring");
        boolean resultTrue = rentalManager.returnBook("Refactoring");
        assertTrue(resultTrue);
    }

}
