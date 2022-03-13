package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    public Transfer[] getTransfers() {
        Transfer[] transfers = null;
        String results;
        try {
            transfers = restTemplate.exchange(API_BASE_URL + "transfer/" + currentUser.getUser().getId(),
                    HttpMethod.GET, makeTransferAuthEntity(), Transfer[].class).getBody();
            System.out.println("-------------------------------------------");
            System.out.println("Transfers");
            System.out.println("ID          From/To                 Amount");
            System.out.println("-------------------------------------------");
            String fromTo = "";
            String name = "";
            assert transfers != null;
            for (Transfer result : transfers) {
                if(currentUser.getUser().getId() == result.getAccountFrom()) {
                    fromTo = " From: ";
                    name = result.getUserTo();
                } else {
                    fromTo = " To: ";
                    name = result.getUserFrom();
                }
                System.out.println(result.getTransferId() + fromTo + name + " " + result.getAmount());
            }
            System.out.println("---------");
            System.out.println("Please enter transfer ID to view details (0 to cancel): ");
        } catch (RestClientException x){
            System.out.println("Could not view your transaction history");
        }
        return transfers;
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
//            System.out.println("Could not view transfer history"); //Getting the exception path everytime.
//
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

    private HttpEntity<Void> makeTransferAuthEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(currentUser.getToken());
        return new HttpEntity<>(headers);
    }
}
