package example.spring.controller;

import example.spring.model.Account;
import example.spring.service.AccountService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

    private final AccountService accountService;
    private final List<Account> accounts;

    public AccountRestController(AccountService accountService, List<Account> accounts) {
        this.accountService = accountService;
        this.accounts = accounts;
    }
    @GetMapping("/all")
    public String account() {
        return accounts.toString();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable long id) {
        Account account = accountService.getAccountById(id);
        return ResponseEntity.ok(account);
    }

    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts() {
        List<Account> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@PathVariable long id, @RequestBody Account accountDetails) {
        Account updatedAccount = accountService.updateAccount(id, accountDetails);
        return ResponseEntity.ok(updatedAccount);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccountById(@PathVariable long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.noContent().build();
    }
}

