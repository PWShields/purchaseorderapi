package com.puffinpowered.purchaseorderapi.service;


import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface AsyncService {

    CompletableFuture<List<PurchaseOrderProduct>> fetchPurchaseOrderProductAsync(int i);
}
