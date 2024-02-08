package example.spring.service;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import example.spring.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@SuppressWarnings("unused")
@Service
@AllArgsConstructor
public class AccountService {
    private final AccountsRepository accountsRepository;

    // Создание нового аккаунта
    public Account createAccount(Account account) {
        return accountsRepository.save(account);
    }

    // Получение аккаунта по его ID
    public Account getAccountById(long id) {
        return accountsRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    // Получение всех аккаунтов
    public List<Account> getAllAccounts() {
        return (List<Account>) accountsRepository.findAll();
    }

    // Обновление существующего аккаунта
    public Account updateAccount(Account account) {
        return accountsRepository.save(account);
    }

    // Удаление аккаунта по его ID
    public void deleteAccountById(long id) {
        if (accountsRepository.existsById(id)) {
            accountsRepository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
