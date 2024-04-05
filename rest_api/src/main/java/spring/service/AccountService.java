package spring.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import spring.exception.AccountNotFoundException;
import spring.model.Account;
import spring.model.dto.AccountDTO;
import spring.repository.AccountRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Long createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setFirstName(accountDTO.getFirstName());
        account.setLastName(accountDTO.getLastName());
        account.setCountry(accountDTO.getCountry());
        account.setBalance(accountDTO.getBalance());
        account.setGender(accountDTO.getGender());
        return accountRepository.save(account).getId();
    }

    public Account getAccountById(long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account updateAccount(long id, AccountDTO accountDTO) {
        getAccountById(id);
        Account account = new Account();
        account.setFirstName(accountDTO.getFirstName());
        account.setLastName(accountDTO.getLastName());
        account.setCountry(accountDTO.getCountry());
        account.setBalance(accountDTO.getBalance());
        account.setGender(accountDTO.getGender());
        return accountRepository.save(account);
    }

    public void deleteAccountById(long id) {
        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
