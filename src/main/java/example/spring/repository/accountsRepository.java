package example.spring.repository;

import example.spring.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface accountsRepository extends CrudRepository<Account, Integer> {
}