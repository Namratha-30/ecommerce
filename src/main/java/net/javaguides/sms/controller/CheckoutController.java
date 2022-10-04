package net.javaguides.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Checkout;
import net.javaguides.sms.service.CheckoutService;
import net.javaguides.sms.service.StudentService;

@Controller
public class CheckoutController {

	
	private CheckoutService checkoutService;
	private StudentService studentService;
	

	public CheckoutController(CheckoutService checkoutService, StudentService studentService) {
		super();
		this.checkoutService=checkoutService;
		this.studentService=studentService;
		
	}
	
	@GetMapping("/checkout/new")
	public String createStudentForm(Model model) {

	// create student object to hold student form data
	Checkout checkout = new Checkout();
	model.addAttribute("checkout", checkout);
	model.addAttribute("students", studentService.getAllStudents());
	return "checkout";

	}
	
	@PostMapping("/checkout")
	public String saveCheckout(@ModelAttribute("checkout") Checkout checkout,  BindingResult bindingResult) {
		checkoutService.saveCheckout(checkout);
	return "redirect:/students";
	}
	
	

	
}
