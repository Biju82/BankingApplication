package service.impl;

import dao.CustomerDAO;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CustomerService;

import java.util.List;


    @Service
    public class CustomerServiceImpl implements CustomerService {

//        @Autowired
//        private CustomerDAO customerDAO;
//
//        @Override
//        @Transactional
//        public void addCustomer(Customer customer) {
//            customerDAO.addCustomer(customer);
//        }
//
//    @Transactional(readOnly = true)
//    public List<Customer> getAllCustomers() {
//        return customerDAO.getAllCustomers();
//    }
//
////    @Transactional(readOnly = true)
////    public Customer getCustomerById(Long id) {
////        return customerDAO.getCustomerById(id);
////    }
//
////    @Transactional
////    public void deleteCustomer(Long customerId) {
////        customerDAO.deleteCustomer(customerId);
////    }
}