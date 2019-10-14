package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {

    private List<String> listOfBooks;
    private List<String> listOfCheckedOutBook;

    public BooksManager(List<String> listOfBooks) {
        this.listOfBooks = listOfBooks;
        this.listOfCheckedOutBook = new ArrayList<String>();
    }

    public List<String> getBooksList() {
        return this.listOfBooks;
    }

    public String checkOutBook(String bookName) {
        for (int i = 0; i < this.listOfBooks.size(); i++) {
            String[] bookInfo = this.listOfBooks.get(i).split(",");

            if (bookInfo[0].equals(bookName)) {
                String checkedOutBook = this.listOfBooks.remove(i);
                this.listOfCheckedOutBook.add(checkedOutBook);
                return "Thank you! Enjoy the book";
            }
        }
        return "Sorry, that book is not available";
    }

    public String returnBook(String bookName) {
        for(int i = 0; i < this.listOfCheckedOutBook.size(); i++) {
            String[] bookInfo = this.listOfCheckedOutBook.get(i).split(",");

            if (bookInfo[0].equals(bookName)) {
                String returnBook = this.listOfCheckedOutBook.remove(i);
                this.listOfBooks.add(returnBook);
                return "Thank you for returning the book";
            }
        }
        return "This is not a valid book to return.";
    }
}
