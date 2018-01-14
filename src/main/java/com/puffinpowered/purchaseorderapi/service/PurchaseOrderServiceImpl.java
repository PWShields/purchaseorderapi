package com.puffinpowered.purchaseorderapi.service;

import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderData;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{

    @Value("${purchaseOrdersUrl}")
    private String remoteUrl;
    @Value("${purchaseOrdersUrlVersion}")
    private String remoteUrlVersion;

    RestTemplate restTemplate;


    @Autowired
    public PurchaseOrderServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public List<PurchaseOrderProduct> fetchRemoteData(List<Integer> productIds) {
        List<PurchaseOrderProduct> purchaseOrderProductList = new ArrayList<>();
        productIds.parallelStream().forEach(  productId ->
                purchaseOrderProductList.addAll(fetchPurchaseOrderProduct(productId))
        );

        return purchaseOrderProductList;
    }


    private List<PurchaseOrderProduct> fetchPurchaseOrderProduct(int productId) {
        String requestString = remoteUrl+productId+remoteUrlVersion;
        ResponseEntity<PurchaseOrderData> result = restTemplate.exchange(
                requestString, HttpMethod.GET, null, PurchaseOrderData.class);
        List<PurchaseOrderProduct> purchaseOrderProducts = result.getBody().getData().getPurchaseOrderProduct();
        return purchaseOrderProducts;
    }


    public String getRemoteUrl() {
        return remoteUrl;
    }

    public void setRemoteUrl(String remoteUrl) {
        this.remoteUrl = remoteUrl;
    }

    public String getRemoteUrlVersion() {
        return remoteUrlVersion;
    }

    public void setRemoteUrlVersion(String remoteUrlVersion) {
        this.remoteUrlVersion = remoteUrlVersion;
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}
