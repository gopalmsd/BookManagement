package com.gopal.webapp.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.webapp.Exception.BookAlreadyPresentException;
import com.gopal.webapp.Model.Book;
import com.gopal.webapp.Model.Reader;
import com.gopal.webapp.Service.BookService;
import com.gopal.webapp.Service.ReaderService;

@RestController
@RequestMapping("book/api")
public class BookController {
	@Autowired
	private BookService bookserv;
	
	@Autowired
	private ReaderService rs;
	
	@PostMapping("/addbook")
	public ResponseEntity<?> addBook(@RequestBody Book book) throws BookAlreadyPresentException{
		
		if(bookserv.addBook(book)!=null) {
		return new ResponseEntity<>(HttpStatus.CREATED) ;
		}
		else
			return new ResponseEntity<>(HttpStatus.CONFLICT);
	}
	
	@GetMapping("/getallbook")
	public ResponseEntity<?> getaAllBook(){
		List<Book> bookList =bookserv.getAllBook();
		
		if(bookList != null) {
			
			for(Book b: bookList) {
				Set<Reader> readerList =rs.getAllReaders(b.getBookId());
				b.setReaderList(readerList);
			}
			return new ResponseEntity<List<Book>>(bookList ,HttpStatus.OK);
		}
		else 
			return new ResponseEntity<String> ("bookList is Null" ,HttpStatus.NO_CONTENT);
		
	}
	
	@DeleteMapping("/delete/{bid}")
	public ResponseEntity<?> deleteBook(@PathVariable("bid") int bid){
		if(bookserv.deleteBook(bid) & rs.deleteReader(bid)) {
			return new ResponseEntity<String>("yeah Book Is Deleted",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Book is not deleted from table",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateBook(@RequestBody Book book){
		if (bookserv.updateBook(book)) {
			return new ResponseEntity<String>("Book Updated in table",HttpStatus.OK);
		}
		return new ResponseEntity<String>("Book Record is not Updated in table",HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@GetMapping("/fetchbyid/{bid}")
	public ResponseEntity<?> getOneRecord(@PathVariable("bid") int bid){
		Book bookexist =bookserv.getBookbyId(bid);
		if(bookexist != null) {
			return new ResponseEntity<Book>(bookexist,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Book Record does not exist",HttpStatus.OK);
	}
	
	
}










