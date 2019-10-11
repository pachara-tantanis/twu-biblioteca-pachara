package com.twu.biblioteca;


public class BibliotecaApp {

    public static String recentMessage = "";
    public static void main(String[] args) {
        println("Welcome to Biblioteca. You one-stop-shop for great book titles in Bangalore!");
    }

    public static void println(String message) {
        recentMessage = message;
        System.out.println(message);
    }
}
