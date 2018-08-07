package com.mk.controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/rental")
public class RentalController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private RentalService rentalService;
	
	
	@GetMapping("/list")
	public String showAllRental(Model theModel) {
		List<Rental> rentals = rentalService.getRentals();
		theModel.addAttribute("rentals", rentals);
		return "rental-list";
	}

	@GetMapping("/return")
	public String returnBook(@RequestParam("customerId") int cId, @RequestParam ("bookId") int bId,
							 @RequestParam ("rentalId") int rId, Model theModel) {
		Customer theCustomer = customerService.getCustomer(cId);
		Book theBook = bookService.getBook(bId);
		Rental theRental = rentalService.getRental(rId);
		theModel.addAttribute("finalCustomer", theCustomer);
		theModel.addAttribute("finalBook", theBook);
		theModel.addAttribute("finalRental", theRental);
	return "return-confirmation";
	}
	
	@PostMapping("/confirmReturn")
	public String returnConfirmation(@RequestParam ("bookId") int bId, @RequestParam ("rentalId") int rId) {
		Book theBook = bookService.getBook(bId);
		Rental theRental = rentalService.getRental(rId);
		rentalService.update(theBook, theRental);
		return "redirect:/book/allAvailableBooks";
	}
	
	@GetMapping("/history")
	public String history(Model theModel) {
		List<Rental> rentals = rentalService.getAllRentals();
		theModel.addAttribute("rentalsHistory", rentals);
		return "history";
	}
	
	
	
}












