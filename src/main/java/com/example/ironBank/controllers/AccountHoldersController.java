package com.example.ironBank.controllers.user;
import com.example.ironBank.dtos.TransferDTO;
import com.example.ironBank.models.account.Account;
import com.example.ironBank.services.user.AccountHoldersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.example.ironBank.dtos.TransferDTO;
import java.math.BigDecimal;

@RestController
@RequestMapping("/user")
public class AccountHoldersController {
    @Autowired
    AccountHoldersService accountHoldersService;

    @GetMapping("/id{id}")
    @ResponseStatus(HttpStatus.OK)
    public BigDecimal findAccountById(@PathVariable Long id){
        return accountHoldersService.findAccountById(id);
    }

    @PostMapping("/send_money")
    @ResponseStatus(HttpStatus.OK)
    public Account transferToOtherAccount(@RequestBody TransferDTO transferDto){
        return accountHoldersService.transferToOtherAccount(transferDto);
    }
}
