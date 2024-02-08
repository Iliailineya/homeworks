package example.spring.repository;

import example.spring.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountsRepository implements AccountsCrudRepository{
    private final List<Account> accounts = new ArrayList<>();


    @Override
    public Account save(Account account) {
        return null;
    }

    public List<Account> findAll() {
        return accounts;
    }

    public Optional<Account> findById(long id) {
        return accounts.stream()
                .filter(account -> account.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(long id) {
        return false;
    }

    public Account add(Account account) {
        accounts.add(account);
        return account;
    }


    public Account update(long id, Account accountToUpdate) {
        Optional<Account> possibleAccount = findById(id);
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
        Optional<Account> account = findById(id);
        account.ifPresent(accounts::remove);
    }
}
