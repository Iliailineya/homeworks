package example.spring.repository;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountsRepository {
    private final List<Account> accounts = new ArrayList<>();

    public List<Account> findAll() {
        return accounts;
    }

    public Optional<Account> getAccountById(long id) {
        Optional<Account> account = accounts.stream()
                .filter(a -> a.getId() == id)
                .findFirst();
        if (account.isEmpty()) {
            throw new AccountNotFoundException("Account not found");
        }
        return account;
    }

    public Account updateById(long id, Account accountToUpdate) {
        Optional<Account> possibleAccount = getAccountById(id);
        return possibleAccount.map(account -> {
            account.setFirstName(accountToUpdate.getFirstName());
            account.setLastName(accountToUpdate.getLastName());
            account.setCountry(accountToUpdate.getCountry());
            account.setBirthday(accountToUpdate.getBirthday());
            account.setGender(accountToUpdate.getGender());
            return account;
        }).orElse(null);
    }

    public void deleteById(long id) {
        Optional<Account> account = getAccountById(id);
        account.ifPresent(accounts::remove);
    }
}