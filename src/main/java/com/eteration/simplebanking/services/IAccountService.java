package com.eteration.simplebanking.services;

import com.eteration.simplebanking.controller.TransactionStatus;
import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.InsufficientBalanceException;
import com.eteration.simplebanking.model.Transaction;

public interface IAccountService {

    Account findAccount(String accountNumber);

    TransactionStatus credit(String accountNumber, double amount) throws InsufficientBalanceException;

    TransactionStatus debit(String accountNumber, double amount) throws InsufficientBalanceException;

    TransactionStatus payPhoneBill(String accountNumber, double amounts,String operatorName,String phoneNumber) throws InsufficientBalanceException;
}
