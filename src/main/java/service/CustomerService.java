package service;
// CustomerService.java

import entity.Customer;

import java.util.List;

public interface CustomerService {
    void addCustomer(Customer customer);
    List<Customer> getAllCustomers();
    Customer logIn(String email,String password);

////    Customer getCustomerById(Long id);
//    // Other service methods
////    void deleteCustomer(Long customerId);
}
