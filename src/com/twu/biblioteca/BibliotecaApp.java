package com.twu.biblioteca;


import jdk.nashorn.internal.objects.annotations.Function;

import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntConsumer;

public class BibliotecaApp {

    public static void main(String[] args) {
        BooksManager booksManager = new BooksManager(new ArrayList<String>());
        startApp(System.in, System.out, booksManager);
    }

    public static void startApp(InputStream in, PrintStream out, BooksManager booksManager) {
        showWelcomeMessage(out);
        showMenu(out);
        Scanner scannerIn = new Scanner(in);
        String command = scannerIn.nextLine();
        String[] splitedCommand = command.split(" ");
        if (command.equals("List of books")) {
            List<String> listOfBooks = booksManager.getBooksList();
            listOfBooks.forEach(book -> out.println(book));
        } else if (splitedCommand[0].equals("check-out")) {
            String[] bookName = Arrays.copyOfRange(splitedCommand, 1, splitedCommand.length);
            out.println(booksManager.checkOutBook(String.join(" ", bookName)));
        } else if (splitedCommand[0].equals("return")) {
            String[] bookName = Arrays.copyOfRange(splitedCommand, 1, splitedCommand.length);
            out.println(booksManager.returnBook(String.join(" ", bookName)));
        }
    }

    private static void showMenu(PrintStream out) {
        out.println("List of books");
    }

    private static void showWelcomeMessage(PrintStream out) {
        out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

}
