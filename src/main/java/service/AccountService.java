package service;

public interface AccountService {
    public Double getBalance(Long accountId);  // Change the parameter type to Long
}

//    @Transactional
//    void deposit(Long accountNumber, double amount);
//
//    @Transactional
//    void withdraw(Long accountNumber, double amount);
//
//
//    @Transactional(readOnly = true)
//    double getBalance(Long accountNumber);

