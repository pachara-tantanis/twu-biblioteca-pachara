package com.twu.biblioteca;


import jdk.nashorn.internal.objects.annotations.Function;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntConsumer;

public class BibliotecaApp {

    public static void main(String[] args) {
        BooksManager booksManager = new BooksManager(readListOfBooks());
        startApp(System.in, System.out, booksManager);
    }

    public static String startApp(InputStream in, PrintStream out, BooksManager booksManager) {
        showWelcomeMessage(out);
        showMenu(out);
        Scanner scannerIn = new Scanner(in);
        String command = "";
        while (scannerIn.hasNextLine()) {
            command = scannerIn.nextLine();
            String[] splitCommand = command.split(" ");
            if (command.equals("List of books")) {
                List<String> listOfBooks = booksManager.getBooksList();
                listOfBooks.forEach(book -> out.println(book));
            } else if (splitCommand[0].equals("check-out")) {
                String[] bookName = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
                out.println(booksManager.checkOutBook(String.join(" ", bookName)));
            } else if (splitCommand[0].equals("return")) {
                String[] bookName = Arrays.copyOfRange(splitCommand, 1, splitCommand.length);
                out.println(booksManager.returnBook(String.join(" ", bookName)));
            } else {
                out.println("Please select a valid option!");
            }
        }
        return "";
    }

    public static List<String> readListOfBooks() {
        List<String> listOfBooks = new ArrayList<String>();
        try {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/pacharatantanis/Documents/twu/TWU_Biblioteca-master/src/com/twu/biblioteca/listOfBooks.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                listOfBooks.add(line);
            }
        } catch (Exception e) {
        }
        return listOfBooks;
    }

    private static void showMenu(PrintStream out) {
        out.println("List of books");
    }

    private static void showWelcomeMessage(PrintStream out) {
        out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

}
