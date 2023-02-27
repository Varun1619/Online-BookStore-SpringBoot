package com.lti.ebook.service;

import java.util.List;

import com.lti.ebook.model.Book;

public interface IBookService {
	
	public abstract List<Book> getBooksByTitle(String title);

}
