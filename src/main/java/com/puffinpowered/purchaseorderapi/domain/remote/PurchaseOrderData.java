package com.puffinpowered.purchaseorderapi.domain.remote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.concurrent.CompletableFuture;

/**
 * Represents the wrapper response from Remote API
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderData extends CompletableFuture {

        private String info;
        private RemoteData data;

    public PurchaseOrderData() {
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String type) {
        this.info = type;
    }

    public RemoteData getData() {
        return data;
    }

    public void setData(RemoteData data) {
        this.data = data;
    }
}
