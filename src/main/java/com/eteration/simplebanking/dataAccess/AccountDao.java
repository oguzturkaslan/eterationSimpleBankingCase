package com.eteration.simplebanking.dataAccess;

import com.eteration.simplebanking.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Integer> {
    Account findByAccountNumber(String accountNumber);
}
