package com.example.ChaiNashta.controller;

import com.example.ChaiNashta.entity.Customer;
import com.example.ChaiNashta.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;

	@PutMapping("/saveCustomer")
	public Customer save(@RequestBody Customer customer) {
		if(customer.getCustomerId() == null)
			customer.setCustomerId(customerService.findAllCustomers().size()+1);
		return customerService.save(customer);
	}

	@GetMapping("/getByCustomerId")
	public Optional<Customer> getByCustomerId(@RequestParam Integer customerId) {
		return customerService.findByCustomerId(customerId);
	}

	@GetMapping("/getByCustomerIdAndPassword")
	public Optional<Customer> getByCustomerIdAndPassword(
			@RequestParam Integer customerId,
			@RequestParam String password) {
		return customerService.findByCustomerIdAndPassword(customerId, password);
	}

	@GetMapping("/getAll")
	public List<Customer> getAllCustomers() {
		return customerService.findAllCustomers();
	}

}
