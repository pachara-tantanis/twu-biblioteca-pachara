package com.twu.biblioteca;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        RentalManager booksManager = new RentalManager(readListOfBooks());
        startApp(System.in, System.out, booksManager);
    }

    public static String startApp(InputStream in, PrintStream out, RentalManager booksManager) {
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
                String bookName = getBookNameFromInput(splitCommand);
                boolean checkOutResult = booksManager.checkOutBook(bookName);
                String message = checkOutResult ? "Thank you! Enjoy the book" : "Sorry, that book is not available";
                out.println(message);
            } else if (splitCommand[0].equals("return")) {
                String bookName = getBookNameFromInput(splitCommand);
                boolean returnResult = booksManager.returnBook(bookName);
                String message = returnResult ? "Thank you for returning the book" : "This is not a valid book to return.";
                out.println(message);
            } else if (command.equals("Quit")) {
                return "quit";
            } else {
                out.println("Please select a valid option!");
            }
        }
        return "";
    }

    public static String getBookNameFromInput(String[] splitCommand) {
        return String.join(" ", Arrays.copyOfRange(splitCommand, 1, splitCommand.length));
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
