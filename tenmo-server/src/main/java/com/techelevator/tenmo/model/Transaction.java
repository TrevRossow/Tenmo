package com.techelevator.tenmo.model;

import java.math.BigDecimal;

public class Transaction {

    private int transferId;
    private String transferType;
    private int transferStatus;
    private int accountFrom;
    private int accountTo;
    private BigDecimal amount;
}
