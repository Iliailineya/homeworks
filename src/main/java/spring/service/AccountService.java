package spring.service;

import spring.model.Account;
import spring.exception.AccountNotFoundException;
import spring.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository repository;

    public Account createAccount(Account account) {
        return repository.save(account);
    }

    public Account getAccountById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    public Account updateAccount(long id, Account account) {
        getAccountById(id);
        return repository.save(account);
    }

    public void deleteAccountById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
