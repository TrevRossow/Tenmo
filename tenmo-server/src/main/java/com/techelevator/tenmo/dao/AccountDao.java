package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;

import java.math.BigDecimal;

public interface AccountDao {
    Account findAccount(int accountId);

    Account getAccount(long accountId);

    BigDecimal getBalance(int userId);

    BigDecimal addToBalance(BigDecimal amountadd, int accountId);

    BigDecimal subtractFromBalance(BigDecimal amountSub, int accountId);
}
