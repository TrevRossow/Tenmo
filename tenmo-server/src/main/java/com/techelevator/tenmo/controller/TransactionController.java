package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.TransactionDao;
import com.techelevator.tenmo.model.Transaction;
import org.springframework.web.bind.annotation.*;
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
        List<Transaction> transaction= transactionDao.getAllTransactions(userId);
        return transaction;
    }

    @RequestMapping(path = "/transfer/{id}", method =RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable("id") int transactionId){ //
        Transaction str = transactionDao.getTransactionById(transactionId);
        return str;
    }

}
