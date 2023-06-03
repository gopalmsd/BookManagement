package com.gopal.webapp.Repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gopal.webapp.Model.Reader;



@Repository
@Transactional
public interface ReaderRepository extends JpaRepository<Reader, Integer> {
	
	@Query(value= "select r from Reader r where r.book_id_fk = :bookId")
	public Set<Reader> getReaderList(int bookId);

	
	@Modifying
	@Query(value=" delete from Reader where book_id_fk =:bookId")
	public void deleteReaderData(int bookId);
	
	
}
