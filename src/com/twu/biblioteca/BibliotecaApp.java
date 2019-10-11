package com.twu.biblioteca;


public class BibliotecaApp {

    public static String recentMessage = "";
    public static void main(String[] args) {
    }

    public static String println(String message) {
        recentMessage = message;
        System.out.println(message);
    }
}
