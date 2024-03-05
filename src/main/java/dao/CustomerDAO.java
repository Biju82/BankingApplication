package dao;

import entity.Customer;
import entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

    Customer save(Customer customer);

    void deleteById(Integer id);

    Optional<Customer> findById(Integer id);

    List<Customer> findAll();
}
