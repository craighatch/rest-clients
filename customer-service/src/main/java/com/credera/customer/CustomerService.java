package com.credera.customer;


import com.credera.customer.dto.AccountDto;
import com.credera.customer.dto.CreateCustomerRequest;
import com.credera.customer.dto.CustomerAccountDto;
import com.credera.customer.dto.CustomerDto;
import com.credera.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    RestTemplate restTemplate = new RestTemplate();

    public Customer getCustomerById(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public CustomerAccountDto getCustomerAccountDtoForCustomer(Integer customerId) {
        Customer customer = this.getCustomerById(customerId);
        AccountDto accountDto = this.getAccountById(customer.getAccountId());

        CustomerAccountDto customerAccountDto = new CustomerAccountDto();
        CustomerDto customerDto = new CustomerDto();
        customerDto.setAccountId(customer.getAccountId());
        customerDto.setName(customer.getName());
        customerAccountDto.setCustomerDto(customerDto);
        customerAccountDto.setAccountDto(accountDto);

        return customerAccountDto;
    }


    public Customer createCustomer(CreateCustomerRequest customerRequest) {
        AccountDto accountDto = this.openAccount(customerRequest.getInitialBalance());

        Customer customer = new Customer();
        customer.setAccountId(accountDto.getId());
        customer.setName(customerRequest.getName());

        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    public Customer updateCustomer(CustomerDto customerDto, Integer customerId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new RuntimeException("Customer not found"));
        if (StringUtils.hasLength(customer.getName())) {
            customer.setName(customerDto.getName());
        }

        if (customerDto.getAccountId() != null && customer.getAccountId() > 0) {
            customer.setAccountId(customerDto.getAccountId());
        }

        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }


    public Customer deleteCustomerAccount(Integer customerId) {
        Customer customer = this.getCustomerById(customerId);

        if (customer.getAccountId() == null) {
            System.out.println("Customer account already closed");
            return customer;
        }
        deleteAccount(customer.getAccountId());
        customer.setAccountId(null);
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    private AccountDto getAccountById(Integer accountId) {
        if(accountId == null) {
            return null;
        }
        try {
            return restTemplate.getForObject(new URI("http://localhost:8082/account/" + accountId), AccountDto.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteAccount(Integer accountId) {
        if(accountId == null) {
            return;
        }
        try {
            restTemplate.delete(new URI("http://localhost:8082/account/" + accountId));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    private AccountDto openAccount(Integer initialBalance) {
        AccountDto accountRequest = new AccountDto();
        accountRequest.setActive(true);
        accountRequest.setBalance(initialBalance);
        try {
            RequestEntity<AccountDto> requestEntity = new RequestEntity<AccountDto>(accountRequest, HttpMethod.POST, new URI("http://localhost:8082/account"));
            ResponseEntity<AccountDto> response = restTemplate.exchange(requestEntity, AccountDto.class);
            return response.getBody();
            //            return restTemplate.postForObject(new URI("http://localhost:8082/account"), accountRequest, AccountDto.class);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
