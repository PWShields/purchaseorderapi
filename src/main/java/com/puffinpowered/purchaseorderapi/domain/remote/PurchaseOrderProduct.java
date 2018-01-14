package com.puffinpowered.purchaseorderapi.domain.remote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents the PurcahseOrderProduct subsection of the data
 * section in the response from the Remote API
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PurchaseOrderProduct {
     @JsonProperty("Product")
    private Product product;

     private double unit_quantity_initial;

    public PurchaseOrderProduct() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getUnit_quantity_initial() {
        return unit_quantity_initial;
    }

    public void setUnit_quantity_initial(double unit_quantity_initial) {
        this.unit_quantity_initial = unit_quantity_initial;
    }
}
