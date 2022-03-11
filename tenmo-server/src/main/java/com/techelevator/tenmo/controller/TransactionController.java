package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class TransactionController {


    private TransactionDao transactionDao;

    public TransactionController(TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
    }

    //setting up endpoint for the transfer
    @RequestMapping(path = "/transfer/{id}", method = RequestMethod.POST)
    public String sendTransferReq (@RequestBody Transaction transaction) {
        String str= transactionDao.sendTransfer(transaction.getAccountFrom(), transaction.getAccountTo(), transaction.getAmount());
        return str;
    }

    @RequestMapping(path = "/transfer/{id}", method =RequestMethod.GET)
    public List<Transaction> getAllTransactions(@PathVariable("id") int userId){ //
    List<Transaction> transaction= transactionDao.getTransactionById(ac);

    return transaction;

    }

//    @RequestMapping(path = "/balance/{id}", method = RequestMethod.GET)
//    public BigDecimal getBalance(@PathVariable("id") int userId) {
//        BigDecimal balance = accountDao.getBalance(userId);
//        return balance;
//    }

}
