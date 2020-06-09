package com.aneesh.springdemo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.aneesh.springdemo.entity.Customer;
import com.aneesh.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	
	//need to inject the service into controller

	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {
		
		//get customers from the service
		List<Customer> customerList = customerService.getCustomers();
		
		//add customers to the spring mvc model
		theModel.addAttribute("customer", customerList);		
		
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer modelCustomer) {
		
		//save customer using the service
		
		customerService.saveCustomer(modelCustomer);
		
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId")int id, Model model) {
		
		//obtain the customer
		Customer customer = customerService.getCustomer(id);
		
		//add the customer attributes to the model
		model.addAttribute("customer", customer);
		
		//send the customer over to the form
		
		
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerId") int id, Model model) {
		
		customerService.deleteCustomer(id);
		return "redirect:/customer/list";
	}
	
}

