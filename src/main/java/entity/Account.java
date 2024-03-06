package entity;
import entity.base.BaseEntity;
import jakarta.persistence.*;

@Entity
@Table(name = "Account")
public class Account {

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "balance")
    private double balance;

   @ManyToOne
   @JoinColumn(name = "customer_id", nullable = false)
   private Customer customer;



//    // Getters and Setters
//    public Long getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(Long accountId) {
//        this.accountId = accountId;
//    }
//
//       public double getBalance() {
//        return balance;
//    }
//
//     public void setBalance(double balance) {
//        this.balance = balance;
//    }
//
//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }
}
