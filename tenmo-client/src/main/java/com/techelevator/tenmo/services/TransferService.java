package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

public class TransferService {

    private static String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    final private AuthenticatedUser currentUser;

    public TransferService(String url, AuthenticatedUser currentUser) {
        this.currentUser = currentUser;
        API_BASE_URL = url;
    }

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

    public Transfer getTransferDetails() {
        final String url = API_BASE_URL + "search/";
        return this.restTemplate.getForObject(url, Transfer.class);
    }

//    public BigDecimal getBalance() {
//        BigDecimal balance = new BigDecimal(0);
//        try {
//            balance = restTemplate.exchange(API_BASE_URL + "balance/" + currentUser.getUser().getId(),
//                    HttpMethod.GET, makeAccountAuthEntity(), BigDecimal.class).getBody();
//            System.out.println("Your current account balance is: " + balance);
//        } catch (RestClientException e) {
//            System.out.println("Could not get balance"); //Getting the exception path everytime.
//            // I think problem coming from server side.
//        }
//        return balance;
//    }

    public Transfer requestTeBucks() {
        final String url = API_BASE_URL + "transfers/";
        return this.restTemplate.getForObject(url, Transfer.class);

    }

    public Transfer pendingRequests() {
        final String url = API_BASE_URL + "transfer/";
        return this.restTemplate.getForObject(url, Transfer.class);
    }
}
