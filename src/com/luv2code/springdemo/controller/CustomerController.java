package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	// inject the DAO into the controller
	@Autowired
	private CustomerDAO customerDao;
	
	
	@RequestMapping("/list")
	public String listCustomers(Model model) {
		
		// get customers from the dao
		List<Customer> customers = customerDao.getCustomers();
		
		// add the customers to the model
		model.addAttribute("customers", customers); 
		
		return "list-customers";
	}
}
