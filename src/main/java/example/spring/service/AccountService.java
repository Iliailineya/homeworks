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

    private final AccountsRepository accountsRepository;

    public Account getAccountById(long id) {
        return accountsRepository.getAccountById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    public List<Account> getAllAccounts() {
        return accountsRepository.findAll();
    }

    public Account updateAccount(long id, Account account) {
        return accountsRepository.updateById(id, account);
    }

    public void deleteAccountById(long id) {
        accountsRepository.deleteById(id);
    }
}
