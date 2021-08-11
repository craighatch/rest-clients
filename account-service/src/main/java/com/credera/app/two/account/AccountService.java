package com.credera.app.two.account;

import com.credera.app.two.account.dto.ActivationStateRequest;
import com.credera.app.two.account.dto.CreateAccountRequest;
import com.credera.app.two.account.dto.CustomerDto;
import com.credera.app.two.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccountById(Integer id) {
        return accountRepository.findById(id).orElseThrow(() -> new RuntimeException("No account found for id: " + id));
    }

    public void deleteAccountById(Integer id) {
        Account account = this.getAccountById(id);
        accountRepository.delete(account);
    }

    public Account createAccount(CreateAccountRequest createAccountRequest) {
        Account account = new Account();
        account.setActive(createAccountRequest.isActive());
        account.setBalance(createAccountRequest.getBalance());
        return accountRepository.save(account);
    }

    public Account updateActiveStatus(Integer id, ActivationStateRequest activationStateRequest) {
        Account account = this.getAccountById(id);
        account.setActive(activationStateRequest.isActive());
        return accountRepository.save(account);
    }

}
