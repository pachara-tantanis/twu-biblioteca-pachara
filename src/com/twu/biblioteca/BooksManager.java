package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BooksManager {

    private List<String> listsOfBooks;
    private List<String> listOfCheckedOutBook;

    public BooksManager(List<String> listOfBooks) {
        this.listsOfBooks = listOfBooks;
        this.listOfCheckedOutBook = new ArrayList<String>();
    }

    public List<String> getBooksList() {
        return this.listsOfBooks;
    }

    public String checkOutBook(String bookName) {
        for (int i = 0; i < this.listsOfBooks.size(); i++) {
            String[] bookInfo = this.listsOfBooks.get(i).split(",");

            if (bookInfo[0].equals(bookName)) {
                String checkedOutBook = this.listsOfBooks.remove(i);
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
                this.listsOfBooks.add(returnBook);
                return "Thank you for returning the book";
            }
        }
        return "This is not a valid book to return.";
    }
}
