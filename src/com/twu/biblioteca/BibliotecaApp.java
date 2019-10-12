package com.twu.biblioteca;


import jdk.nashorn.internal.objects.annotations.Function;

import java.io.InputStream;
import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        startApp(System.in, System.out);
    }

    public static void startApp (InputStream in, PrintStream out) {
        showWelcomeMessage(out);
    }

    private static void showWelcomeMessage(PrintStream out) {
        out.println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }



}
