package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    @Test
    public void shouldHaveWelcomeMessageAtFirstLine() {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        BibliotecaApp.startApp(System.in, out);
        String[] outLines = outStream.toString().split("\n");
        assertEquals("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!", outLines[0]);
    }

    @Test
    public void shouldQuitWhenInputIsQuit() {
        BibliotecaApp.main(new String[] {});

    }


}
