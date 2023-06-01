package com.gopal.webapp.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopal.webapp.Exception.BookAlreadyPresentException;
import com.gopal.webapp.Model.Book;
import com.gopal.webapp.Repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{
	@Autowired
	private BookRepository bookrepo;

	
	
	@Override
	public List<Book> getAllBook() {
		List<Book> bookList = bookrepo.findAll();
		if(bookList != null && bookList.size()>0) {
			return bookList;
		}
		else
		return null;
	}

	@Override
	public Book addBook(Book book)throws BookAlreadyPresentException {
		Optional<Book> opobj =bookrepo.findById(book.getBookId());
		if(opobj.isPresent()) {
			throw new BookAlreadyPresentException();
		}
		else
			return bookrepo.saveAndFlush(book);
	}

	@Override
	public boolean deleteBook(int bid) {
		bookrepo.deleteById(bid);
		return true;
	}

	@Override
	public boolean updateBook(Book book) {
		Book book1 = bookrepo.getById(book.getBookId());
				if(book1 != null) {
					book1.setBookPrice(book.getBookPrice());
					bookrepo.saveAndFlush(book1);
				}
		return true;
	}

	@Override
	public Book getBookbyId(int bid) {
		Optional <Book> book =bookrepo.findById(bid);
		if(book.isPresent()) {
			return book.get();
		}
		return null;
	}

}
