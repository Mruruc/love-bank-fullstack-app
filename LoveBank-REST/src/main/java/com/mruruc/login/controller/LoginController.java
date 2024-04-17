package com.mruruc.login.controller;

import com.mruruc.account.model.BankAccount;
import com.mruruc.account.service.AccountService;
import com.mruruc.login.exceptions.UserNotFoundException;
import com.mruruc.login.model.User;
import com.mruruc.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/login")
public class LoginController {
    private LoginService loginService;
    private AccountService accountService;

    @Autowired
    public LoginController(LoginService loginService,AccountService accountService){
        this.accountService=accountService;
        this.loginService=loginService;
    }

    @RequestMapping(path = "/getAllUsers",
            method = RequestMethod.GET)
    public List<User> getUser(){
       return loginService.getUsers();
    }

    @PostMapping(value = "/",
                produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<BankAccount> login(@RequestBody User user){
        Optional<User> userByPassword =
                loginService.getUserByPassword(user);
        if(userByPassword.isPresent()){
            Optional<BankAccount> accountByClientId =
                    accountService.getAccountByClientId(user.getClient().getId());
            return ResponseEntity.ok(accountByClientId.get());
        }

        throw new UserNotFoundException("User Not Found");
    }
}
