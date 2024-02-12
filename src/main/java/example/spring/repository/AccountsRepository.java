package example.spring.repository;

import example.spring.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountsRepository extends CrudRepository<Account, Long> {
    @Override
    <S extends Account> S save(S account);

    @Override
    List<Account> findAll();

    @Override
    Optional<Account> findById(Long id);

    @Override
    void deleteById(Long id);
}