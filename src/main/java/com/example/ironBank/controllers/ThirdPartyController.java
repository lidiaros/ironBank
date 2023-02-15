package com.example.ironBank.controllers.user;
import com.example.ironBank.models.account.Account;
import com.example.ironBank.services.user.ThirdPartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class ThirdPartyController {

    @Autowired
    ThirdPartyService thirdPartyService;

    public Account sendMoneyToOtherAccount(){
        return null;
    }

    public Account receiveMonteFromOtherAccount(){
        return null;
    }
}