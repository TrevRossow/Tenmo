package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class JdbcTransactionDao implements TransactionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private AccountDao accountDao;

    public JdbcTransactionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        return null;
    }

    @Override
    public String sendTransfer(int transferFrom, int transferTo, BigDecimal amount) {
        final String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                "VALUES(2,2,?,?,?)";

        jdbcTemplate.update(sql, transferFrom, transferTo, amount);
        accountDao.addToBalance(amount, transferTo);
        accountDao.subtractFromBalance(amount, transferFrom);
        return "Your transaction is complete";
    }

    @Override
    public String transferFromUser(int transferFrom, int transferTo, BigDecimal amount) {
        final String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount) " +
                            "VALUES (1,1,?,?,?)";
        jdbcTemplate.update(sql, transferFrom, transferTo, amount);
        accountDao.subtractFromBalance(amount, transferFrom);
        accountDao.addToBalance(amount, transferTo);
        return "Your transaction is complete";
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
