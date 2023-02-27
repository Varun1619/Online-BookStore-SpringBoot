package com.lti.ebook.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@GenericGenerator(name="book_seq",strategy="increment")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="book_seq")
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="title")
	private String title;
	
	@Column(name="author")
	private String author;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private int price;
	
	@Column(name="availability")
	private int availability;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String title, String author, String description, int price, int availability) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.availability = availability;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", author=" + author + ", description=" + description
				+ ", price=" + price + ", availability=" + availability + "]";
	}
	
	
	

}
