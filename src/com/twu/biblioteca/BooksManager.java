package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {

    private List<String> listsOfBooks;

    public BooksManager(List<String> listOfBooks) {
        this.listsOfBooks = listOfBooks;
    }

    public List<String> getBooksList() {
        return this.listsOfBooks;
    }

    public String checkOutBook(String bookName) {
        for (int i = 0; i < this.listsOfBooks.size(); i++) {
            String[] bookInfo = this.listsOfBooks.get(i).split(",");

            if (bookInfo[0].equals(bookName)) {
                this.listsOfBooks.remove(i);
                return "Thank you! Enjoy the book";
            }
        }
        return "";
    }

}
