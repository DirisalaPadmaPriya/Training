package com.priya.demospringboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.priya.demospringboot.model.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long>{
	Customer save(Customer customer);
	List<Customer> findAll();

}
