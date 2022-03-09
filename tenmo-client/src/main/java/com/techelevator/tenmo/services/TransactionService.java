package com.techelevator.tenmo.services;

import org.springframework.web.client.RestTemplate;

public class TransactionService {

    private static final String API_BASE_URL = "http://localhost:8080/account/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Transaction listAccountBalance() {
        final String url = API_BASE_URL + "balance/";
        return this.restTemplate.getForObject(url, Transaction.class);
    }

//    public Transaction[] sendTeBucks() {
//        final String url = API_BASE_URL + "transfers/";
//        return this.restTemplate.getForObject(url, Transaction.class);
//    }

//    public Transaction getTransfers(int id) {
//        final String url = API_BASE_URL + "transfers/" + id;
//        return this.restTemplate.getForObject(url,Transaction.class);
//    }

    public Transaction getTransferDetails(int id) {
        final String url = API_BASE_URL + "hotels/" + hotelID + "/reviews";
              return this.restTemplate.getForObject(url, Transaction.class);
    }

    public Transaction requestTeBucks() {
        final String url = API_BASE_URL + "transfers/";
        return this.restTemplate.getForObject(url, Transaction.class);

    }
    public Transaction pendingRequests() {
        final String url = API_BASE_URL + "transfers/" ;
        return this.restTemplate.getForObject(url, Transaction.class);
}
