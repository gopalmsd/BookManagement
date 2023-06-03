package com.gopal.webapp.Model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book {	
	
	@Id
	private int bookId;
	private String bookName;
	private double bookPrice;
	private String readerName;
	
	@OneToMany(targetEntity=Reader.class)
	private Set<Reader> readerList;
	public int getBookId() {
		return bookId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}
	public Set<Reader> getReaderList() {
		return readerList;
	}
	public void setReaderList(Set<Reader> readerList) {
		this.readerList = readerList;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public Book(int bookId, String bookName, double bookPrice) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
	}
	public Book() {
		super();
		
	}
}
