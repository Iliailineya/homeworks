package example.spring.controller;

import example.spring.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/account")
public class accountRestController {

    @Autowired
    private final List<Account> accounts;

    public accountRestController(List<Account> accounts) {
        this.accounts = accounts;
    }

    @GetMapping("/{id}")
    public String accountById(@PathVariable("id") String id) {
        try {
            int accountId = Integer.parseInt(id);
            if (accountId >= 0 && accountId < accounts.size()) {
                return accounts.get(accountId).toString();
            } else {
                return "Account with ID " + id + " not found";
            }
        } catch (NumberFormatException e) {
            return "Invalid account ID format";
        }
    }


    @GetMapping("/all")
    public String account() {
        return accounts.toString();
    }

}
