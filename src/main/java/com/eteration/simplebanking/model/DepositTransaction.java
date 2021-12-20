package com.eteration.simplebanking.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("DepositTransaction")
public class DepositTransaction extends Transaction {

    private static final long serialVersionUID = 1L;

    public DepositTransaction() {
    }

    public DepositTransaction(double amount) {
        super(amount);
    }

    public DepositTransaction(Date date, double amount, Account account, String approvalCode) {
        super(date, amount, account, approvalCode);
    }
}
