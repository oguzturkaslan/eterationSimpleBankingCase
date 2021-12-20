package com.eteration.simplebanking.controller;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.services.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

// This class is a place holder you can change the complete implementation
@Controller
@RequestMapping(value = "/account/v1")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> getAccount(@PathVariable String accountNumber) {
        return ResponseEntity.ok(accountService.findAccount(accountNumber));
    }

    @PostMapping("/credit/{accountNumber}")
    public ResponseEntity<TransactionStatus> credit(@PathVariable String accountNumber, @RequestBody DepositTransaction transaction) throws InsufficientBalanceException {
        return ResponseEntity.ok(accountService.credit(accountNumber, transaction.getAmount()));
    }

    @PostMapping("/debit/{accountNumber}")
    public ResponseEntity<TransactionStatus> debit(@PathVariable String accountNumber, @RequestBody WithdrawalTransaction transaction) throws InsufficientBalanceException {
        return ResponseEntity.ok(accountService.debit(accountNumber, transaction.getAmount()));
    }

    @PostMapping("/paybill/{accountNumber}")
    public ResponseEntity<TransactionStatus> payPhoneBill(@PathVariable String accountNumber, @RequestBody PhoneBillPaymentTransaction transaction) throws InsufficientBalanceException {
        return ResponseEntity.ok(accountService.payPhoneBill(accountNumber, transaction.getAmount(), transaction.getOperatorName(), transaction.getPhoneNumber()));
    }
}