package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class RentalManager {

    private List<String> listOfBooks;
    private List<String> listOfCheckedOutBook;

    public RentalManager(List<String> listOfBooks) {
        this.listOfBooks = listOfBooks;
        this.listOfCheckedOutBook = new ArrayList<String>();
    }

    public List<String> getBooksList() {
        return this.listOfBooks;
    }

    public boolean checkOutBook(String bookName) {
        int bookIndex = getBookNameIndexFromList(this.listOfBooks, bookName);
        if (bookIndex != -1) {
            String checkedOutBook = this.listOfBooks.remove(bookIndex);
            this.listOfCheckedOutBook.add(checkedOutBook);
            return true;
        }
        return false;
    }

    public boolean returnBook(String bookName) {
        int bookIndex = getBookNameIndexFromList(this.listOfCheckedOutBook, bookName);
        if (bookIndex != -1) {
            String returnBook = this.listOfCheckedOutBook.remove(bookIndex);
            this.listOfBooks.add(returnBook);
            return true;
        }
        return false;
    }

    private int getBookNameIndexFromList(List<String> listOfBooks, String bookName) {
        for (int i = 0; i < listOfBooks.size(); i++) {
            String[] bookInfo = listOfBooks.get(i).split(",");
            if (bookInfo[0].equals(bookName)) {
                return i;
            }
        }
        return -1;
    }
}
