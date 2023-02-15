package com.example.ironBank.models.account;
import com.example.ironBank.models.user.AccountHolders;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class StudentChecking extends Account {

    private LocalDate creationDate = LocalDate.now();

    public StudentChecking() {
    }

    public StudentChecking(BigDecimal balance, Integer secretKey, AccountHolders primaryOwner,
                           AccountHolders secondaryOwner, BigDecimal penaltyFee) {
        super(balance, secretKey, primaryOwner, secondaryOwner, penaltyFee);
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}