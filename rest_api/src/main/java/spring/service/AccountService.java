package spring.service;

import spring.exception.AccountNotFoundException;
import spring.model.Account;
import spring.model.User;
import spring.model.dto.AccountDTO;
import spring.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserService userService;

    public AccountService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException("account with id:" + id + "not found"));
    }

//TODO check how to use entity graph here

//    public List<Payment> getPaymentsByAccountId(Long id) {
//        return accountRepository.getPaymentsByAccountId(id)
//                .orElseThrow(() -> new AccountNotFoundException("account with id:" + id + "not found"));
//    }

    public Long createAccount(AccountDTO accountDTO) {
        Account account = new Account();
        account.setBalance(accountDTO.getBalance());
        account.setCountry(accountDTO.getCountry());
        account.setFirstName(accountDTO.getFirstName());
        account.setLastName(accountDTO.getLastName());
        account.setGender(accountDTO.getGender());
        User user = userService.findUserById(accountDTO.getUserId());
        account.setUser(user);
        return accountRepository.save(account).getId();
    }

    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }
}