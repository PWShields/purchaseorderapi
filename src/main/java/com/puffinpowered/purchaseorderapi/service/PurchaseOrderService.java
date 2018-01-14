package com.puffinpowered.purchaseorderapi.service;


import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;

import java.util.List;

public interface PurchaseOrderService {

    List<PurchaseOrderProduct> fetchRemoteData(List<Integer> productIds);

}
