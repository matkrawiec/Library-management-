package com.mk.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mk.entity.Book;
import com.mk.entity.Customer;
import com.mk.entity.Rental;
import com.mk.service.BookService;
import com.mk.service.CustomerService;
import com.mk.service.RentalService;

@Controller
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private RentalService rentalService;
	
	@GetMapping("/allBooks")
	public String showAllBooks(Model theModel) {
		List<Book> books = bookService.getAllBooks();
		theModel.addAttribute("allBooks", books);
		return "all-books";
	}
	
	@GetMapping("/allAvailableBooks")
	public String showAllAvailableBooks(Model theModel) {
		List<Book> books = bookService.getAllAvailableBooks();
		theModel.addAttribute("allAvailableBooks", books);
		return "all-available-books";
	}
	
	@GetMapping("/allIssuedBooks")
	public String showAllIssuedBooks(Model theModel) {
		List<Book> books = bookService.getAllIssuedBooks();
		theModel.addAttribute("allIssuedBooks", books);
		return "all-issued-books";
	}
	
	@GetMapping("/allLostBooks")
	public String showAllLostBooks(Model theModel) {
		List<Book> books = bookService.getAllLostBooks();
		theModel.addAttribute("allLostBooks", books);
		return "all-lost-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Book theBook = new Book();
		theModel.addAttribute("book", theBook);
		return "book-form";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute ("book")Book theBook) {
		bookService.saveBook(theBook);
		return "redirect:/book/allBooks";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,  Model theModel) {
		Book theBook = bookService.getBook(theId);
		theModel.addAttribute("book", theBook);
		return "book-update-form";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute ("book") Book theBook) {
		bookService.updateBook(theBook);
		return "redirect:/book/allBooks";
	}
	
	@PostMapping("/searchBooks")
	public String searchBooks(@RequestParam("theSearchName") String theSearchName, Model theModel) {
		List<Book> theBooks = bookService.searchBooks(theSearchName);
		theModel.addAttribute("theBooks", theBooks);
		return "search-books";
	}
	

	@GetMapping("/showFormForLend")
	public String showFormForLend(@RequestParam ("bookId") int theId, Model theModel) {
		Book theBook = bookService.getBook(theId);
		List<Customer> theCustomers = customerService.getAllCustomers();
		theModel.addAttribute("lendBook", theBook);
		theModel.addAttribute("customers", theCustomers);
		return "book-lend-form";
	}
	
	@GetMapping("/showFormForLend/lendToCustomer")
	public String lendToCustomer(@RequestParam ("customerId") int cId,@RequestParam ("bookId") int bId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(cId);
		Book theBook = bookService.getBook(bId);
		theModel.addAttribute("finalCustomer", theCustomer);
		theModel.addAttribute("finalBook", theBook);
		return "lend-confirmation";
	}
	
	@PostMapping("/confirmRent")
	public String confirmRent(@RequestParam ("customerId") int cId, @RequestParam ("bookId") int bId) {
		Customer theCustomer = customerService.getCustomer(cId);
		Book theBook = bookService.getBook(bId);
//		theBook.setAvailability("no");
		rentalService.createNewEntry(theCustomer, theBook);
		return "redirect:/book/allAvailableBooks";
	}


}









