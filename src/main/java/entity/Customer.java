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

    public Customer(Integer customerId, String name, String email, String address) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
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
}