package com.eteration.simplebanking.services;


import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.dataAccess.AccountDao;
import com.eteration.simplebanking.dataAccess.TransactionDao;
import com.eteration.simplebanking.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountDao accountDao;

    @Autowired
    private TransactionDao transactionDao;

    @Override
    public Account findAccount(String accountNumber) {
        return accountDao.findByAccountNumber(accountNumber);
    }

    @Override
    public TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = accountDao.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new DepositTransaction(new Date(), amount, account, UUID.randomUUID().toString());
            account.post(transaction);
            transactionDao.save(transaction);
            accountDao.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException {
        Account account = accountDao.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new WithdrawalTransaction(new Date(), amount, account, UUID.randomUUID().toString());
            account.post(transaction);
            transactionDao.save(transaction);
            accountDao.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }

    @Override
    public TransactionStatus payPhoneBill(String accountNumber, double amount, String operatorName, String phoneNumber) throws InsufficientBalanceException {
        Account account = accountDao.findByAccountNumber(accountNumber);
        TransactionStatus transactionStatus;
        if (account != null) {
            Transaction transaction = new PhoneBillPaymentTransaction(new Date(), amount, account, UUID.randomUUID().toString(), operatorName, phoneNumber);
            account.post(transaction);
            transactionDao.save(transaction);
            accountDao.save(account);
            transactionStatus = new TransactionStatus("OK", transaction.getApprovalCode());
        } else {
            transactionStatus = new TransactionStatus("ERROR");
        }
        return transactionStatus;
    }


}
