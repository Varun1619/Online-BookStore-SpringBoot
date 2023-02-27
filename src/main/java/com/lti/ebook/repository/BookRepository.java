package com.lti.ebook.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lti.ebook.model.Book;


@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	
	public abstract Optional<List<Book>> findByTitleContaining(String title);
	public abstract Optional<List<Book>> findByAuthorContaining(String author);
	

}
