package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.List;


public class JdbcTransactionDao implements TransactionDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public String sendTransfer(int transferFrom, int transferTo, BigDecimal amount) {
        final String sql = "";
        
        return null;
    }

    @Override
    public String transferFromUser(int transferFrom, int transferTo, BigDecimal amount) {
        return null;
    }

    @Override
    public List<Transaction> getPending(int accountId) {
        return null;
    }

    @Override
    public String updateTransactionRequest(Transaction transaction, int statusId) {
        return null;
    }

    @Override
    public List<Transaction> getAllTransactions(int accountId) {
        return null;
    }
}
