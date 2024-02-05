package service;

import example.spring.model.Account;
import example.spring.model.enams.Gender;
import example.spring.service.AccountService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


class AccountServiceTest {

    private static AccountService accountService;
    private static List<Account> accounts;

    @BeforeAll
    static void setUp() {
        accountService = new AccountService();
        accounts = createTestAccounts();
    }
    @Test
    void testFilterAccountsByBalance() {
        List<Account> result = accountService.filterAccountsByBalance(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetUniqueCountries() {
        Set<String> result = accountService.getUniqueCountries(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testHasYoungerThan2000() {
        assertTrue(accountService.hasYoungerThan2000(accounts));
    }

    @Test
    void testGetBalanceOfMaleAccounts() {
        double result = accountService.getBalanceOfMaleAccounts(accounts);
        assertEquals(29000d, result);
    }

    @Test
    void testGroupByBirthMonth() {
        Map<Integer, List<Account>> result = accountService.groupByBirthMonth(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAverageBalanceByCountry() {
        double result = accountService.getAverageBalanceByCountry(accounts, "USA");
        assertEquals(16000.0, result);
    }

    @Test
    void testGetNamesConcatenated() {
        String result = accountService.getNamesConcatenated(List.of(accounts));
        assertNotNull(result);
        assertEquals("John Doe, Alice Johnson, Bob Smith, Emily Clark", result);
    }

    @Test
    void testGetSortedAccounts() {
        List<Account> sortedAccounts = accountService.getSortedAccounts(accounts);
        assertNotNull(sortedAccounts);
        assertEquals("Clark", sortedAccounts.get(0).getLastName());
    }

    @Test
    void testGetOldestAccount() {
        Account oldestAccount = accountService.getOldestAccount(accounts);
        assertEquals("John", oldestAccount.getFirstName());
    }

    @Test
    void testGroupByBirthYearAndAverageBalance() {
        Map<Integer, Double> result = accountService.groupByBirthYearAndAverageBalance(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAccountWithLongestLastName() {
        Account accountWithLongestLastName = accountService.getAccountWithLongestLastName(accounts);
        assertEquals("Johnson", accountWithLongestLastName.getLastName());
    }

    private static List<Account> createTestAccounts() {
        return Arrays.asList(
                new Account("John", "Doe", "USA", LocalDate.of(1990, Month.JANUARY, 12), 16000d, Gender.MALE),
                new Account("Alice", "Johnson", "Canada", LocalDate.of(1995, Month.MARCH, 5), 18000d, Gender.FEMALE),
                new Account("Bob", "Smith", "UK", LocalDate.of(2000, Month.AUGUST, 22), 13000d, Gender.MALE),
                new Account("Emily", "Clark", "Germany", LocalDate.of(1992, Month.JULY, 15), 12000d, Gender.FEMALE)
        );
    }
}
