package com.credera.customer;

import com.credera.customer.dto.CreateCustomerRequest;
import com.credera.customer.dto.CustomerAccountDto;
import com.credera.customer.dto.CustomerDto;
import com.credera.customer.entity.Customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    Logger log = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable Integer id) {
        log.info("Received Request: GET /customer/" + id);
        return customerService.getCustomerById(id);
    }

    @GetMapping("/{customerId}/account")
    public CustomerAccountDto getCustomerAccountDtoForCustomer(@PathVariable Integer customerId){
        return customerService.getCustomerAccountDtoForCustomer(customerId);
    }

    @PutMapping("/{customerId}")
    public Customer updateCustomer(@PathVariable Integer customerId, @RequestBody CustomerDto customerDto) {
        log.info("Received Request: PUT /customer/" + customerId + " with body: " + customerDto);
        return customerService.updateCustomer(customerDto, customerId);
    }

    @PutMapping("/{customerId}/delete-account")
    public Customer deleteCustomerAccount(@PathVariable Integer customerId) {
        log.info("Received Request: PUT /customer/" + customerId + "/delete-account");
        return customerService.deleteCustomerAccount(customerId);
    }

    @PostMapping
    public Customer createCustomer(@RequestBody CreateCustomerRequest createCustomerRequest) {
        log.info("Received Request: POST /customer with body: " + createCustomerRequest);
        return customerService.createCustomer(createCustomerRequest);
    }


}
