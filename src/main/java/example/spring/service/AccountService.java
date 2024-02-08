package example.spring.service;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import example.spring.repository.AccountsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@SuppressWarnings("unused")
@Service
@AllArgsConstructor
public class AccountService {
    private final AccountsRepository AccountsRepository;

    // Создание нового аккаунта
    public Account createAccount(Account account) {
        return AccountsRepository.save(account);
    }

    // Получение аккаунта по его ID
    public Account getAccountById(long id) {
        return AccountsRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("Account with id " + id + " not found"));
    }

    // Получение всех аккаунтов
    public List<Account> getAllAccounts() {
        return (List<Account>) AccountsRepository.findAll();
    }

    // Обновление существующего аккаунта
    public Account updateAccount(Account account) {
        return AccountsRepository.save(account);
    }

    // Удаление аккаунта по его ID
    public void deleteAccountById(long id) {
        if (AccountsRepository.existsById(id)) {
            AccountsRepository.deleteById(id);
        } else {
            throw new AccountNotFoundException("Account with id " + id + " not found");
        }
    }
}
