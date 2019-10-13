package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {

    private List<String> listsOfBooks;

    public BooksManager(List<String> listOfBooks) {
        this.listsOfBooks = listOfBooks;
    }

    public List<String> getBooksList() {
        return  this.listsOfBooks;
    }

    public void checkOutBook(String book) {

    }

}
