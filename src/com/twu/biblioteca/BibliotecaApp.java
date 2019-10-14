package com.twu.biblioteca;


import jdk.nashorn.internal.objects.annotations.Function;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        BooksManager booksManager = new BooksManager(new ArrayList<String>());
        startApp(System.in, System.out, booksManager);
    }

    public static void startApp (InputStream in, PrintStream out, BooksManager booksManager) {
        showWelcomeMessage(out);
        showMenu(out);
    }

    private static void showMenu(PrintStream out) {
        out.println("List of books");
    }

    private static void showWelcomeMessage(PrintStream out) {
        out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }



}
