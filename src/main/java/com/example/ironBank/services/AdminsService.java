package com.example.ironBank.services;
import com.example.ironBank.dtos.AccountDTO;
import com.example.ironBank.models.account.*;
import com.example.ironBank.models.user.AccountHolders;
import com.example.ironBank.models.user.ThirdParty;
import com.example.ironBank.repositories.account.AccountRepository;
import com.example.ironBank.repositories.user.AccountHoldersRepository;
import com.example.ironBank.repositories.user.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;

@Service
public class AdminsService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountHoldersRepository accountHoldersRepository;

    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    public Account addCheckingAccount(AccountDTO checkingAccount) {
        AccountHolders primaryOwner = accountHoldersRepository.findById(checkingAccount.getPrimaryOwnerId()).get();
        AccountHolders secondaryOwner = null;
        if(checkingAccount.getSecondaryOwnerId() != null) secondaryOwner = accountHoldersRepository.findById(checkingAccount.getSecondaryOwnerId()).get();
        int age = Period.between(primaryOwner.getDateOfBirth(), LocalDate.now()).getYears();
        if (age>=18){
            return accountRepository.save(new CheckingAccount(checkingAccount.getBalance(),checkingAccount.getSecretKey(), primaryOwner, secondaryOwner, checkingAccount.getPenaltyFee(), checkingAccount.getMinimumBalance(), checkingAccount.getMonthlyMaintenanceFee()));
        } else {
            return accountRepository.save(new StudentChecking(checkingAccount.getBalance(),checkingAccount.getSecretKey(),primaryOwner, secondaryOwner,checkingAccount.getPenaltyFee()));
        }
    }

    public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
        return accountRepository.save(new SavingsAccount(savingsAccount.getBalance(),savingsAccount.getSecretKey(), savingsAccount.getPrimaryOwner(), savingsAccount.getSecondaryOwner(), savingsAccount.getPenaltyFee(), savingsAccount.getMinimumBalance(), savingsAccount.getInterestRate()));
    }

    public CreditCard addCreditCardAccount(CreditCard creditCard) {
        return accountRepository.save(new CreditCard(creditCard.getBalance(), creditCard.getSecretKey(), creditCard.getPrimaryOwner(), creditCard.getSecondaryOwner(), creditCard.getPenaltyFee(), creditCard.getCreditLimit(), creditCard.getInterestRate()));
    }

    public Account updateCheckingAccountBalance (Long id, BigDecimal balance){
        Account account = accountRepository.findById(id).get();
        account.setBalance(balance);
        return accountRepository.save(account);
    }

    public ThirdParty addThirdParty(ThirdParty thirdParty){
        return thirdPartyRepository.save(new ThirdParty(thirdParty.getHashedKey(),thirdParty.getName()));
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }
}