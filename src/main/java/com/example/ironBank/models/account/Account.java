package com.example.ironBank.models.account;
import com.example.ironBank.models.user.AccountHolders;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;

@Entity
@Table(name="account")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Digits(integer = 4, fraction = 2)
    private BigDecimal balance;
    private Integer secretKey;
    @ManyToOne
    private AccountHolders primaryOwner;
    @ManyToOne
    private AccountHolders secondaryOwner;
    private BigDecimal penaltyFee=BigDecimal.valueOf(40);
    @Enumerated(EnumType.STRING)
    private Status status;

    public Long getId() {
        return accountId;
    }

    public void setId(Long id) {
        this.accountId = accountId;
    }


    public Account() {
    }

    public Account(BigDecimal balance, Integer secretKey, AccountHolders primaryOwner,
                   AccountHolders secondaryOwner, BigDecimal penaltyFee) {
        this.balance = balance;
        this.secretKey = secretKey;
        this.primaryOwner = primaryOwner;
        this.secondaryOwner = secondaryOwner;
        this.penaltyFee = penaltyFee;
        this.status = Status.ACTIVE;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Integer getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(Integer secretKey) {
        this.secretKey = secretKey;
    }

    public AccountHolders getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolders primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolders getSecondaryOwner() {
        return secondaryOwner;
    }

    public void setSecondaryOwner(AccountHolders secondaryOwner) {
        this.secondaryOwner = secondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
