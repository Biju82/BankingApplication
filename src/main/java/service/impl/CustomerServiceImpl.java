package service.impl;

import dao.CustomerDAO;
import dao.impl.CustomerDAOImpl;
import entity.Customer;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import service.CustomerService;
import service.base.BaseService;

import java.util.List;


    @Service
    public class CustomerServiceImpl extends BaseService implements CustomerService {

        private CustomerDAO customerDAO;


        public CustomerServiceImpl(){

            this.customerDAO = new CustomerDAOImpl(sessionFactory.createEntityManager());
        }

        @Override
        public Customer addCustomer(Customer customer){
            return customerDAO.addCustomer(customer);

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