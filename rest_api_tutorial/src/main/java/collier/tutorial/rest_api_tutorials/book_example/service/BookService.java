package collier.tutorial.rest_api_tutorials.book_example.service;

import java.util.List;

import collier.tutorial.rest_api_tutorials.book_example.model.Book;

public interface  BookService {
    List<Book> findAllBooks();
    Book findBookById(int id);
    void deleteAllBooks();
}
