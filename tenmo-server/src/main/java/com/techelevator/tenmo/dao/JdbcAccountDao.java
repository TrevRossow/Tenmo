package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.math.BigDecimal;

public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public BigDecimal getBalance(int userId) {
        String sql = "SELECT balance FROM accounts WHERE user_id = ?";
        SqlRowSet results=null;
        BigDecimal balance=null;
        try{
            results = jdbcTemplate.queryForRowSet(sql, userId);
            if(results.next()) {
                balance=results.getBigDecimal("balance");
            }
        }catch(DataAccessException x) {
            System.out.println("Error: Unable to access!");
        }
        return balance;

    }

    @Override
    public Account getAccount(long accountId) {
        Account account = null;
        final String sql = "SELECT *\n" +
                "FROM account;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, accountId);
        if (results.next()) {
            account = mapRowToAccount()
        }
        return null;
    }

    @Override
    public Account findAccount(int accountId) {
        return null;
    }


    @Override
    public BigDecimal addToBalance(BigDecimal amountadd, int accountId) {
        return null;
    }

    @Override
    public BigDecimal subtractFromBalance(BigDecimal amountSub, int accountId) {
        return null;
    }

    private Account mapRowToAccount(SqlRowSet result) {
        Account account = new Account();
        account.setAccountId(result.getInt("account_id"));
        account.setUserId(result.getInt("user_id"));
        account.setBalance(result.getBigDecimal("balance"));
        return account;        
    }


}