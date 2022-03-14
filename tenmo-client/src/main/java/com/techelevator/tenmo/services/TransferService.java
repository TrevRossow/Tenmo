package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.web.client.RestTemplate;

public class TransferService {


    private static String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    final private AuthenticatedUser currentUser;

    public TransferService(String url, AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
        API_BASE_URL = url;
    }
//Services to pull information from server-side
    public Transfer listAccountBalance() {
        final String url = API_BASE_URL + "balance/";
        return this.restTemplate.getForObject(url, Transfer.class);
    }

    public Transfer getTransfers(int id) {
        final String url = API_BASE_URL + "transfer/" + id;
        return this.restTemplate.getForObject(url, Transfer.class);
    }

    public Transfer getTransferDetails() {
        final String url = API_BASE_URL + "search/";
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
