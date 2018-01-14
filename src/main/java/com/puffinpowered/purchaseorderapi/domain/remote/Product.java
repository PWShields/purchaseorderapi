package com.puffinpowered.purchaseorderapi.domain.remote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Represents the fields in the product subsection of the PurchaseOrderProduct
 *  from the remote API response
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private int product_type_id;
    private double volume;
    private double weight;

    //This is a bit of workaround - this value comes from the owning PurchaseOrderProduct
    private double quantity;

    public Product() {
    }

    public Product(int product_type_id, double volume, double weight) {
        this.product_type_id = product_type_id;
        this.volume = volume;
        this.weight = weight;
    }

    public Product(int product_type_id, double volume) {
        this.product_type_id = product_type_id;
        this.volume = volume;
    }



    public int getProduct_type_id() {
        return product_type_id;
    }

    public void setProduct_type_id(int product_type_id) {
        this.product_type_id = product_type_id;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
