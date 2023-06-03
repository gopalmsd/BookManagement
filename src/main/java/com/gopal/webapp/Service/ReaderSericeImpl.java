package com.gopal.webapp.Service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gopal.webapp.Model.Reader;
import com.gopal.webapp.Repository.ReaderRepository;

@Service
public class ReaderSericeImpl implements ReaderService{
	
	
	@Autowired
	private ReaderRepository readerRepo;

	@Override
	public Set<Reader> getAllReaders(int bookId) {
		
		Set<Reader> readerList =readerRepo.getReaderList(bookId);		
		return readerList;
	}

	@Override
	public boolean addReader(Reader reader) {
		 Reader readerObj = new Reader();
		 readerObj.setReaderName(reader.getReaderName());
		 readerObj.setIssueAt(reader.getIssueAt());
		 readerObj.setBook_id_fk(reader.getBook_id_fk());
		 
		 readerRepo.saveAndFlush(readerObj);
		return true;
	}

	@Override
	public boolean deleteReader(int bookId) {
	
		readerRepo.deleteReaderData(bookId);
		return true;
	}
	
 

}
