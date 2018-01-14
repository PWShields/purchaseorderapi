package com.puffinpowered.purchaseorderapi.service;

import com.puffinpowered.purchaseorderapi.domain.Result;
import com.puffinpowered.purchaseorderapi.domain.SingleProductResult;
import com.puffinpowered.purchaseorderapi.domain.remote.PurchaseOrderProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingDouble;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    private static final List<Integer> calculateTheWeight = new ArrayList<Integer>(( Arrays.asList(1,3)));

    @Override
    public Result calculateTotals(List<PurchaseOrderProduct> products) {

        List<SingleProductResult> singleProductResults = new ArrayList<SingleProductResult>(products.size());
                products.parallelStream().forEach(
                product-> {
                    double measure = 0;
                    if (calculateTheWeight.contains(product.getProduct().getProduct_type_id())) {
                        measure = product.getProduct().getWeight();
                    } else {
                        measure = product.getProduct().getVolume();
                    }
                    double quantity = measure * product.getUnit_quantity_initial();
                    singleProductResults.add(new SingleProductResult(product.getProduct().getProduct_type_id(), quantity));
                }
        );

        Map<Integer, Double> resultsList = singleProductResults.parallelStream().collect(groupingBy(SingleProductResult::getProduct_type_id, summingDouble((SingleProductResult::getCalculatedTotal))));
        List<SingleProductResult> finalResults = new ArrayList<SingleProductResult>(resultsList.size());

        resultsList.forEach(
                         (key, value) -> {
                            finalResults.add(new SingleProductResult(key, value));
                         }
                 );
      Result results = new Result( finalResults);
        return results;
    }

    @Override
    public void generateReport(Result totals) {
        totals.getResults().forEach(  total ->
                System.out.println("Product Type "+total.getProduct_type_id()+" has total of "+total.getCalculatedTotal())
        );

    }
}
