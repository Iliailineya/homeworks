package service;

import example.spring.model.Account;
import example.spring.model.enams.Gender;
import example.spring.service.AccountServiceForFun;
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


class AccountServiceForFunTest {

    private static AccountServiceForFun accountServiceForFun;
    private static List<Account> accounts;

    @BeforeAll
    static void setUp() {
        accountServiceForFun = new AccountServiceForFun();
        accounts = createTestAccounts();
    }
    @Test
    void testFilterAccountsByBalance() {
        List<Account> result = accountServiceForFun.filterAccountsByBalance(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetUniqueCountries() {
        Set<String> result = accountServiceForFun.getUniqueCountries(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testHasYoungerThan2000() {
        assertTrue(accountServiceForFun.hasYoungerThan2000(accounts));
    }

    @Test
    void testGetBalanceOfMaleAccounts() {
        double result = accountServiceForFun.getBalanceOfMaleAccounts(accounts);
        assertEquals(29000d, result);
    }

    @Test
    void testGroupByBirthMonth() {
        Map<Integer, List<Account>> result = accountServiceForFun.groupByBirthMonth(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAverageBalanceByCountry() {
        double result = accountServiceForFun.getAverageBalanceByCountry(accounts, "USA");
        assertEquals(16000.0, result);
    }

    @Test
    void testGetNamesConcatenated() {
        String result = accountServiceForFun.getNamesConcatenated(List.of(accounts));
        assertNotNull(result);
        assertEquals("John Doe, Alice Johnson, Bob Smith, Emily Clark", result);
    }

    @Test
    void testGetSortedAccounts() {
        List<Account> sortedAccounts = accountServiceForFun.getSortedAccounts(accounts);
        assertNotNull(sortedAccounts);
        assertEquals("Clark", sortedAccounts.get(0).getLastName());
    }

    @Test
    void testGetOldestAccount() {
        Account oldestAccount = accountServiceForFun.getOldestAccount(accounts);
        assertEquals("John", oldestAccount.getFirstName());
    }

    @Test
    void testGroupByBirthYearAndAverageBalance() {
        Map<Integer, Double> result = accountServiceForFun.groupByBirthYearAndAverageBalance(accounts);
        assertNotNull(result);
        assertEquals(4, result.size());
    }

    @Test
    void testGetAccountWithLongestLastName() {
        Account accountWithLongestLastName = accountServiceForFun.getAccountWithLongestLastName(accounts);
        assertEquals("Johnson", accountWithLongestLastName.getLastName());
    }

    private static List<Account> createTestAccounts() {
        return Arrays.asList(
                new Account(1L,"John", "Doe", "USA", LocalDate.of(1990, Month.JANUARY, 12), 16000d, Gender.MALE),
                new Account(2L, "Alice", "Johnson", "Canada", LocalDate.of(1995, Month.MARCH, 5), 18000d, Gender.FEMALE),
                new Account(3L,"Bob", "Smith", "UK", LocalDate.of(2000, Month.AUGUST, 22), 13000d, Gender.MALE),
                new Account(4L,"Emily", "Clark", "Germany", LocalDate.of(1992, Month.JULY, 15), 12000d, Gender.FEMALE)
        );
    }
}
