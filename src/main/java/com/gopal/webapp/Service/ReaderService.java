package com.gopal.webapp.Service;

import java.util.Set;

import com.gopal.webapp.Model.Reader;

public interface ReaderService {
	
	public Set<Reader> getAllReaders(int bookId);
	
	public boolean addReader(Reader reader);
	
	public boolean deleteReader(int bookId);

}
