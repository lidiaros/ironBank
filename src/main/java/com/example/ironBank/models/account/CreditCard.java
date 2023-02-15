package com.example.ironBank.models.account;
import com.example.ironBank.models.user.AccountHolders;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import java.math.BigDecimal;

@Entity
public class CreditCard extends Account {
    @Max(value=100000)
    private BigDecimal creditLimit = BigDecimal.valueOf(100);
    @DecimalMin(value="0.1")
    private BigDecimal interestRate = BigDecimal.valueOf(0.2);

    public CreditCard() {
    }

    public CreditCard(BigDecimal balance, Integer secretKey, AccountHolders primaryOwner, AccountHolders secondaryOwner,
                      BigDecimal penaltyFee,  BigDecimal creditLimit, BigDecimal interestRate) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
