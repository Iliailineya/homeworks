package example.spring.repository;

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
    private final SessionFactory sessionFactory;

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
        Session currentSession = sessionFactory.getCurrentSession();
        Account account = currentSession.get(Account.class, id);
        return Optional.ofNullable(account);
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
