package com.example.backend_chat.entities;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Account")
    private Long id_Account;
    @OneToOne
    @JoinColumn(name = "phoneProfile")
    private Profile_User profileUser;
    @Column(columnDefinition = "varchar(150)",nullable = false)
    private String password;
    @Column(columnDefinition = "nvarchar(30)",nullable = false)
    private String role;

    public Long getId_Account() {
        return id_Account;
    }

    public void setId_Account(Long id_Account) {
        this.id_Account = id_Account;
    }

    public Profile_User getProfile() {
        return profileUser;
    }

    public void setProfile(Profile_User profileUser) {
        this.profileUser = profileUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Account() {
    }

    public Account(String password, String role) {
        this.password = password;
        this.role = role;
    }

    @Override
    public String toString() {
        return "Account{" +
                "password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
