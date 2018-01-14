package com.puffinpowered.purchaseorderapi.controller;

import com.puffinpowered.purchaseorderapi.domain.PurchaseOrders;
import com.puffinpowered.purchaseorderapi.domain.Result;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;
import com.puffinpowered.purchaseorderapi.service.AsyncService;
import com.puffinpowered.purchaseorderapi.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/async")
public class AsyncController {

    private static final Logger logger = LoggerFactory.getLogger(AsyncController.class);

    private AsyncService asyncService;
    private CalculatorService calculatorService;

    public AsyncController(AsyncService asyncService, CalculatorService calculatorService) {
        this.asyncService = asyncService;
        this.calculatorService = calculatorService;
    }

    @RequestMapping(value="/totals", method = RequestMethod.POST)  // { "purchase_order_ids": [2344, 2345, 2346] }
    public ResponseEntity<Result> calculateTotals(@RequestBody PurchaseOrders productIds){
        List<PurchaseOrderProduct> products = new ArrayList<>(3);

        List<CompletableFuture<List<PurchaseOrderProduct>>> allresults = productIds.getPurchase_order_ids().stream()
                .map(productId -> asyncService.fetchPurchaseOrderProductAsync(productId))
                .collect(Collectors.toList());

              for (CompletableFuture<List<PurchaseOrderProduct>> purchaseOrderProductList : allresults) {
                  try {
                      products.addAll(purchaseOrderProductList.get());
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } catch (ExecutionException e) {
                      e.printStackTrace();
                  }
              }
        Result totals = calculatorService.calculateTotals(products);
        calculatorService.generateReport(totals);
        return new ResponseEntity<Result>(totals, HttpStatus.OK);
    }


}
