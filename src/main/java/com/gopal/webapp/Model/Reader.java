package com.gopal.webapp.Model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity 
public class Reader {
	
	
	@Id
	@GeneratedValue
	private int transactionalId;
	private String readerName;
	Date issueAt;
	private int book_id_fk; // Foreign key common column for book  and reader entity
	
	
	public int getTransactionalId() {
		return transactionalId;
	}
	public void setTransactionalId(int transactionalId) {
		this.transactionalId = transactionalId;
	}
	public String getReaderName() {
		return readerName;
	}
	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public Date getIssueAt() {
		return issueAt;
	}
	public void setIssueAt(Date issueAt) {
		this.issueAt = issueAt;
	}
	public int getBook_id_fk() {
		return book_id_fk;
	}
	public void setBook_id_fk(int book_id_fk) {
		this.book_id_fk = book_id_fk;
	}
	
	public Reader(int transactionalId, String readerName, Date issueAt, int book_id_fk) {
		super();
		this.transactionalId = transactionalId;
		this.readerName = readerName;
		this.issueAt = issueAt;
		this.book_id_fk = book_id_fk;
	}
	
	public Reader() {
	}
	
}
