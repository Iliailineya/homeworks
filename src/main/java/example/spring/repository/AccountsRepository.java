package example.spring.repository;

import example.spring.exception.AccountNotFoundException;
import example.spring.model.Account;
import jakarta.persistence.Query;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountsRepository {
    private SessionFactory sessionFactory;

    public AccountsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Account save(Account account) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.merge(account);
    }

    @SuppressWarnings("unchecked")
    public List<Account> findAll() {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Account> cq = cb.createQuery(Account.class);
        Root<Account> root = cq.from(Account.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    public Optional<Account> findById(Long id) {
        try {
            Session currentSession = sessionFactory.getCurrentSession();
            Account account = currentSession.get(Account.class, id);
            return Optional.ofNullable(account);
        } catch (RuntimeException e) {
            throw new AccountNotFoundException("Account not found");
        }
    }

    public void updateAccount(Account account) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(account);
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.byId(Account.class).load(id);
        session.remove(account);
    }

    public boolean existsById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Account account = currentSession.get(Account.class, id);
        return account != null;
    }
}
//    private final List<Account> accounts = new ArrayList<>();
//
//    public List<Account> findAll() {
//        return accounts;
//    }
//
//    public Optional<Account> findById(long id) {
//        Optional<Account> account = accounts.stream()
//                .filter(a -> a.getId() == id)
//                .findFirst();
//        if (account.isEmpty()) {
//            throw new AccountNotFoundException("Account not found");
//        }
//        return account;
//    }
//
//    public Account updateById(long id, Account accountToUpdate) {
//        Optional<Account> possibleAccount = findById(id);
//        return possibleAccount.map(account -> {
//            account.setFirstName(accountToUpdate.getFirstName());
//            account.setLastName(accountToUpdate.getLastName());
//            account.setCountry(accountToUpdate.getCountry());
//            account.setBirthday(accountToUpdate.getBirthday());
//            account.setGender(accountToUpdate.getGender());
//            return account;
//        }).orElse(null);
//    }
//
//    public void deleteById(long id) {
//        Optional<Account> account = findById(id);
//        account.ifPresent(accounts::remove);
//    }
