package com.lti.ebook.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.ebook.model.Book;
import com.lti.ebook.repository.BookRepository;

@Service
public class BookService implements IBookService{

	private final Logger LOG= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	BookRepository bookRepo;
	
	@Override
	public List<Book> getBooksByTitle(String title) {
		// TODO Auto-generated method stub
		Optional<List<Book>> books=bookRepo.findByTitleContaining(title);
		
		if(books.isEmpty())
		{
			String message="Book with "+title+" not found ";
			LOG.warn(message);
			throw new RuntimeException(message);

		}
		else
		return books.get();
	}

}
