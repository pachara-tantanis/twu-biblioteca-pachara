package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {
    public ByteArrayOutputStream outStream;
    public PrintStream out;
    @Before
    public void createMockOutput() {
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
    }


    @Test
    public void shouldHaveWelcomeMessageAtFirstLine() {
        BibliotecaApp.startApp(System.in, out);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!", outLines[0]);
    }

    @Test
    public void shouldShowMenu() {
        BibliotecaApp.startApp(System.in, out);

        String[] outLines = outStream.toString().split("\n");
        assertEquals("List of books", outLines[1]);
    }




}
