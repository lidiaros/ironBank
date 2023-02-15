package com.example.ironBank.controllers.user;
import com.example.ironBank.dtos.AccountDTO;
import com.example.ironBank.models.account.*;
import com.example.ironBank.models.user.ThirdParty;
import com.example.ironBank.services.user.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
public class AdminsController {
    @Autowired
    AdminsService adminsService;

    @PostMapping("/add_checking_account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addCheckingAccount(@RequestBody AccountDTO accountDTO) {
        return adminsService.addCheckingAccount(accountDTO);
    }

    @PostMapping("/add_savings_account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addSavingsAccount(@RequestBody SavingsAccount savingsAccount){
        return adminsService.addSavingsAccount(savingsAccount);
    }

    @PostMapping("/add_credit_card_account")
    @ResponseStatus(HttpStatus.CREATED)
    public Account addCreditCardAccount(@RequestBody CreditCard creditCard){
        return adminsService.addCreditCardAccount(creditCard);
    }

    @PatchMapping("/{balance}")
    @ResponseStatus(HttpStatus.OK)
    private Account updateBalance(@PathVariable Long id, @RequestParam BigDecimal balance){
        return adminsService.updateCheckingAccountBalance(id, balance);
    }

    @PatchMapping("/add_third_party")
    @ResponseStatus(HttpStatus.CREATED)
    public ThirdParty addThirdParty(@RequestBody ThirdParty thirdParty){
        return adminsService.addThirdParty(thirdParty);
    }

    @DeleteMapping("/account{id}")
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void deleteAccount(@PathVariable("id") Long id){
        adminsService.deleteById(id);
    }
}
