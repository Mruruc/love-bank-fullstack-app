package com.mruruc.login.model;

import com.mruruc.client.model.Client;
import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "user_id_generator")
    @SequenceGenerator(name = "user_id_generator" , allocationSize = 1)
    private Long loginId;
    @Column(unique = true)
    private String userName;
    @Column(nullable = false)
    private String password;
    private LocalDateTime lastLogin;
    private Integer failedLoginAttempts;
    private Boolean accountLocked;
    private String passwordResetToken;
    private LocalDateTime tokenExpiration;
    @OneToOne
    @JoinColumn(name="client_id")
    private Client client;

    public User(){}


    public Long getLoginId() {
        return loginId;
    }

    public void setLoginId(Long loginId) {
        this.loginId = loginId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Integer getFailedLoginAttempts() {
        return failedLoginAttempts;
    }

    public void setFailedLoginAttempts(Integer failedLoginAttempts) {
        this.failedLoginAttempts = failedLoginAttempts;
    }

    public Boolean getAccountLocked() {
        return accountLocked;
    }

    public void setAccountLocked(Boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public String getPasswordResetToken() {
        return passwordResetToken;
    }

    public void setPasswordResetToken(String passwordResetToken) {
        this.passwordResetToken = passwordResetToken;
    }

    public LocalDateTime getTokenExpiration() {
        return tokenExpiration;
    }

    public void setTokenExpiration(LocalDateTime tokenExpiration) {
        this.tokenExpiration = tokenExpiration;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "UserLogin{" +
                "loginId=" + loginId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", lastLogin=" + lastLogin +
                ", failedLoginAttempts=" + failedLoginAttempts +
                ", accountLocked=" + accountLocked +
                ", passwordResetToken='" + passwordResetToken + '\'' +
                ", tokenExpiration=" + tokenExpiration +
                '}';
    }



}
