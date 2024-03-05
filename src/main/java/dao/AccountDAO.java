package dao;
import entity.Account;
import java.util.List;
import java.util.Optional;

public interface AccountDAO {

    Account save(Account account);

    void deleteById(Long accountId);

    Optional<Account> findById(Long accountId);

    List<Account> findAll();

    //method to update ballance
    void setBalance(Long id, Double balance);

    //method to get balance
    Double getBalance(Long accountId);
}
