package collier.tutorial.rest_api_tutorials.book_example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import collier.tutorial.rest_api_tutorials.book_example.model.Book;
import collier.tutorial.rest_api_tutorials.book_example.service.BookService;

@RestController
@RequestMapping("/api")
public class ExController {
	 @Autowired
	    private BookService bookService;

	    @GetMapping("/")
	    public String home() {
	        return "Welcome to the Book API!";
	    }

	    @GetMapping("/findbyid/{id}")
	    public Book findBookById(@PathVariable int id) {
	        return bookService.findBookById(id);
	    }

	    @GetMapping("/findall")
	    public List<Book> findAllBooks() {
	        return bookService.findAllBooks();
	    }

	    @DeleteMapping("/delete")
	    public String deleteAllBooks() {
	        bookService.deleteAllBooks();
	        return "All books have been deleted.";
	    }

}
