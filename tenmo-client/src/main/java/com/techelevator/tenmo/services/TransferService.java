package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Transfer;
import org.springframework.web.client.RestTemplate;

public class TransferService {

    private static final String API_BASE_URL = "http://localhost:8080/account/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Transfer listAccountBalance() {
        final String url = API_BASE_URL + "balance/";
        return this.restTemplate.getForObject(url, Transfer.class);
    }
//TODO uncommented this part  SentTeBucks and getTransfers
//    public Transfer[] sendTeBucks() {
//        final String url = API_BASE_URL + "transfer/";
//        return this.restTemplate.getForObject(url, Transfer.class);
//    }

    public Transfer getTransfers(int id) {
        final String url = API_BASE_URL + "transfer/" + id;
        return this.restTemplate.getForObject(url, Transfer.class);
    }

    public Transfer getTransferDetails(int id) {
        final String url = API_BASE_URL + "transfer/" + " " + "/reviews";
        return this.restTemplate.getForObject(url, Transfer.class);
    }

    public Transfer requestTeBucks() {
        final String url = API_BASE_URL + "transfers/";
        return this.restTemplate.getForObject(url, Transfer.class);

    }

    public Transfer pendingRequests() {
        final String url = API_BASE_URL + "transfer/";
        return this.restTemplate.getForObject(url, Transfer.class);
    }
}
