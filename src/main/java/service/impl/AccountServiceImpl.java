package service.impl;

import dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.AccountService;
import service.base.BaseService;

@Service
public class AccountServiceImpl extends BaseService implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

//    @Override
//    @Transactional
//    public void deposit(Long accountNumber, double amount) {
//        accountDAO.deposit(accountNumber, amount);
//    }
//
//    @Override
//    @Transactional
//    public void withdraw(Long accountNumber, double amount) {
//        accountDAO.withdraw(accountNumber, -amount);
//    }
//
//    @Override
//    @Transactional(readOnly = true)
//    public double getBalance(Long accountNumber) {
//        return accountDAO.getBalance(accountNumber);
//    }
}
