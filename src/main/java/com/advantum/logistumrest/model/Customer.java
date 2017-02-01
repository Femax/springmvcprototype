package com.advantum.logistumrest.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;


@Entity
@Table(name = "customer")
public class Customer {

    public static final PasswordEncoder PASSWORD_ENCODER = new BCryptPasswordEncoder();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String login;
    @JsonIgnore
    private String password;
    private String contactName;
    private String loadingContactName;
    private String offloadingContactName;
    private String loadingPhone;
    private String offloadingPhone;
    private String[] roles;

    public Customer() {
    }

    public Customer(String contactName, String loadingContactName, String offloadingContactName, String login, String password, String loadingPhone, String offloadingPhone, String... roles) {
        this.contactName = contactName;
        this.loadingContactName = loadingContactName;
        this.offloadingContactName = offloadingContactName;
        this.loadingPhone = loadingPhone;
        this.offloadingPhone = offloadingPhone;
        this.login = login;
        this.setPassword(password);
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getLoadingContactName() {
        return loadingContactName;
    }

    public void setLoadingContactName(String loadingContactName) {
        this.loadingContactName = loadingContactName;
    }

    public String getOffloadingContactName() {
        return offloadingContactName;
    }

    public void setOffloadingContactName(String offloadingContactName) {
        this.offloadingContactName = offloadingContactName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = PASSWORD_ENCODER.encode(password);
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public String getLoadingPhone() {
        return loadingPhone;
    }

    public void setLoadingPhone(String loadingPhone) {
        this.loadingPhone = loadingPhone;
    }

    public String getOffloadingPhone() {
        return offloadingPhone;
    }

    public void setOffloadingPhone(String offloadingPhone) {
        this.offloadingPhone = offloadingPhone;
    }

//    public long getTicketId() {
//        return ticketId;
//    }
//
//    public void setTicketId(long ticketId) {
//        this.ticketId = ticketId;
//    }


}
