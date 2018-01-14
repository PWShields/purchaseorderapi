package com.puffinpowered.cartoncloud

import com.puffinpowered.purchaseorderapi.domain.Result
import com.puffinpowered.purchaseorderapi.domain.remote.Product
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct
import com.puffinpowered.purchaseorderapi.service.CalculatorService
import com.puffinpowered.purchaseorderapi.service.CalculatorServiceImpl
import spock.lang.Shared
import spock.lang.Specification

class CalculatorServiceSpec extends Specification{

    @Shared
    List<PurchaseOrderProduct> products
    @Shared
    CalculatorService calculatorService

    def setup(){
        calculatorService = new CalculatorServiceImpl()
        Product product1 = new Product(1,0.5, 1.5)
        Product product2 = new Product(1,1.5, 1)
        PurchaseOrderProduct purchaseOrderProduct1 = new PurchaseOrderProduct()
        purchaseOrderProduct1.setUnit_quantity_initial(5)
        purchaseOrderProduct1.setProduct(product1)
        PurchaseOrderProduct purchaseOrderProduct2 = new PurchaseOrderProduct()
        purchaseOrderProduct2.setUnit_quantity_initial(10)
        purchaseOrderProduct2.setProduct(product2)
        products = Arrays.asList(purchaseOrderProduct1,purchaseOrderProduct2)

    }

    def "Totals are accurate" (){
        given: "A list of products"
        when: "we calculate the totals"
        Result results = calculatorService.calculateTotals(products)
        then:"the results are accurate"
        assert results != null
        assert  results.results.get(0).calculatedTotal == 17.5
        assert results.results.get(0).product_type_id == 1
    }

}
