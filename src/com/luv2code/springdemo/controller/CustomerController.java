package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//inject CustomerService
	@Autowired
	CustomerService customerService;
	
	
	@GetMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers = customerService.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers); 
		
		return "list-customers";
	}
	
	@GetMapping("/showFormAdd")
	public String addCustomer(Model model) {
		
		Customer theCustomer = new Customer();
		
		model.addAttribute("customer", theCustomer);
		
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
		public String saveCustomer(@ModelAttribute("customer") Customer customer){
		
		// save customer using our service
		customerService.saveCustomer(customer);
		
		return "redirect:/customer/list";
	}
}
