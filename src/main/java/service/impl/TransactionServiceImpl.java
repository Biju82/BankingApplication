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

    public TransactionServiceImpl(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
}
