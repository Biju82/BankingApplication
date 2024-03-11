package entity;

import entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity(name = "Customer")
//@Data                                   //asigura getters/ setters
//@NoArgsConstructor                      //asigura constructorul neparametrizat
//@RequiredArgsConstructor                //asiguratoate variatile nenule de constructori
//@EqualsAndHashCode(callSuper = true, exclude = "Account")    //
//@ToString(exclude = "Account")                               //
public class Customer {

    public Customer() {
    }

    public Customer( String name, String email, String address,String password) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    private List<Account> accounts;

    @OneToMany(mappedBy = "customer")
    private List<Transaction> transactions;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                '}';
    }
}