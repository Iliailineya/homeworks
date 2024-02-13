package example.spring.service;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import example.spring.repository.AccountsRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {
    private final AccountsRepository repository;

    @Transactional
    public Account createAccount(Account account) {
        return repository.save(account);
    }

    @Transactional
    public Account getAccountById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    @Transactional
    public List<Account> getAllAccounts() {
        return repository.findAll();
    }

    @Transactional
    public Account updateAccount(long id, Account account) {
        if (repository.existsById(id)) {
            account.setId(id);
            repository.updateAccount(account);
            return account;
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }

    @Transactional
    public void deleteAccountById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
