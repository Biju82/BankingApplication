package service;

import entity.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionService {

   void save(Transaction transaction);

   void withdraw(Transaction transaction);
//
//    void deleteById(Integer id);
//
//    Optional<Transaction> findById(Integer id);
//
//    List<Transaction> findAll();
}
