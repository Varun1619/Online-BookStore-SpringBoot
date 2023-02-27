package com.lti.ebook.service;

import java.util.List;

import com.lti.ebook.model.Book;

public interface IBookService {
	
	public abstract Book addBooks(Book book);
	public abstract Book removeBooks(int id);
	public abstract List<Book> getBooksByTitle(String title);
	public abstract List<Book> getBooksByAuthor(String author);

}
