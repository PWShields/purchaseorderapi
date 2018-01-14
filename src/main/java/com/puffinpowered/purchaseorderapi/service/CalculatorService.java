package com.puffinpowered.purchaseorderapi.service;


import com.puffinpowered.purchaseorderapi.domain.Result;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;

import java.util.List;

public interface CalculatorService {
    Result calculateTotals(List<PurchaseOrderProduct> products);

    void generateReport(Result totals);
}
