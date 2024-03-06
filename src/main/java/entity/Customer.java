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
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;



    @OneToMany(mappedBy = "customer_id", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

//    // Getters and Setters
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public List<Account> getAccounts() {
//        return accounts;
//    }
//
//    public void setAccounts(List<Account> accounts) {
//        this.accounts = accounts;
//    }
}