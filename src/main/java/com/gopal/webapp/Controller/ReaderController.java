package com.gopal.webapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gopal.webapp.Model.Book;
import com.gopal.webapp.Model.Reader;
import com.gopal.webapp.Service.BookService;
import com.gopal.webapp.Service.ReaderService;

@RestController
@RequestMapping("reader/api")
public class ReaderController {
	
	
	@Autowired
	private ReaderService readerServ;
	
	@Autowired
	private BookService bs;
	
	@PostMapping("/addreader/{bid}")
	public ResponseEntity<?> addReader(@PathVariable("bid")int bid, @RequestBody Reader reader){
		
		Book bookexist =bs.getBookbyId(bid);
		if (bookexist != null) {
			bookexist.setReaderName(reader.getReaderName());
			reader.setReaderName(reader.getReaderName());
			reader.setBook_id_fk(reader.getBook_id_fk());
			reader.setIssueAt(reader.getIssueAt());
			
			if(bs.updateBook(bookexist) && readerServ.addReader(reader)){
				return new ResponseEntity<Reader>(reader, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<String>("book reader name cannot be added", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	

}
