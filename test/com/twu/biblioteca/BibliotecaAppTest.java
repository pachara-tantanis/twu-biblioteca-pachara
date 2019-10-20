package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaAppTest {

    class MockBookManager extends RentalManager {
        public Boolean checkOutCalled = false;
        public Boolean returnBookCalled = false;

        public MockBookManager(List<String> listOfBooks) {
            super(listOfBooks);
        }

        @Override
        public boolean checkOutBook(String bookName) {
            checkOutCalled = true;
            return bookName.equals("return true");
        }

        @Override
        public boolean returnBook(String bookName) {
            returnBookCalled = true;
            return bookName.equals("success");
        }
    }

    public ByteArrayInputStream inputStream;
    public ByteArrayOutputStream outStream;
    public PrintStream out;

    public List<String> listOfBook;
    public RentalManager rentalManager;

    @Before
    public void createMockInputOutput() {
        inputStream = new ByteArrayInputStream("Quit".getBytes());
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
    }

    @Before
    public void createBookManager() {
        listOfBook = new ArrayList<String>();
        listOfBook.add("Book A,John,1999");
        listOfBook.add("Book B,Alis,2010");
        rentalManager = new RentalManager(listOfBook);
    }

    @Test
    public void shouldHaveWelcomeMessageAtFirstLine() {
        BibliotecaApp.startApp(inputStream, out, rentalManager);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!", outLines[0]);
    }

    @Test
    public void shouldShowMenu() {
        BibliotecaApp.startApp(inputStream, out, rentalManager);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("List of books", outLines[1]);
    }

    @Test
    public void shouldReturnListOfBookGivenListOfBook() {
        ByteArrayInputStream inStream = new ByteArrayInputStream("List of books".getBytes());

        BibliotecaApp.startApp(inStream, out, rentalManager);
        String[] outLines = outStream.toString().split("\n");
        String[] outListOfBooks = Arrays.copyOfRange(outLines, 2,outLines.length);
        assertEquals(listOfBook, Arrays.asList(outListOfBooks));
    }

    @Test
    public void shouldCallCheckOutGivenCheckOutBookName() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("check-out Refactoring".getBytes());
        BibliotecaApp.startApp(inStream, out, mockBookManager);
        assertTrue(mockBookManager.checkOutCalled);
    }

    @Test
    public void shouldReturnSuccessMessageWhenCheckOutSuccess() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("check-out return true".getBytes());

        BibliotecaApp.startApp(inStream, out, mockBookManager);

        String[] outLines = outStream.toString().split("\n");
        String successMessage = outLines[2];
        assertEquals("Thank you! Enjoy the book", successMessage);
    }

    @Test
    public void shouldReturnFailMessageWhenCheckOutFalse() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("check-out return false".getBytes());

        BibliotecaApp.startApp(inStream, out, mockBookManager);

        String[] outLines = outStream.toString().split("\n");
        String failMessage = outLines[2];
        assertEquals("Sorry, that book is not available", failMessage);
    }

    @Test
    public void shouldCallReturnBookGivenReturnBookCommand() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("return Refactoring".getBytes());
        BibliotecaApp.startApp(inStream, out, mockBookManager);
        assertTrue(mockBookManager.returnBookCalled);
    }

    @Test
    public void shouldReturnSuccessMessageWhenBookReturnSuccess() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("return success".getBytes());

        BibliotecaApp.startApp(inStream, out, mockBookManager);

        String[] outLines = outStream.toString().split("\n");
        String successMessage = outLines[2];
        assertEquals("Thank you for returning the book", successMessage);
    }
    
    @Test
    public void shouldReturnFailMessageWhenBookReturnFail() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("return fail".getBytes());

        BibliotecaApp.startApp(inStream, out, mockBookManager);

        String[] outLines = outStream.toString().split("\n");
        String failMessage = outLines[2];
        assertEquals("This is not a valid book to return.", failMessage);
    }

    @Test
    public void shouldNotifiedIfGivenInvalidOption() {
        ByteArrayInputStream inStream = new ByteArrayInputStream("Invalid Option\n".getBytes());

        BibliotecaApp.startApp(inStream, out, rentalManager);
        String[] outLines = outStream.toString().split("\n");
        String notifiedMessage = outLines[2];
        assertEquals("Please select a valid option!", notifiedMessage);
    }

    @Test
    public void shouldQuitGivenQuit() {
        String quitMessage = BibliotecaApp.startApp(inputStream, out, rentalManager);
        assertEquals("quit", quitMessage);
    }

}
