package com.puffinpowered.purchaseorderapi.enums;

/**
 * Add any new product types here only
 */
public enum ProductType {

        PRODUCT_TYPE_1(1, "weight"),
        PRODUCT_TYPE_2(2, "volume"),
        PRODUCT_TYPE_3(3, "weight");

    private int type;
    private String unit;

    ProductType(int type, String unit) {
        this.type = type;
        this.unit = unit;
    }

}
