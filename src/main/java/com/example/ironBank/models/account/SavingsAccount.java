package com.example.ironBank.models.account;
import com.example.ironBank.models.user.AccountHolders;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class SavingsAccount extends Account {
    @DecimalMin(value="100")
    private BigDecimal minimumBalance = BigDecimal.valueOf(1000);

    @DecimalMax(value="0.5")
    private BigDecimal interestRate = BigDecimal.valueOf(0.0025);

    private LocalDate creationDate = LocalDate.now();


    public SavingsAccount() {
    }

    public SavingsAccount(BigDecimal balance, Integer secretKey,
                          AccountHolders primaryOwner, AccountHolders secondaryOwner, BigDecimal penaltyFee,  BigDecimal minimumBalance, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;

    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}