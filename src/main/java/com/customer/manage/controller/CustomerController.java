package com.customer.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.customer.manage.model.ProductModel;
import com.customer.manage.service.CustomerService;
import com.customer.manage.service.ProductService;
import com.manage.customer.entity.CustomerEntity;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/create")
	public void createCustomer(@RequestBody CustomerEntity customerEntity) {
		customerService.createCustomer(customerEntity);
	}

	@PutMapping("/update")
	public void updateCustomer(@RequestBody CustomerEntity customerEntity) {
		customerService.updateCustomer(customerEntity);
	}

	@DeleteMapping("/delete/{customerId}")
	public void deleteCustomer(@PathVariable int customerId) {
		customerService.deleteCustomer(customerId);
	}

	@GetMapping("/findByCustomerId/{customerId}")
	public CustomerEntity findByCustomerId(@PathVariable int customerId) {
		return customerService.findByCustomerId(customerId);
	}

	@GetMapping("/findByFirstName/{firstName}")
	public List<CustomerEntity> findByFirstName(@PathVariable String firstName) {
		return customerService.findByFirstName(firstName);
	}

	@GetMapping("/findByLastNameAndMiddleName/{lastName}/{middleName}")
	public List<CustomerEntity> findByLastNameAndMiddleName(@PathVariable String lastName,
			@PathVariable String middleName) {
		return customerService.findByLastNameAndMiddleName(lastName, middleName);
	}

	@GetMapping("/findByFirstNameOrLastName/{firstName}/{lastName}")
	public List<CustomerEntity> findByFirstNameOrLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		return customerService.findByFirstNameOrLastName(firstName, lastName);
	}
	@GetMapping("/getProducts/{productId}")
	public ProductModel getProducts(@PathVariable int productId) {
		return productService.getProducts(productId);
		
	}

	
	

	

}