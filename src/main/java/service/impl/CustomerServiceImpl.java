package service.impl;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CustomerService;

import java.util.List;


    @Service
    public class CustomerServiceImpl implements CustomerService {

        private CustomerDAO customerDAO;
        public CustomerServiceImpl(){
            this.customerDAO = new CustomerDAOImpl(sessionFactory.createEntityManager());
        }

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