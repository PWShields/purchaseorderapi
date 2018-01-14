package com.puffinpowered.purchaseorderapi.enums;

public enum Security {

    REALM("TEST_REALM");

    private String value;

    Security(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
