package com.credera.app.two.account;

import com.credera.app.two.account.dto.ActivationStateRequest;
import com.credera.app.two.account.dto.CreateAccountRequest;
import com.credera.app.two.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Integer id) {
        return accountService.getAccountById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Integer id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Account createAccount(@RequestBody CreateAccountRequest createAccountRequest) {
        Account savedAccount = accountService.createAccount(createAccountRequest);
        return savedAccount;
    }

    @PostMapping("/{id}/change-activation")
    public Account inactivateAccount(@PathVariable Integer id, @RequestBody ActivationStateRequest activationStateRequest) {
        return accountService.updateActiveStatus(id, activationStateRequest);
    }
}
