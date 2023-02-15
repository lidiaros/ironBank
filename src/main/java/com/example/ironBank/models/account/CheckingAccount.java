package com.example.ironBank.models.account;
import com.example.ironBank.models.user.AccountHolders;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class CheckingAccount extends Account {
    @Digits(integer = 4, fraction = 2)
    private BigDecimal minimumBalance=BigDecimal.valueOf(250);
    private BigDecimal monthlyMaintenanceFee=BigDecimal.valueOf(12);
    private LocalDate creationDate = LocalDate.now();

    public CheckingAccount() {
    }

    public CheckingAccount(BigDecimal balance, Integer secretKey, AccountHolders primaryOwner,
                           AccountHolders secondaryOwner, BigDecimal penaltyFee,  BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;

    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

}