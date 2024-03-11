package entity;
import entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {
    public Account() {
    }

    public Account(Integer balance, String currency, Customer customer) {
        this.balance = balance;
        this.customer = customer;
        this.currency = currency;
    }

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Integer accountId;

    @Column(name = "balance")
    private double balance;

    @Column(name = "currency")
    private String currency;

   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;




    public Integer getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", currency='" + currency + '\'' +
                '}';
    }
}
