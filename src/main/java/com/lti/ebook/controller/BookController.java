package com.lti.ebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

}
