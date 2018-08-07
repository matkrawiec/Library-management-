package com.mk.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="rental")
public class Rental {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="rental_id")
	private int id;
	@Column(name="issue_date")
	private Date issueDate;
	@Column(name="return_date")
	private Date returnDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_id", referencedColumnName="b_id")
	private Book book;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="customer_id", referencedColumnName="c_id")
	private Customer customer;

	@Override
	public String toString() {
		return "Rental [id=" + id + ", issueDate=" + issueDate + ", returnDate=" + returnDate + "]";
	}



	public Rental() {
	}
	
	

	public Rental(Book book, Customer customer) {
		this.book = book;
		this.customer = customer;
	}



	public Rental(Date issueDate) {
		this.issueDate = issueDate;
	}



	public Rental(int id, Date issueDate, Book book, Customer customer) {
		this.id = id;
		this.issueDate = issueDate;
		this.book = book;
		this.customer = customer;
	}



	public Rental(int id, @NotNull Date issueDate) {
		this.id = id;
		this.issueDate = issueDate;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
}










