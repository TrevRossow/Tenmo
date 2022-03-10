package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionDao {
    public List<Transaction> getAllTransactions(int accountId);
    public Transaction getTransactionById(int transactionId);
    public String transfer(int transferFrom, int transferTo, BigDecimal amount);
    public String transferFromUser(int transferFrom, int transferTo, BigDecimal amount);
    public List<Transaction> getPending(int accountId);
    public String updateTransactionRequest(Transaction transaction, int statusId);
}
