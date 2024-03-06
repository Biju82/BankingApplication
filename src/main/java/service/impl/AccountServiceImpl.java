import dao.AccountDAO;
import entity.Account;
import org.hibernate.Session;
import service.AccountService;
import service.base.BaseService;

public class AccountServiceImpl extends BaseService implements AccountService {

    private final AccountDAO accountDAO;

    public AccountServiceImpl(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    @Override
    public Double getBalance(Long accountId) {
        Session session = sessionFactory.openSession();
        Double balance = null;
        try {
            session.beginTransaction();
            Account account = session.get(Account.class, accountId);
            if (account != null) {
                balance = account.getBalance();
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace(); // Handle exception as needed
        } finally {
            session.close();
        }
        return balance;
    }
}

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

