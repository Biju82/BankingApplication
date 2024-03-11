package entity;

import entity.base.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "Transaction")
public class Transaction {

    public Transaction(String transactionType, double amount, Customer customer) {
        LocalDate localDate = LocalDate.now();
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        this.customer = customer;
    }

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(name = "amount")
    private double amount;

    @Column(name = "description")
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;



    public Long getTransactionId() {
        return transactionId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String curency) {
        this.description = curency;
    }
}
