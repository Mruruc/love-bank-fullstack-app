package com.mruruc.account.service;

import com.mruruc.account.model.BankAccount;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private List<BankAccount> bankAccountList=new LinkedList<>();
    public AccountService(){}

    public Optional<BankAccount> getAccountByClientId(Long clientId){
        BankAccount bankAccount=new BankAccount(new BigDecimal(5113), LocalDateTime.now(),null,1L);
        bankAccountList.add(bankAccount);
        return bankAccountList.stream()
                .filter(account -> account.getClientID() == clientId)
                .findFirst();
    }

}
