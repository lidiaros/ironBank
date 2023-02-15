package com.example.ironBank.services;
import com.example.ironBank.dtos.TransferThirdPartyDTO;
import com.example.ironBank.models.account.Account;
import com.example.ironBank.repositories.account.AccountRepository;
import com.example.ironBank.repositories.user.ThirdPartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThirdPartyService {
    @Autowired
    ThirdPartyRepository thirdPartyRepository;

    @Autowired
    AccountRepository accountRepository;

    public Account sendMoney(TransferThirdPartyDTO transferThirdPartyDTO){
        Account receivingAccount = accountRepository.findById(transferThirdPartyDTO.getAccountId()).get();
        receivingAccount.setBalance(receivingAccount.getBalance());
        return accountRepository.save(receivingAccount);
    }

    public Account receiveMoney(TransferThirdPartyDTO transferThirdPartyDTO){
        Account sendingAccount = accountRepository.findById(transferThirdPartyDTO.getAccountId()).get();
        sendingAccount.setBalance(sendingAccount.getBalance());
        return accountRepository.save(sendingAccount);
    }
}