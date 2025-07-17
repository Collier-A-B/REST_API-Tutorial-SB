package collier.tutorial.rest_api_tutorials.book_example.service;

import java.util.ArrayList;

import java.util.List;

import collier.tutorial.rest_api_tutorials.book_example.model.Book;

public class BookServiceImpl implements BookService{
    private List<Book> books = new ArrayList<>();

    public BookServiceImpl() {
        // Sample data for books
        books.add(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        books.add(new Book(2, "1984", "George Orwell"));
        books.add(new Book(3, "To Kill a Mockingbird", "Harper Lee"));
    }

    @Override
    public List<Book> findAllBooks() {
        return books;
    }

    @Override
    public Book findBookById(int id) {
        return books.stream().filter(book -> book.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void deleteAllBooks() {
        books.clear();
    }
}
