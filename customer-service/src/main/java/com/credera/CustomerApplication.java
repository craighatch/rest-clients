package com.credera;

import com.credera.customer.CustomerRepository;
import com.credera.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CustomerApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Customer customer = new Customer();
		customer.setAccountId(1);
		customer.setName("Bob");

		customerRepository.saveAll(List.of(customer));
	}
}
