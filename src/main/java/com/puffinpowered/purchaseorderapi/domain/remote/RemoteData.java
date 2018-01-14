package com.puffinpowered.purchaseorderapi.domain.remote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents the data component of Remote API response, taking only the
 * subfields we are interested in
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class RemoteData {

    @JsonProperty("PurchaseOrderProduct")
    private List<PurchaseOrderProduct> purchaseOrderProduct;
    private int customer_id;

    public RemoteData() {
    }

    public List<PurchaseOrderProduct> getPurchaseOrderProduct() {
        return purchaseOrderProduct;
    }

    public void setPurchaseOrderProduct(List<PurchaseOrderProduct> purchaseOrderProduct) {
        this.purchaseOrderProduct = purchaseOrderProduct;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }


}
