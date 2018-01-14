package com.puffinpowered.purchaseorderapi.controller;


import com.puffinpowered.purchaseorderapi.domain.PurchaseOrders;
import com.puffinpowered.purchaseorderapi.domain.Result;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;
import com.puffinpowered.purchaseorderapi.service.CalculatorService;
import com.puffinpowered.purchaseorderapi.service.PurchaseOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class PurchaseOrderController {

    private static final Logger logger = LoggerFactory.getLogger(PurchaseOrderController.class);


    private PurchaseOrderService purchaseOrderService;
    private CalculatorService calculatorService;

         @Autowired
         public PurchaseOrderController(PurchaseOrderService purchaseOrderService, CalculatorService calculatorService) {
        this.purchaseOrderService = purchaseOrderService;
        this.calculatorService = calculatorService;
    }
       @RequestMapping("/")
    public String hello(){
             return "The Purchase order API is up";
         }


    @RequestMapping(value="test", method = RequestMethod.POST)  // { "purchase_order_ids": [2344, 2345, 2346] }
      public ResponseEntity<Result> calculateTotals(@RequestBody PurchaseOrders productIds){
        List<PurchaseOrderProduct> products = purchaseOrderService.fetchRemoteData(productIds.getPurchase_order_ids());
        Result totals = calculatorService.calculateTotals(products);
        calculatorService.generateReport(totals);
        return new ResponseEntity<Result>(totals, HttpStatus.OK);
      }


}
