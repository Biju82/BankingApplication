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
        public Customer addCustomer(Customer customer) {
            return customerDAO.addCustomer(customer);

        }}