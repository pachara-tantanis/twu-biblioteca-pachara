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

    class MockBookManager extends BooksManager {
        public Boolean checkOutCalled = false;
        public Boolean returnBookCalled = false;

        public MockBookManager(List<String> listOfBooks) {
            super(listOfBooks);
        }

        @Override
        public boolean checkOutBook(String bookName) {
            checkOutCalled = true;
            return true;
        }

        @Override
        public boolean returnBook(String bookName) {
            returnBookCalled = true;
            return true;
        }
    }

    public ByteArrayInputStream inputStream;
    public ByteArrayOutputStream outStream;
    public PrintStream out;

    public List<String> listOfBook;
    public BooksManager booksManager;

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
        booksManager = new BooksManager(listOfBook);
    }

    @Test
    public void shouldHaveWelcomeMessageAtFirstLine() {
        BibliotecaApp.startApp(inputStream, out, booksManager);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!", outLines[0]);
    }

    @Test
    public void shouldShowMenu() {
        BibliotecaApp.startApp(inputStream, out, booksManager);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("List of books", outLines[1]);
    }

    @Test
    public void shouldReturnListOfBookGivenListOfBook() {
        ByteArrayInputStream inStream = new ByteArrayInputStream("List of books".getBytes());

        BibliotecaApp.startApp(inStream, out, booksManager);
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
    public void shouldCallReturnBookGivenReturnBookCommand() {
        MockBookManager mockBookManager = new MockBookManager(new ArrayList<String>());
        ByteArrayInputStream inStream = new ByteArrayInputStream("return Refactoring".getBytes());
        BibliotecaApp.startApp(inStream, out, mockBookManager);
        assertTrue(mockBookManager.returnBookCalled);
    }

    @Test
    public void shouldNotifiedIfGivenInvalidOption() {
        ByteArrayInputStream inStream = new ByteArrayInputStream("Invalid Option\n".getBytes());

        BibliotecaApp.startApp(inStream, out, booksManager);
        String[] outLines = outStream.toString().split("\n");
        String notifiedMessage = outLines[2];
        assertEquals("Please select a valid option!", notifiedMessage);
    }

    @Test
    public void shouldQuitGivenQuit() {
        String quitMessage = BibliotecaApp.startApp(inputStream, out, booksManager);
        assertEquals("quit", quitMessage);
    }

}
