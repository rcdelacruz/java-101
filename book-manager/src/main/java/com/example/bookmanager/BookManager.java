package com.example.bookmanager;

import java.util.ArrayList;
import java.util.List;

public class BookManager {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void listBooks() {
        books.forEach(System.out::println);
    }

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book("The Hobbit", "J.R.R. Tolkien"));
        manager.addBook(new Book("1984", "George Orwell"));
        manager.addBook(new Book("Harry Potter", "J.K. Rowling"));
        manager.listBooks();
    }

}
