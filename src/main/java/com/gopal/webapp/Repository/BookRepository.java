package com.gopal.webapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.webapp.Model.Book;


@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	
	

}
