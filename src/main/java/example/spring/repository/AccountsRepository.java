package example.spring.repository;

import example.spring.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class AccountsRepository {
    private final SessionFactory sessionFactory;

    public AccountsRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Account save(Account account) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(account);
            session.getTransaction().commit();
            return account;
        }
    }

    public List<Account> findAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("from Account", Account.class).list();
        }
    }

    public Optional<Account> findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Account account = session.get(Account.class, id);
            return Optional.ofNullable(account);
        }
    }

    public void updateAccount(Account account) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.merge(account);
            session.getTransaction().commit();
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Account account = session.get(Account.class, id);
            if (account != null) {
                session.remove(account);
            }
            session.getTransaction().commit();
        }
    }

    public boolean existsById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            Account account = session.get(Account.class, id);
            return account != null;
        }
    }
}
