package com.priya.demospringboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.demospringboot.model.Customer;
import com.priya.demospringboot.repository.CustomerRepository;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
@Autowired
private CustomerRepository repo;

@GetMapping("/all")
public List<Customer> getAllCustomers(){
	return repo.findAll();
}
@PostMapping("/add")
public Customer addCustomer(@RequestBody Customer customer){
	//System.out.println(customer);
	//Customer cust=new Customer("Abdul","Kalam");
	return repo.save(customer);
}
@PutMapping("/update/{id}")
public Customer updateCustomer(@PathVariable Long id){
	Customer updatedCustomer=null;
	Optional<Customer> customer=repo.findById(id);
	if(customer.isPresent()){
		updatedCustomer=customer.get();
		updatedCustomer.setFirstName(updatedCustomer.getFirstName()+"_updated");
	}
	return repo.save(updatedCustomer);
}
@DeleteMapping("/delete/{id}")
public void deleteCustomer(@PathVariable Long id){
	repo.deleteById(id);
}
}
