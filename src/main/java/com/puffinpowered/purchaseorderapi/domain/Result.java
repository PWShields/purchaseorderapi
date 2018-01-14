package com.puffinpowered.purchaseorderapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * This is a wrapper class to enable us to match the required JSON response without having to manually build it
 *
 */
public class Result {

    @JsonProperty("result")
    List<SingleProductResult> results;

    public Result() {
    }

    public Result(List<SingleProductResult> results) {
        this.results = results;
    }

    public List<SingleProductResult> getResults() {
        return results;
    }

    public void setResults(List<SingleProductResult> results) {
        this.results = results;
    }
}
