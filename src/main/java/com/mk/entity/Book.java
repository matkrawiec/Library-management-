package com.mk.entity;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="book")
public class Book {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="b_id")
	private int id;
	@NotNull
	@Column(name="author")
	private String author;
	@NotNull
	@Column(name="title")
	private String title;
	@NotNull
	@Column(name="category")
	private String category;
	@NotNull
	@NotEmpty
	@Column(name="availability")
	private String availability;

	@OneToMany(mappedBy="book")
	private List<Rental> rentals;
	
	public Book() {
		
	}
	

	public Book(int id) {
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	
	public List<Rental> getRentals() {
		return rentals;
	}


	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", author=" + author + ", title=" + title + ", category=" + category
				+ ", availability=" + availability + "]";
	}
	
	
}











