package com.puffinpowered.purchaseorderapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This is a mapper class to bridge the gap between the API and what we need
 */
public class SingleProductResult {

    public SingleProductResult(int product_type_id, double calculatedTotal) {
        this.product_type_id = product_type_id;
        this.calculatedTotal = calculatedTotal;
    }

    public SingleProductResult() {
    }

    private int product_type_id;

    @JsonProperty("total")
    private double calculatedTotal; //quantity times unit of measure

    public int getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(int product_type_id) {
        this.product_type_id = product_type_id;
    }

    public double getCalculatedTotal() {
        return calculatedTotal;
    }

    public void setCalculatedTotal(double calculatedTotal) {
        this.calculatedTotal = calculatedTotal;
    }
}
