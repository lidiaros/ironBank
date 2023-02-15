package com.example.ironBank.services;
import com.example.ironBank.dtos.TransferDTO;
import com.example.ironBank.models.account.Account;
import com.example.ironBank.models.account.CheckingAccount;
import com.example.ironBank.models.account.SavingsAccount;
import com.example.ironBank.repositories.account.AccountRepository;
import com.example.ironBank.repositories.account.SavingsAccountRepository;
import com.example.ironBank.repositories.user.AccountHoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountHoldersService {
    @Autowired
    AccountHoldersRepository accountHoldersRepository;
    AccountRepository accountRepository;
    @Autowired
    SavingsAccountRepository savingsAccountRepository;

    public BigDecimal findAccountById(Long id) {
        return accountRepository.findById(id).get().getBalance();
    }

    public Account transferToOtherAccount(TransferDTO transferDTO) {
        Account sendingAccount = accountRepository.findById(transferDTO.getSendingID()).get();
        Account receivingAccount = accountRepository.findById(transferDTO.getReceivingID()).get();
        if (sendingAccount instanceof CheckingAccount) {
            CheckingAccount checkingAccount = (CheckingAccount) sendingAccount;
            if (checkingAccount.getBalance().compareTo(checkingAccount.getMinimumBalance()) > 0) {
                checkingAccount.setBalance(checkingAccount.getBalance().subtract(checkingAccount.getPenaltyFee()));
                return accountRepository.save(checkingAccount);
            } else if (sendingAccount instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) sendingAccount;
                if (savingsAccount.getBalance().compareTo(savingsAccount.getMinimumBalance()) > 0) {
                    savingsAccount.setBalance(savingsAccount.getBalance().subtract(savingsAccount.getPenaltyFee()));
                    return accountRepository.save(savingsAccount);
                }
            }
        }
        sendingAccount.setBalance(sendingAccount.getBalance());
        receivingAccount.setBalance(receivingAccount.getBalance());
        return accountRepository.save(sendingAccount);
    }
}
