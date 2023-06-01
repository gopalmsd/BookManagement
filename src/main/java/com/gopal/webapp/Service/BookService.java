package com.gopal.webapp.Service;

import java.util.List;

import com.gopal.webapp.Exception.BookAlreadyPresentException;
import com.gopal.webapp.Model.Book;

public interface BookService {
	
	
	public List<Book> getAllBook();
	public Book addBook(Book book) throws BookAlreadyPresentException;
	public boolean deleteBook(int bid);
	public boolean updateBook(Book book);
	public Book getBookbyId(int bid);
}
