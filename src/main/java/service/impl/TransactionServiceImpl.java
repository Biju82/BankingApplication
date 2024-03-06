package service.impl;

import dao.TransactionDAO;
import dao.impl.TransactionDAOImpl;
import entity.Transaction;
import service.TransactionService;
import service.base.BaseService;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl extends BaseService implements TransactionService {

    private TransactionDAO transactionDAO;

//    public TransactionServiceImpl(TransactionDAO transactionDAO) {
//        this.transactionDAO = new TransactionDAOImpl(sessionFactory.createEntityManager());
//    }
//
//    @Override
//    public Transaction save(Transaction transaction) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//
//    }
//
//    @Override
//    public Optional<Transaction> findById(Integer id) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Transaction> findAll() {
//        return null;
//    }
}
