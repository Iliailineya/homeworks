package service;

import model.Account;
import model.enams.Gender;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void testFilterAccountsByBalance() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        List<Account> result = accountService.filterAccountsByBalance(accounts);
        assertEquals(4, result.size());
        assertNotNull(result);
    }

    @Test
    void testGetUniqueCountries() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        Set<String> result = accountService.getUniqueCountries(accounts);
        assertEquals(4, result.size());
        assertNotNull(result);
    }

    @Test
    void testHasYoungerThan2000() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        assertTrue(accountService.hasYoungerThan2000(accounts));
    }

    @Test
    void testGetBalanceOfMaleAccounts() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        double result = accountService.getBalanceOfMaleAccounts(accounts);
        assertEquals(29000d, result);
    }

    @Test
    void testGroupByBirthMonth() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        Map<Integer, List<Account>> result = accountService.groupByBirthMonth(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAverageBalanceByCountry() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        double result = accountService.getAverageBalanceByCountry(accounts, "USA");
        assertEquals(16000.0, result);
    }

    @Test
    void testGetNamesConcatenated() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        String result = accountService.getNamesConcatenated(List.of(accounts));
        assertNotNull(result);
        assertEquals("John Doe, Alice Johnson, Bob Smith, Emily Clark", result);
    }

    @Test
    void testGetSortedAccounts() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        List<Account> sortedAccounts = accountService.getSortedAccounts(accounts);
        assertNotNull(sortedAccounts);
        assertEquals("Clark", sortedAccounts.get(0).getLastName());
    }

    @Test
    void testGetOldestAccount() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        Account oldestAccount = accountService.getOldestAccount(accounts);
        assertEquals("John", oldestAccount.getFirstName());
    }

    @Test
    void testGroupByBirthYearAndAverageBalance() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        Map<Integer, Double> result = accountService.groupByBirthYearAndAverageBalance(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAccountWithLongestLastName() {
        List<Account> accounts = createTestAccounts();
        AccountService accountService = new AccountService();
        Account accountWithLongestLastName = accountService.getAccountWithLongestLastName(accounts);
        assertEquals("Johnson", accountWithLongestLastName.getLastName());
    }

    private List<Account> createTestAccounts() {
        return Arrays.asList(
                new Account("John", "Doe", "USA", LocalDate.of(1990, Month.JANUARY, 12), 16000d, Gender.MALE),
                new Account("Alice", "Johnson", "Canada", LocalDate.of(1995, Month.MARCH, 5), 18000d, Gender.FEMALE),
                new Account("Bob", "Smith", "UK", LocalDate.of(2000, Month.AUGUST, 22), 13000d, Gender.MALE),
                new Account("Emily", "Clark", "Germany", LocalDate.of(1992, Month.JULY, 15), 12000d, Gender.FEMALE)
        );
    }
}
