package service;

import org.springframework.transaction.annotation.Transactional;

public interface AccountService {

    @Transactional
    void deposit(Long accountNumber, double amount);

    @Transactional
    void withdraw(Long accountNumber, double amount);

    double getBalance(String accountNumber);

    @Transactional(readOnly = true)
    double getBalance(Long accountNumber);
}
