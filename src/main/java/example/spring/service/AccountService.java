package example.spring.service;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import example.spring.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountsRepository repository;

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
        if (repository.existsById(id)) {
            account.setId(id);
            return repository.save(account);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }


    public void deleteAccountById(long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
