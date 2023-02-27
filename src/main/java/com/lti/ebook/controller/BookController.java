package com.lti.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.lti.ebook.model.Book;
import com.lti.ebook.service.IBookService;

@RestController
public class BookController {
	
	@Autowired
	IBookService bookService;
	
	@RequestMapping(value="/get-by-title/{title}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Book>> getByTitle(@PathVariable(name="title")String title)
	{
		List<Book> bookList = bookService.getBooksByTitle(title);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Books found successfully!");
		ResponseEntity<List<Book>> response = new ResponseEntity<>(bookList, headers, status);
		return response;
	}
	
	@RequestMapping(value="/get-by-author/{author}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Book>> getByAuthor(@PathVariable(name="author")String author)
	{
		List<Book> bookList = bookService.getBooksByAuthor(author);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Books found successfully!");
		ResponseEntity<List<Book>> response = new ResponseEntity<>(bookList, headers, status);
		return response;
	}
	
	@RequestMapping(value="/add-book",method = RequestMethod.POST, produces = "application/json",consumes = "application/json")
	public ResponseEntity<Book> addBook(@RequestBody Book book)
	{
		HttpHeaders headers=new HttpHeaders();
		headers.add("Message","book added successfully");
		ResponseEntity<Book> response= new ResponseEntity<>(bookService.addBooks(book),headers,HttpStatus.CREATED);
		return response;
	}
	
	@RequestMapping(value="/remove-book/{id}",method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Book> removeBook(@PathVariable(name="id")int id)
	{
		Book book = bookService.removeBooks(id);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Message", "Books deleted successfully!");
		ResponseEntity<Book> response = new ResponseEntity<>(book, headers, status);
		return response;
	}

}
