package com.puffinpowered.purchaseorderapi.domain;

import java.util.List;

/**
 * This is the object that represents our RequestBody
 */
public class PurchaseOrders {
    private List<Integer>  purchase_order_ids;

    public PurchaseOrders() {
    }

    public PurchaseOrders(List<Integer> purchase_order_ids) {
        this.purchase_order_ids = purchase_order_ids;
    }

    public List<Integer> getPurchase_order_ids() {
        return purchase_order_ids;
    }

    public void setPurchase_order_ids(List<Integer> purchase_order_ids) {
        this.purchase_order_ids = purchase_order_ids;
    }
}
