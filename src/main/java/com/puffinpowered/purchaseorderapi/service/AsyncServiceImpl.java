package com.puffinpowered.purchaseorderapi.service;

import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderData;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncServiceImpl implements AsyncService {

    @Value("${purchaseOrdersUrl}")
    private String remoteUrl;
    @Value("${purchaseOrdersUrlVersion}")
    private String remoteUrlVersion;

    RestTemplate restTemplate;

    @Autowired
    public AsyncServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


      //For this annotation to work this method must be public and cannot be called from within this class
      //Just the way it works :(  And hence why I have bumped some of the business logic up to the controller
      //@Todo move the call to this method into another service
     @Async
    public CompletableFuture<List<PurchaseOrderProduct>> fetchPurchaseOrderProductAsync(int productId) {
        String requestString = remoteUrl+productId+remoteUrlVersion;
        ResponseEntity<PurchaseOrderData> result = restTemplate.exchange(
                requestString, HttpMethod.GET, null, PurchaseOrderData.class);
        List<PurchaseOrderProduct> purchaseOrderProducts = result.getBody().getData().getPurchaseOrderProduct();

        return CompletableFuture.completedFuture(purchaseOrderProducts);
    }


}
