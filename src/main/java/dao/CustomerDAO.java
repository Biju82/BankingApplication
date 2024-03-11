package dao;

import entity.Customer;
import entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDAO {

     void addCustomer(Customer customer);
     Customer logIn(String email,String password);
//
//    void deleteById(Integer id);
//
//
////    Customer getCustomerById(Integer id);
//
    List<Customer> getAllCustomers();




}
