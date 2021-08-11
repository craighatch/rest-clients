package com.credera.app.two;

import com.credera.app.two.account.AccountRepository;
import com.credera.app.two.account.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccountApplication implements CommandLineRunner {

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Account account = new Account();
		account.setBalance(12345);
		account.setActive(true);

		accountRepository.save(account);
	}
}
