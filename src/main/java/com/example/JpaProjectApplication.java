package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {

	
	@Autowired
	CustomerRepository customerRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Customer[]customerArray= {
				
				new Customer("user01", 20),
				new Customer("user02", 20)
		};
		
//		for (Customer customer : customerArray) {
//			customerRepository.save(customer);
//		}
//		
//		List<Customer> listOfCustomers = customerRepository.findAll();
//		
//		for (Customer customer : listOfCustomers) {
//			System.out.println("listOfCustomer = " + customer.toString());
//		}
		
	}
	
}
