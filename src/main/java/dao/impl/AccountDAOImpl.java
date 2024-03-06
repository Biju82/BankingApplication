package dao.impl;
import dao.AccountDAO;
import jakarta.persistence.EntityManager;
import dao.base.BaseDAO;
import jakarta.persistence.Query;

public class AccountDAOImpl extends BaseDAO implements AccountDAO {

    public AccountDAOImpl(EntityManager entityManager) {
        super(entityManager);
    }
    @Override
    public Double getBalance(Long customerId) {
        Query query = entityManager.createQuery("SELECT SUM(a.balance) FROM Account a WHERE a.customer.id = :customerId", Double.class);
        query.setParameter("customerId", customerId);
        Double totalBalance = (Double) query.getSingleResult();
        return totalBalance != null ? totalBalance : 0.0;
    }

    }


